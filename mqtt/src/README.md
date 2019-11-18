# 1.本地搭建mqtt的broker服务器

### 1.1 使用actionMq作为broker服务器

下载地址https://activemq.apache.org/index.html

### 1.2 解压安装

```json
tar zxvf apache-activemq-5.15.10-bin.tar.gz
cd apache-activemq-5.15.10/bin
./activemq start
```

### 1.3 配置文件

![image-20191118205157023](/Users/qidi/Library/Application Support/typora-user-images/image-20191118205157023.png)

设置mqtt配置参数

![image-20191118205240331](/Users/qidi/Library/Application Support/typora-user-images/image-20191118205240331.png)

启动

# 2 配置spring boot的mqtt

### 1 配置文件application.properties

```properties
#MQTT配置信息
#MQTT-用户名
spring.mqtt.username=admin
#MQTT-密码
spring.mqtt.password=password
#MQTT-服务器连接地址，如果有多个，用逗号隔开，如：tcp://127.0.0.1:61613，tcp://192.168.2.133:61613
#使用activeMQ搭建broker服务器 1883默认
spring.mqtt.url=tcp://127.0.0.1:1883
#MQTT-连接服务器默认客户端ID
spring.mqtt.client.id=mqttId
#MQTT-默认的消息推送主题，实际可在调用接口时指定
spring.mqtt.default.topic=topic
#连接超时
spring.mqtt.completionTimeout=3000
```

### 2 配置连接参数

```java
@Configuration
public class MqttManagerConfig {

    @Value("${spring.mqtt.username}")
    private String username;

    @Value("${spring.mqtt.password}")
    private String password;

    @Value("${spring.mqtt.url}")
    private String hostUrl;

    @Value("${spring.mqtt.client.id}")
    private String clientId;

    @Value("${spring.mqtt.default.topic}")
    private String defaultTopic;

    /**
     * 读数据连接超时
     */
    @Value("${spring.mqtt.completionTimeout}")
    private int completionTimeout;
/**
     * 监控连接
     *
     * @return
     */
    @Bean
    public MqttConnectOptions getMqttConnectOptions() {
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setUserName(username);
        mqttConnectOptions.setPassword(password.toCharArray());
        mqttConnectOptions.setServerURIs(new String[]{hostUrl});
        mqttConnectOptions.setKeepAliveInterval(2);
        //自动重连,默认是false
//        mqttConnectOptions.setAutomaticReconnect(true);

        return mqttConnectOptions;
    }

    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setConnectionOptions(getMqttConnectOptions());
        return factory;
    }
}
```

### 3 配置发送oubound

```java
/**
 * 对外写出数据
 *
 * @return
 */
@ServiceActivator(inputChannel = "mqttOutboundChannel")
@Bean
public MessageHandler mqttOutbound() {
    MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler(clientId, mqttClientFactory());
    messageHandler.setAsync(true);
    messageHandler.setDefaultTopic(defaultTopic);
    return messageHandler;
}

/**
 * 发送通道
 *
 * @return
 */
@Bean
public MessageChannel mqttOutboundChannel() {
    return new DirectChannel();
}
```

配置输入inbound

```java
/**
 * 配置client,监听的topic
 */
@Bean
public MessageProducer inbound() {
    //监听topic
    MqttPahoMessageDrivenChannelAdapter adapter =
            new MqttPahoMessageDrivenChannelAdapter(hostUrl, clientId + "_inbound", mqttClientFactory(),
                    "hello", "hello1");
    adapter.setCompletionTimeout(completionTimeout);
    adapter.setConverter(new DefaultPahoMessageConverter());
    adapter.setQos(1);
    adapter.setOutputChannel(mqttInputChannel());
    return adapter;
}

/**
 * 连接通道
 *
 * @return
 */
@Bean
public MessageChannel mqttInputChannel() {
    return new DirectChannel();
}

/**
 * MqttHeaders是内部head的常量
 * ServiceActivator一个处理方法的实体类
 * 通过通道获取数据
 *
 * @return
 */
@Bean
@ServiceActivator(inputChannel = "mqttInputChannel")
public MessageHandler handler() {
    return new MessageHandler() {
        @Override
        public void handleMessage(Message<?> message) throws MessagingException {
            //head数据
            System.out.println(message.getHeaders().toString());
            //body数据
            System.out.println(message.getPayload().toString());
            //获取topic
            String topic = message.getHeaders().get(MqttHeaders.RECEIVED_TOPIC).toString();

            TopicManager topicManager = SpringUtils.getBean(TopicManager.class);
            //这里根据topic进行分发
            topicManager.dealTopic(topic, message);
        }
    };
}
```
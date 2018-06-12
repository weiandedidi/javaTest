package kafka.springKafka;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.serializer.StringDecoder;
import kafka.springKafka.entry.DbVideo;
import kafka.utils.VerifiableProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 使用DbVideoConsumerHandler作为操作类，在线程池中放入，启动worker线程
 * KafkaStream 是阻塞形式的数据集，想象成可以无限拓展，一直向里面放数据的结果集
 * 数据流处理器KafkaStream
 * ConsumerIterator<String, String> it = stream.iterator()  it.next()是阻塞模式的
 *
 * @author: qidima
 * @date: 2018/6/11
 * Time: 14:16
 */
@Component("dbVideoConsumerHandler")
public class DbVideoConsumerHandler {

    static Logger logger = LoggerFactory.getLogger(DbVideoConsumerHandler.class);
    private ConsumerConnector consumer;
    private String topic;
    private List<DbVideo> toInsertVideos;
    private ExecutorService executorPool;
    private Integer FIX_THREAD_SIZE;

    public void init() {
        Properties props = new Properties();
        try {
            props.load(DbVideoConsumerHandler.class.getClassLoader().getResourceAsStream("dbvideo.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ConsumerConfig config = new ConsumerConfig(props);
        ConsumerConnector consumerConnector = Consumer.createJavaConsumerConnector(config);
        consumer = consumerConnector;
        topic = props.getProperty("topic");
        toInsertVideos = new ArrayList<DbVideo>();
        FIX_THREAD_SIZE = Integer.parseInt((String) props.get("video.thread.fix.size"));
        //直接启动
        // 5. 创建线程池
        executorPool = Executors.newFixedThreadPool(FIX_THREAD_SIZE);
        start();
    }

    public void start() {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                // 2. 指定数据的解码器
                StringDecoder keyDecoder = new StringDecoder(new VerifiableProperties());
                StringDecoder valueDecoder = new StringDecoder(new VerifiableProperties());
                Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
                topicCountMap.put(topic, 3);
                // 3.获取连接数据的迭代器对象集合
                Map<String, List<KafkaStream<String, String>>> consumerMap = consumer.createMessageStreams(topicCountMap, keyDecoder, valueDecoder);
                // 4. 从返回结果中获取对应topic的数据流处理器
                List<KafkaStream<String, String>> streams = consumerMap.get(topic);
                // 6. 构建数据输出对象
                try {
                    for (KafkaStream stream : streams) {
                        executorPool.submit(new DbVideoConsumerWorker(stream));
                    }
                } catch (Throwable e) {
                    shutdown();
                    logger.error("Turn off Kafka consumer error! " + e);
                }
            }
        });
    }

    public void shutdown() {
        //1. 关闭和Kafka的连接，这样会导致stream.hashNext返回false
        if (consumer != null) {
            consumer.shutdown();
        }
        // 2. 关闭线程池，会等待线程的执行完成
        if (executorPool != null) {
            executorPool.shutdown();
            try {
                if (!executorPool.awaitTermination(10, TimeUnit.SECONDS)) {
                    logger.info("Timeout.... Ignore for this case");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        DbVideoConsumerHandler handler = new DbVideoConsumerHandler();
        handler.init();
    }

}

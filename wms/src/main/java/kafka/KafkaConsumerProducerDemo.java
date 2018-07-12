package kafka;


/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2018/6/11
 * Time: 11:46
 */
public class KafkaConsumerProducerDemo {
    public static void main(String[] args) {
        KafkaProducer producerThread = new KafkaProducer(KafkaProperties.topic);
//        producerThread.start();
        KafkaConsumer consumerThread = new KafkaConsumer(KafkaProperties.topic);
        consumerThread.start();
    }
}

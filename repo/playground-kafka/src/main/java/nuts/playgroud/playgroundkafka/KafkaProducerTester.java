package nuts.playgroud.playgroundkafka;

import nuts.playgroud.playgroundkafka.producer.KafkaProducerCallback;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Properties;
import java.util.concurrent.Future;

@Component
public class KafkaProducerTester implements CommandLineRunner {

    public void createKafkaProducer() {
        Properties props = new Properties();
        props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.56.101:9092");
        props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.setProperty(ProducerConfig.ACKS_CONFIG, "0");
//        props.setProperty("retries", "3");

        sendProducerRecord(props);
    }

    private void sendProducerRecord(Properties properties) {
        try (KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties)) {
            ProducerRecord<String, String> producerRecord = new ProducerRecord<>("topicName", "hello world");

            Future<RecordMetadata> send = kafkaProducer.send(producerRecord);

            kafkaProducer.send(producerRecord, (recordMetadata, e) -> {
                System.out.println(recordMetadata.partition() + " " + recordMetadata.offset());
            });

            ProducerRecord<String, String> recordUsingKey = new ProducerRecord<>("topicName", "key", "value");
            kafkaProducer.send(recordUsingKey, new KafkaProducerCallback());

        }
    }

    @Override
    public void run(String... args) throws Exception {
        KafkaProducerTester kafkaProducerTester = new KafkaProducerTester();
        kafkaProducerTester.createKafkaProducer();

    }
}
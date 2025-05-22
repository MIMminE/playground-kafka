package nuts.playgroud.playgroundkafka.consumer;

import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class KafkaConsumerTester {
    public static void main(String[] args) {
        // 1. Kafka 컨슈머 설정
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092"); // Kafka 브로커 주소
        props.put("group.id", "my-consumer-group");       // 컨슈머 그룹 ID
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer"); // 키 역직렬화
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer"); // 값 역직렬화
        props.put("enable.auto.commit", "false");         // 자동 커밋 여부 (false로 설정 시 수동 커밋)

        // 2. KafkaConsumer 객체 생성
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {

            // 3. 토픽 구독
            consumer.subscribe(Arrays.asList("topic1")); // 하나 이상의 토픽 구독
        }
    }
}

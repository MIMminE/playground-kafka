package nuts.playgroud.playgroundkafka;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Properties;

@RequiredArgsConstructor
public class KafkaConsumerTester implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        try (AdminClient adminClient = AdminClient.create(properties)) {
            NewTopic newTopic = new NewTopic("playground-kafka-topic", 1, (short) 1);
            adminClient.createTopics(Collections.singleton(newTopic)).all().get();
        }
    }
}
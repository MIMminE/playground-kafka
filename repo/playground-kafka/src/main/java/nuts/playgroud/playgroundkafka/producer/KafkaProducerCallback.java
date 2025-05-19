package nuts.playgroud.playgroundkafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

@Slf4j
public class KafkaProducerCallback implements Callback {

    @Override
    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
        if (e == null) {
            log.info("Successfully sent data to kafka");
            log.info(recordMetadata.toString());
        } else {
            log.error(e.getMessage(), e);
        }
    }

}

# JAVA KafkaProducer API

### KafkaProducer 인스턴스 생성

```java
    public void createKafkaProducer() {
    Properties props = new Properties();
    props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.56.101:9092");
    props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

    try (KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(props)) {
        // 카프카 프로듀서 로직...
    }
}
```

**카프카 프로듀서 주요 Properties**

| **설정값**                                 | **설명**                         | **기본값**           | **필수/선택** |
|-----------------------------------------|--------------------------------|-------------------|-----------|
| `bootstrap.servers`                     | Kafka 브로커 주소                   | 없음 (필수)           | 필수        |
| `key.serializer`                        | 메시지 키 직렬화 클래스                  | 없음                | 권장        |
| `value.serializer`                      | 메시지 값 직렬화 클래스                  | 없음 (필수)           | 필수        |
| `acks`                                  | 브로커의 확인 응답 수준                  | `1`               | 선택        |
| `retries`                               | 메시지 전송 실패 시 재시도 횟수             | 무제한               | 선택        |
| `batch.size`                            | 배치 크기 (바이트 단위)                 | `16384` (16KB)    | 선택        |
| `linger.ms`                             | 배치를 채우기 위해 기다리는 시간 (밀리초)       | `0`               | 선택        |
| `buffer.memory`                         | 프로듀서 버퍼 메모리 크기                 | `33554432` (32MB) | 선택        |
| `compression.type`                      | 메시지 압축 방식                      | `none`            | 선택        |
| `client.id`                             | 프로듀서를 식별하기 위한 ID               | 없음                | 선택        |
| `enable.idempotence`                    | 멱등성 활성화                        | `false`           | 선택        |
| `max.in.flight.requests.per.connection` | 하나의 연결에서 동시에 보낼 수 있는 요청의 최대 개수 | `5`               | 선택        |


필수로 입력되어야 하는 부분은 브로커 주소, 키, 

### 메시지 전송

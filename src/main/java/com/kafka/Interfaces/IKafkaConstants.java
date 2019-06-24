package com.kafka.Interfaces;

public interface IKafkaConstants {
    String KAFKA_BROKERS = "localhost:9092"; // eski halini docker composedan kafka config ayarlarını yapmak için kullanmıştım
    Integer MESSAGE_COUNT = 1000;             // suanda localhost 9092 portundan kafka servera baglayacagız
    String CLIENT_ID="client1";
    String TOPIC_NAME="log-monitoring";
    String GROUP_ID_CONFIG="consumerGroup1";
    Integer MAX_NO_MESSAGE_FOUND_COUNT=100;
    String OFFSET_RESET_LATEST="latest";
    String OFFSET_RESET_EARLIER="earliest";
    Integer MAX_POLL_RECORDS=1;
}
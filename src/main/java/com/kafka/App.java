package com.kafka;

public class App {

    public static void main(String[] args) {
        SimpleProducer producer = new SimpleProducer();
        producer.run("deneme mesajı");
        producer.stopProducer();
    }
}

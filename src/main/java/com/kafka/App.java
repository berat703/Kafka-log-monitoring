package com.kafka;

public class App {

    public static void main(String[] args) {
        ConsumerThread consumerRunnable = new ConsumerThread();
        consumerRunnable.run();
        LogListener listener = new LogListener();
        listener.run();
    }
}

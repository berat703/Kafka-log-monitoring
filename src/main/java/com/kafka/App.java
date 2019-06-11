package com.kafka;

import com.kafka.Listener.LogListener;
import com.kafka.Producer.SimpleProducer;

import java.io.IOException;

public class App {

    public static void main(String[] args) {
        String[] cmd = new String[]{"bash", "logger.sh"};
        try {
            Process pr = Runtime.getRuntime().exec(cmd);
            SimpleProducer producer = new SimpleProducer();
            LogListener listener = new LogListener(producer);
            listener.run();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

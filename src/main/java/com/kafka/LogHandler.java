package com.kafka;

import org.apache.commons.io.input.TailerListenerAdapter;

public class LogHandler extends TailerListenerAdapter {
    private static SimpleProducer producer = new SimpleProducer();

    @Override
    public void handle(String line) {
        JsonBuilder jsonBuilder = new JsonBuilder();
        producer.run(jsonBuilder.getModelAsJson(line));
    }

}

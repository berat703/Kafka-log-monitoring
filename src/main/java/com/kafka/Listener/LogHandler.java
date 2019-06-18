package com.kafka.Listener;

import com.kafka.JsonBuilder;
import com.kafka.Producer.SimpleProducer;
import org.apache.commons.io.input.TailerListenerAdapter;

public class LogHandler extends TailerListenerAdapter {
    private SimpleProducer producer;

    LogHandler(SimpleProducer producer) {
        this.producer = producer;
    }

    @Override
    public void handle(String line) {
        JsonBuilder jsonBuilder = new JsonBuilder();
        producer.run(jsonBuilder.getModelAsJson(line));
    }

}

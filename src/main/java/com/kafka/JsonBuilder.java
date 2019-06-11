package com.kafka;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.Models.Log;


public class JsonBuilder {

    public Log buildModel(String message) {

        String[] splitedMessage = message.split("\\s+");
        return new Log(
                splitedMessage[0] + " " + splitedMessage[1],
                splitedMessage[3],
                splitedMessage[2],
                splitedMessage[4]
        );
    }

    public String getModelAsJson(String message) {
        String json = "";
        ObjectMapper mapper = new ObjectMapper();
        Log log = buildModel(message);

        try {
            json = mapper.writeValueAsString(log);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}

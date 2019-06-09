package com.kafka;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class LogSerializer implements JsonSerializer<String> {
    private String[] fields = {"timestamp","logLevel","city","detail"};
    public JsonElement serialize(String message, Type type, JsonSerializationContext jsonSerializationContext) {
        final JsonObject jsonObject = new JsonObject();

        String[] splitedMessage = message.split("\\s+");

        for (int index=0;index<fields.length;index++) {
            if(fields[index].equals("timestamp")){
                jsonObject.addProperty(fields[index],splitedMessage[index]);
            }
            jsonObject.addProperty(fields[index],splitedMessage[2]);
        }

        jsonObject.addProperty("timestamp",splitedMessage[0]+" "+splitedMessage[1]);
        jsonObject.addProperty("logLevel",splitedMessage[2]);
        jsonObject.addProperty("city",splitedMessage[3]);
        jsonObject.addProperty("detail",splitedMessage[4]);

        return jsonObject;
    }
}

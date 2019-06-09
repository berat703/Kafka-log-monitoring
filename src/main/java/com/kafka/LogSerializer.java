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
                jsonObject.addProperty(fields[index],splitedMessage[index+1]);
                index = 1;
            }
            jsonObject.addProperty(fields[index],splitedMessage[index]);
        }
        return jsonObject;
    }
}

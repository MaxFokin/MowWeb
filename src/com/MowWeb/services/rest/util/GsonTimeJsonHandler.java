package com.MowWeb.services.rest.util;

import java.lang.reflect.Type;
import java.sql.Time;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class GsonTimeJsonHandler implements JsonDeserializer<Time>,
													JsonSerializer<Time>{

    @Override
    public Time deserialize(JsonElement jsonElm, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
    	Time time = context.deserialize(jsonElm, Time.class);
    	//TODO Check if needed!!!!!
        //String time = json.getAsString();
        //String[] parts = time.split(":");
        //return new Time(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
    	return new Time(time.getTime());
    }
    
    @Override
    public JsonElement serialize(Time src, Type typeOfSrc, JsonSerializationContext context)
            throws JsonParseException {
    	String timeFormatAsString = src.toString();
    	return new JsonPrimitive(timeFormatAsString);
    }
}
package com.MowWeb.services.rest.util;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.sql.Time;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.InternalProperties;
import org.glassfish.jersey.internal.util.PropertiesHelper;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;


@Provider
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GsonMessageBodyHandler implements MessageBodyWriter<Object>,
		MessageBodyReader<Object>, Feature {

	private final static String JSON_FEATURE = GsonMessageBodyHandler.class.getSimpleName();
	private static final String UTF_8 = "UTF-8";
	 
    private Gson gson;
 
    //Customize the gson behavior here
    private Gson getGson() {
        if (gson == null) {
            final GsonBuilder gsonBuilder = new GsonBuilder();
            gson = gsonBuilder.disableHtmlEscaping()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .setDateFormat("YYYY-MM-DD")
                    .registerTypeAdapter(Time.class, new GsonTimeJsonHandler())
                    .setPrettyPrinting()
                    .serializeNulls()
                    .create();
        }
        return gson;
    }
 
    @Override
    public boolean isReadable(Class<?> type, Type genericType,
            java.lang.annotation.Annotation[] annotations, MediaType mediaType) {
        return true;
    }
 
    @Override
    public Object readFrom(Class<Object> type, Type genericType,
            Annotation[] annotations, MediaType mediaType,
            MultivaluedMap<String, String> httpHeaders, InputStream entityStream) {
        InputStreamReader streamReader = null;
        try {
            streamReader = new InputStreamReader(entityStream, UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            Type jsonType;
            if (type.equals(genericType)) {
                jsonType = type;
            } else {
                jsonType = genericType;
            }
            return getGson().fromJson(streamReader, jsonType);
        } finally {
            try {
                streamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
 
    @Override
    public boolean isWriteable(Class<?> type, Type genericType,
            Annotation[] annotations, MediaType mediaType) {
        return true;
    }
 
    @Override
    public long getSize(Object object, Class<?> type, Type genericType,
            Annotation[] annotations, MediaType mediaType) {
        return -1;
    }
 
    @Override
    public void writeTo(Object object, Class<?> type, Type genericType,
            Annotation[] annotations, MediaType mediaType,
            MultivaluedMap<String, Object> httpHeaders,
            OutputStream entityStream) throws IOException,
            WebApplicationException {
        OutputStreamWriter writer = new OutputStreamWriter(entityStream, UTF_8);
        try {
            Type jsonType;
            if (type.equals(genericType)) {
                jsonType = type;
            } else {
                jsonType = genericType;
            }
            getGson().toJson(object, jsonType, writer);
        } finally {
            writer.close();
        }
    }
    
    @Override
    public boolean configure(FeatureContext context) {

      context.register(JsonParseException.class);
      //context.register(JsonMappingExceptionMapper.class);
      context.register(GsonMessageBodyHandler.class, MessageBodyReader.class, MessageBodyWriter.class);

      final Configuration config = context.getConfiguration();
      // Disables discoverability of org.glassfish.jersey.jackson.JacksonFeature
      context.property(
          PropertiesHelper.getPropertyNameForRuntime(InternalProperties.JSON_FEATURE,
                                                     config.getRuntimeType()), JSON_FEATURE);
      return true;
    }
}
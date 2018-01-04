package com.MowWeb.rest;

import com.sun.net.httpserver.HttpServer;
import java.net.URI;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class RSPublisher {
	
	private final static int port = 8080;
	private final static String host="http://localhost/";
	 
	public void run() {
		URI baseUri = UriBuilder.fromUri(host).port(port).build();
		ResourceConfig config = new ResourceConfig(RSImpl.class);
		HttpServer server = JdkHttpServerFactory.createHttpServer(baseUri, config);
	}
}
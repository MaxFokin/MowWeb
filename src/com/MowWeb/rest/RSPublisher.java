package com.MowWeb.rest;

import com.sun.net.httpserver.HttpServer;
import java.net.URI;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public final class RSPublisher {
	
	private final int port = 8080;
	private final String host="http://localhost/";
	ResourceConfig config = new Application();
	 
	public void run() {
		URI baseUri = UriBuilder.fromUri(host).port(port).build();
		HttpServer server = JdkHttpServerFactory.createHttpServer(baseUri, config);
		
		System.out.println("*** RESTful Service Has Started ***\n\t@ http://localhost:8080/rest/");
	}
}
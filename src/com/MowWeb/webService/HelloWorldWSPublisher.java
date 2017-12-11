package com.MowWeb.webService;

import javax.xml.ws.Endpoint;

public class HelloWorldWSPublisher {
	
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/ws/HelloWorld",new HelloWorldImpl());
		System.out.println("WebService Has Started\n@\thttp://localhost:8080/ws/HelloWorld");
	}
}
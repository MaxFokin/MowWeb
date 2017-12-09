package com.MowWeb.wsServer;

import javax.xml.ws.Endpoint;
import com.MowWeb.wsServer.*;

public class RunService {

	public static void main(String[] args) {
		System.out.println("SayHello Web Service started.");
		Endpoint.publish("http://localhost:8080/wsServerExample", new sayHello());

	}

}

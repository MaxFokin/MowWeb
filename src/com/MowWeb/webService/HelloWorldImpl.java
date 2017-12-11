package com.MowWeb.webService;

import javax.jws.WebService;

@WebService(endpointInterface="com.MowWeb.webService.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	@Override
	public String getHelloWorldAsString(String name) {
		  return "Hello world from "+name;
	 }

}

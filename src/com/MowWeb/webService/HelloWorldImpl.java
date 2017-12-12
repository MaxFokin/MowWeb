package com.MowWeb.webService;

import javax.jws.WebService;

@WebService(endpointInterface="com.MowWeb.webService.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	@Override
	public String getHelloWorldAsString(String name) {
		  return "Hello world from "+name;
		  
		  /*
		   *
			<?xml version="1.0" encoding="utf-8"?>
			<soap:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
  				<soap:Body>
   					<getHelloWorldAsString xmlns="http://webService.MowWeb.com/">
     					<arg0 xmlns="">Max</arg0>
   					</getHelloWorldAsString>
  				</soap:Body>
			</soap:Envelope>
		   *
		   */
	 }

}

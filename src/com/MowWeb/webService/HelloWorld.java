package com.MowWeb.webService;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HelloWorld {
 
	@WebMethod public String getHelloWorldAsString(String name);
}
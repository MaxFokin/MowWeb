package com.MowWeb.wsServer;
import javax.jws.WebMethod;
import javax.jws.WebService;
 
@WebService
public class sayHello {
	
	private static final String SALUTATION = "Hello";
	
	@WebMethod
	public String getGreeting( String name ) {
		return SALUTATION + " " + name;
	}
}
package com.MowWeb.rest;

import org.glassfish.jersey.server.ResourceConfig;
/* @TODO needed???
import org.glassfish.jersey.filter.LoggingFilter;
*/
import com.MowWeb.rest.auth.AuthenticationFilter;
import com.MowWeb.rest.GsonMessageBodyHandler;

public class CustomApplication extends ResourceConfig {
	public CustomApplication()
    {
        packages("com.MowWeb.rest");
/* @TODO needed???
        register(LoggingFilter.class);
*/
        register(GsonMessageBodyHandler.class);
        register(AuthenticationFilter.class);
    }
}

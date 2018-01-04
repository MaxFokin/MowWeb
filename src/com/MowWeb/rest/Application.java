package com.MowWeb.rest;

import org.glassfish.jersey.server.ResourceConfig;
import com.MowWeb.rest.auth.AuthenticationFilter;
import com.MowWeb.rest.GsonMessageBodyHandler;

import com.MowWeb.rest.items.*;

public class Application extends ResourceConfig {
	public Application()
    {
        packages("com.MowWeb.rest");
        register(RSItemsImpl.class);
        register(GsonMessageBodyHandler.class);
        register(AuthenticationFilter.class);
    }
}
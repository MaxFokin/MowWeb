package com.MowWeb.services.rest;

import org.glassfish.jersey.server.ResourceConfig;

import com.MowWeb.module.item.rest.RSItemsImpl;
import com.MowWeb.services.rest.auth.AuthenticationFilter;
import com.MowWeb.services.rest.util.GsonMessageBodyHandler;

public class Application extends ResourceConfig {
	public Application()
    {
        packages("com.MowWeb.module.item.rest");	//can add packages with ';' between them
        register(RSItemsImpl.class);
        register(GsonMessageBodyHandler.class);
        register(AuthenticationFilter.class);
    }
}
package com.MowWeb.rest;

import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;


@Path("/items")
public class RSImpl implements RSInterface {
	
	@Override
	@RolesAllowed("INTERFACE")
	@Path("/{itemId}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Item getItem(@PathParam("itemId") int itemId) {
		
	 }
	
	
	@Override
	@RolesAllowed("INTERFACE")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> getAllItems() {
		
	}
	
}
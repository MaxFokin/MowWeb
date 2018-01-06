package com.MowWeb.module.item.rest;

import java.sql.Time;
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

import com.MowWeb.module.item.*;
import com.MowWeb.services.rest.util.GsonTimeJsonHandler;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Path("/rest/items")
public class RSItemsImpl implements RSItemsInterface {
	
	ItemDAO dao = null;
	
	public Gson getGson() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.disableHtmlEscaping()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .setDateFormat("YYYY-MM-DD")
                    .registerTypeAdapter(Time.class, new GsonTimeJsonHandler())
                    .setPrettyPrinting()
                    .serializeNulls()
                    .create();
        return gson;
    }
	
	@Override
	@RolesAllowed("INTERFACE")
	@Path("/{key}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getItem(@PathParam("key") int key) {
		Gson gson = getGson();
		dao = new ItemDAO();
		Item item = dao.getItem(key);
		dao.closeConn();
		return gson.toJson(item);
	 }
	
	
	@Override
	@RolesAllowed("INTERFACE")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllItems() {
		Gson gson = getGson();
		dao = new ItemDAO();
		List<Item> allItems = dao.getAllItems();
		dao.closeConn();
		return gson.toJson(allItems);
	}
	
}
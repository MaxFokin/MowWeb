package com.MowWeb.rest.items;

import java.util.HashMap;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;

public interface RSItemsInterface {
 
	public Item getItem(int itemId);
	public List<Item> getAllItems();
}
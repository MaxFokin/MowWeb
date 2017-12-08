package connection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LinkedTreeMap;

final class DBConnData {	
	
	final private LinkedTreeMap ConnData;
	final private ConnDataHandle ConnJson = new ConnDataHandle();
	  
	protected DBConnData() {
		LinkedTreeMap ConnData = ConnJson.getKey("mySQL");
		this.ConnData = ConnData;
	}
	
	protected String getHost() {
		return this.ConnData.get("host").toString();
	}
	
	protected String getUser() {
		return this.ConnData.get("user").toString();
	}
	
	protected String getPass() {
		return this.ConnData.get("pass").toString();
	}
}
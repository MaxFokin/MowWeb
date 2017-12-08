package connection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LinkedTreeMap;

final class SFDCConnData {
	
	private HashMap jsonData = null;
	final private LinkedTreeMap ConnData;
	
	protected SFDCConnData() {
		openConnFile();
		LinkedTreeMap ConnData = new LinkedTreeMap();
		ConnData = (LinkedTreeMap) jsonData.get("sfdc");
		this.ConnData = ConnData;
	}
	
	protected void openConnFile() {
		Gson ConnData = new Gson();
		
		try {
			this.jsonData = ConnData.fromJson(new FileReader("ConnData.json"), HashMap.class);
		} 
		catch (FileNotFoundException | JsonSyntaxException | JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected String getToken() {
		return this.ConnData.get("token").toString();
	}
	protected String getUser() {
		return this.ConnData.get("user").toString();
	}
	protected String getPass() {
		return this.ConnData.get("pass").toString();
	}
}

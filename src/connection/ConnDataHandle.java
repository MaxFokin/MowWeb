package connection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LinkedTreeMap;

final class ConnDataHandle {
	private HashMap jsonData = null;
	
	protected ConnDataHandle() {
		Gson ConnData = new Gson();
		
		try {
			this.jsonData = ConnData.fromJson(new FileReader("ConnData.json"), HashMap.class);
		} catch (FileNotFoundException | JsonSyntaxException | JsonIOException e) {
			e.printStackTrace();
		}
	}
	
	protected LinkedTreeMap getKey(String key) {
		LinkedTreeMap ConnData = new LinkedTreeMap();
		ConnData = (LinkedTreeMap) jsonData.get(key);
		return ConnData;
	}
}
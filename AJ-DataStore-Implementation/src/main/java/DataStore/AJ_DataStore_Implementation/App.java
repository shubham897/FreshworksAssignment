package DataStore.AJ_DataStore_Implementation;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONObject;

import DataStore.AJ_DataStore_Implementation_business_logic_Impl.CrudFunctionalityImpl;

/**
 * Hello world!
 *
 */
public class App {

	private String filePath = "";

	public App() {
		filePath = "C:\\Users\\ayush\\OneDrive\\Documents\\SpringBootLocalPracticeProjects\\AJ-DataStore-Implementation\\DataStore.txt";
	}

	public App(String path) {
		filePath = path;
	}

	public String getFilePath() {
		return filePath;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		CrudFunctionalityImpl cf = new CrudFunctionalityImpl();
		String key1 = "TestVal1";
		String key2 = "TestVal2";
		String key3 = "TestVal3";
		JSONObject value = new JSONObject();
		value.put("json Object", "create operation");
		JSONObject value1 = new JSONObject();
		value1.put("json Object2", "create operation");
		JSONObject value2 = new JSONObject();
		value2.put("json Object3", "create operation");
		
		cf.createNewMapping(key1, value);
		cf.createNewMapping(key2, value1);
		cf.createNewMapping(key3, value2);
		cf.createNewMapping(key3, value2);
		
		
		cf.readMapping(key1).ifPresent(System.out::println);

	}
}

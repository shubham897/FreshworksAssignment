package DataStore.AJ_DataStore_Implementation_business_logic_Impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

import javax.management.openmbean.InvalidKeyException;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import DataStore.AJ_DataStore_Implementation.App;
import DataStore.AJ_DataStore_Implementation_business_logic.CrudFunctionality;

public class CrudFunctionalityImpl implements CrudFunctionality {

	
	
	@SuppressWarnings("resource")
	public synchronized void createNewMapping(String key, Object value) throws IOException {
		
		if(readMapping(key).isPresent()) {
			throw new InvalidKeyException("key already present in the dataStore");
		}
		App app=new App();
		
		
		String filePath1 = app.getFilePath();
		FileWriter fw = new FileWriter(filePath1, true);
		//File file = new File(filePath1);
		// List<String> lines = Files.readAllLines(Paths.get(filePath));
		BufferedWriter bf = null;

		bf = new BufferedWriter(fw);
		bf.write(key + "->" + (JSONObject) value);
		bf.newLine();
		bf.flush();

	}

	@SuppressWarnings("resource")
	public synchronized Optional<JSONObject> readMapping(String key) {
		JSONObject retrievedValue=new JSONObject();
		if(key==null) {
			return null;
		}
		else {
			String filePath = new App().getFilePath();
			ObjectMapper mapper=new ObjectMapper();
			BufferedReader br=null;
			
			try {
				 File file = new File(filePath);
		            
		            //create BufferedReader object from the File
		            br = new BufferedReader( new FileReader(file) );
		            String line=null;
		            while((line=br.readLine())!=null) {
		            	String[] parts=line.split("->");
		            	String retrievedKey=parts[0].trim();
		            	if(retrievedKey.equals(key)) {
		            		
		            		retrievedValue= mapper.readValue(parts[1], JSONObject.class);
			            	
			            	return Optional.ofNullable(retrievedValue);
		            	}
		            	
		            	
		            	
		            }
			}catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				if(br != null){
	                try { 
	                    br.close(); 
	                }catch(Exception e){};
	            }
	        }        
			}
		
		return Optional.ofNullable(null);
	

	}

	public synchronized boolean deleteMapping(String key) {
		return false;
	}

}

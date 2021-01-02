package DataStore.AJ_DataStore_Implementation_business_logic;

import java.io.IOException;
import java.util.Optional;

import org.json.simple.JSONObject;

public interface CrudFunctionality {
	   void createNewMapping(String key,Object value) throws IOException;
	   Optional<JSONObject>  readMapping(String key);
	  boolean deleteMapping(String key);
	

}

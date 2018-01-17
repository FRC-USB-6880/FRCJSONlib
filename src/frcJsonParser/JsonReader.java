package frcJsonParser;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonReader {
	public static final String baseDir = new String("/team6880/");
    public static final String sensorSpecsFile = new String(baseDir + "specs/sensor_specs.json");
    public static final String wheelSpecsFile = new String(baseDir + "specs/wheel_specs.json");
    public static final String motorSpecsFile = new String(baseDir + "specs/motor_specs.json");
    public static final String attachments = new String(baseDir + "attachments.json");
    public static final String navigationFile = new String(baseDir + "navigation_options.json");
    public static final String autonomousOptFile = new String(baseDir + "autonomous_options.json");
    public static final String driveSystemsFile = new String(baseDir + "drivesystems.json");
    public static final String opModesDir = new String(baseDir + "/opmodes/");
    public static final String autonomousRedDir =  new String(baseDir + "autonomous/red/");
    public static final String autonomousBlueDir = new String(baseDir + "autonomous/blue/");
	
    private String filePath;
    public String jsonStr;
	private JSONParser parser = null;
	public JSONObject rootObj = null;
	
	public JsonReader(String filePath)
	{
		this.filePath = filePath;
		this.parser = new JSONParser();
		
		FileReader fileReader = null;
        // If the given file path does not exist, give an error
        try {
            fileReader = new FileReader(filePath);
        }
        catch (IOException except) {
            System.out.println("frc6880: Error while trying to open "+filePath+". Error: "+except.getMessage());
        }

        try {
            Object obj = parser.parse(fileReader);
            rootObj = (JSONObject) obj;
        }
        catch (Exception except) {
        	System.out.println("frc6880: Error while parsing "+filePath+". Error: "+except.getMessage());
        }
        try {
            fileReader.close();
        } catch (IOException except) {
        	System.out.println("frc6880: Error while trying to close "+filePath+". Error: "+except.getMessage());
        }
        return;
	}
	
	public String getString(JSONObject obj, String key) {
        String value=null;
        try {
        	key = getRealKeyIgnoreCase(obj, key);
            value = (String) obj.get(key);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("frc6880: Error getting value for the key " + key);
        }
        return (value);
    }

    public double getDouble(JSONObject obj, String key) {
        double value=0.0;
        try {
        	key = getRealKeyIgnoreCase(obj, key);
            value = (double) obj.get(key);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("frc6880: Error getting value for the key " + key);
        }
        return (value);
    }

    public boolean getBoolean(JSONObject obj, String key) {
        boolean value=false;
        try {
        	key = getRealKeyIgnoreCase(obj, key);
            value = (boolean) obj.get(key);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("frc6880: Error getting value for the key " + key);
        }
        return (value);
    }
    
    public int getInt(JSONObject obj, String key)
    {
    	int value = 0;
    	try{
    		key = getRealKeyIgnoreCase(obj, key);
    		value = (int) obj.get(key);
    	} catch (Exception e) {
    		e.printStackTrace();
    		System.out.println("frc6880: Error getting value for the key " + key);
		}
    	return value;
    }
    
    public JSONArray getArray(JSONObject obj, String key)
    {
    	JSONArray array=null;
    	try{
    		key = getRealKeyIgnoreCase(obj, key);
    		array = (JSONArray) obj.get(key);
    	} catch (Exception e) {
    		 e.printStackTrace();
             System.out.println("frc6880: Error getting value for the key " + key);
		}
    	return array;
    }
    
    public static String getRealKeyIgnoreCase(JSONObject obj, String key) throws Exception {
        Iterator<String> iter = obj.keySet().iterator();
        while (iter.hasNext()) {
            String key1 = iter.next();
            if (key1.equalsIgnoreCase(key)) {
                return (key1);
            }
        }
        return null;
    }
}

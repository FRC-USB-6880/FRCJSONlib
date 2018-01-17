package frcJsonParser;

import org.json.simple.JSONObject;

public class DriveSysReader extends JsonReader {
	JSONObject driveSysObj;
    String driveSysName;

    public DriveSysReader(String filePath, String driveSysName)
    {
        super(filePath);
        try {
            driveSysName = JsonReader.getRealKeyIgnoreCase(rootObj, driveSysName);
            driveSysObj = (JSONObject) rootObj.get(driveSysName);
            this.driveSysName = driveSysName;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getMotorType(String motorName) {
        String motorType = null;
        JSONObject obj;

        try {
            String key = JsonReader.getRealKeyIgnoreCase(driveSysObj, "Motors");
            obj = (JSONObject) driveSysObj.get(key);
            motorType = getString(obj, motorName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (motorType);
    }

    public String getWheelType(){
        String wheelType = null;
        try {
            wheelType = getString(driveSysObj, "WheelType");
        } catch (Exception e){
            e.printStackTrace();
        }

        return wheelType;
    }

    public String getDriveSysName() {
        return driveSysName;
    }

    public int getMaxMotorSpeed(String autoOrTeleop) {
        int maxMotorSpeed = 0;
        try {
            maxMotorSpeed = getInt(driveSysObj, autoOrTeleop);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (maxMotorSpeed);
    }
    
    public int getCountsPerRotation()
    {
    	int counts = 0;
    	try{
    		counts = getInt(driveSysObj, "CPR");
    	} catch(Exception e){
    		e.printStackTrace();
    	}
    	return counts;
    }
}

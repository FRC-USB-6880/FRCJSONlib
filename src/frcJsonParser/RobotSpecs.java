/**
 * 
 */
package frcJsonParser;

import java.io.FileReader;
import java.nio.file.InvalidPathException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * @author frcusb6880
 *
 */
public class RobotSpecs {
    String filePath;
    JSONParser parser=null;
    JSONObject jsonObject=null;
    JSONObject robotObject=null;
    
    public RobotSpecs(String filePath, String robotName) {
        this.filePath = filePath;
        parser = new JSONParser();
        if (filePath == null)
            throw new InvalidPathException(filePath, "filePath is null");
        else
        {
        	try
        	{
        		Object obj = parser.parse(new FileReader(filePath));
                jsonObject = (JSONObject) obj;
                
                robotObject = (JSONObject) jsonObject.get(robotName);
        	}
        	catch(Exception e)
        	{
        		e.printStackTrace();
        	}
        }
        
    }
    
    public double getWidth() throws InvalidPathException
    {
    	double robotWidth = 0.0;
    	try
    	{
    		robotWidth = (Double) robotObject.get("RobotWidth");
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    	return robotWidth;
    }
    
    public double getLength() throws InvalidPathException
    {
    	double robotLength=0.0;
    	try
    	{
    		robotLength = (Double) robotObject.get("RobotLength");
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    	return robotLength;
    }
    
    public double[] getNavxPos() throws InvalidPathException
    {
    	double[] navxPos = {0.0, 0.0};
    	try
    	{
    		navxPos = (double[]) robotObject.get("NavXPos");
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    	return navxPos;
    }
    
    public String getDriveTrain() throws InvalidPathException
    {
    	String driveTrain = "";
    	try
    	{
    		driveTrain = (String) robotObject.get("DriveTrain");
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    	return driveTrain;
    }
    
    public String[] getSensors() throws InvalidPathException
    {
    	String[] sensors=null;
    	try
    	{
    		sensors = (String[]) robotObject.get("Sensors");
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    	return sensors;
    }
    
    public String[] getActuators() throws InvalidPathException
    {
    	String[] actuators = null;
    	try
    	{
    		actuators = (String[]) robotObject.get("Actuators");
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    	return actuators;
    }
    
    public String[] getAttachments() throws InvalidPathException
    {
    	String[] attachments=null;
    	try
    	{
    		attachments = (String[]) robotObject.get("Attachments");
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    	return attachments;
    }
    

}

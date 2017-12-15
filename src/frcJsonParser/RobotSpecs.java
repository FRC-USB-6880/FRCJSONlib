/**
 * 
 */
package frcJsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.InvalidPathException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author frcusb6880
 *
 */
public class RobotSpecs {
    String filePath;
    
    public RobotSpecs(String filePath) {
        this.filePath = filePath;
    }
    
    public void parseJsonFile(String robotName) throws InvalidPathException {
        if (filePath == null) {
            throw new InvalidPathException(filePath, "filePath is null");
        }
        String robotWidthStr = new String("RobotWidth");

        JSONParser parser = new JSONParser();
        try {

            Object obj = parser.parse(new FileReader(filePath));

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);

            JSONObject robotObj = (JSONObject) jsonObject.get(robotName);
            // String name = (String) jsonObject.get("name");
            System.out.println(robotObj);

            Double robotWidth = (Double) robotObj.get(robotWidthStr);
            System.out.println("robotWidth = " + robotWidth);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}

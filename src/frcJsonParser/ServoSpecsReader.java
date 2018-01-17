package frcJsonParser;

import org.json.simple.JSONObject;

public class ServoSpecsReader extends JsonReader {
	JSONObject servoObj;
    String servoModel;

    public ServoSpecsReader(String filePath, String servoModel) {
        super(filePath);
        try {
            servoModel = JsonReader.getRealKeyIgnoreCase(rootObj, servoModel);
            servoObj = (JSONObject) rootObj.get(servoModel);
            this.servoModel = servoModel;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double getRotation() {
        double rotation = 0.0;

        try {
            rotation = getDouble(servoObj, "rotation");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (rotation);
    }
}

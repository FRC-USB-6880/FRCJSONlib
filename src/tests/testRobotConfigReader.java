/**
 * 
 */
package tests;

import frcJsonParser.DriveTrainReader;
import frcJsonParser.JsonReader;
import frcJsonParser.RobotConfigReader;

/**
 * @author rsburugula
 *
 */
public class testRobotConfigReader {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("args[0] = " + args[0]);
        
        // Set the basedir to args[0]
        JsonReader.setBaseDir(args[0]);
       
        RobotConfigReader cfgReader = new RobotConfigReader(JsonReader.robotsFile, "2017-offseason-robot");
        cfgReader.printForDebug();
        String driveTrainName = cfgReader.getDriveTrainName();
        DriveTrainReader cfgReader_driveTrain = new DriveTrainReader(JsonReader.driveTrainsFile, driveTrainName);
        cfgReader_driveTrain.printForDebug();
    }

}

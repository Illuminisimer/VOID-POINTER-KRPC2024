package jp.jaxa.iss.kibo.rpc.sampleapk;

import android.util.Log;
import gov.nasa.arc.astrobee.Result;
import jp.jaxa.iss.kibo.rpc.api.KiboRpcService;
import jp.jaxa.iss.kibo.rpc.sampleapk.math.QuaternionUtil;

import java.util.ArrayList;
import java.util.List;

import gov.nasa.arc.astrobee.types.Point;
import gov.nasa.arc.astrobee.types.Quaternion;
import gov.nasa.arc.astrobee.Kinematics;

import org.opencv.aruco.Aruco;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.aruco.Dictionary;
import org.opencv.calib3d.Calib3d;

/**
 * Class meant to handle commands from the Ground Data System and execute them
 * in Astrobee
 */

public class YourService extends KiboRpcService {

    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void runPlan1(){
        // The mission starts.
        api.startMission();

        /* *********************************************************************** */
        /* Write your code to recognize type and number of items in the each area! */
        /* *********************************************************************** */

        /* **************************************************** */
        /* Let's move to the each area and recognize the items. */
        /* **************************************************** */
       
        //Astrobee reaches Area 1...
        api.moveTo(new Point(11.35d, -10.1d, 5.190d), new Quaternion(0f, 0f, -0.707f, 0.707f), true);
        //api.flashlightControlFront(0.02f);
        //api.moveTo(new Point(10.925d, -10.923d, 5.196d), new Quaternion(0f, 0f, -0.707f, 0.707f), true);
        Mat image = api.getMatNavCam();
        api.setAreaInfo(1, "item_name", 1);
        
        //intermediate point
        api.moveTo(new Point(11d, -9.00d, 5.196d), new Quaternion(0f, 0f, 0f, 0.707f), true);
        
        //Astrobee Reaches Area 2
        api.moveTo(new Point(11d, -9d, 4.305d), new Quaternion(0f, 0.707f, 0f, 0.707f), true);
        
        //Astroee reaches Area 3
        api.moveTo(new Point(11.3d, -8d, 4.307d), new Quaternion(0f, 0.707f, 0f, 0.707f), true);

        //Astrobee Reaches Area 4
        //api.moveTo(new Point(10d, -7d, 5d), new Quaternion(0f, 0.707f, 0f, 0.707f), true);

        //Astrobee moves to astronaut
        //api.moveTo(new Point(11.143d, -6.7607d, 4.9654d), new Quaternion(0f, 0f, 0.707f, 0.707f), true);

        // When you move to the front of the astronaut, report the rounding completion.
        api.reportRoundingCompletion();

        /* ********************************************************** */
        /* Write your code to recognize which item the astronaut has. */
        /* ********************************************************** */

        // Let's notify the astronaut when you recognize it.
        api.notifyRecognitionItem();

        /* ******************************************************************************************************* */
        /* Write your code to move Astrobee to the location of the target item (what the astronaut is looking for) */
        /* ******************************************************************************************************* */

        // Take a snapshot of the target item.
        api.takeTargetItemSnapshot();
    }


    @Override
    protected void runPlan2() {
        // write your plan 2 here
    }

    @Override
    protected void runPlan3() {
        // write your plan 3 here
    }

    // You can add your method.
    private String yourMethod() {
        return "your method";
    }


}

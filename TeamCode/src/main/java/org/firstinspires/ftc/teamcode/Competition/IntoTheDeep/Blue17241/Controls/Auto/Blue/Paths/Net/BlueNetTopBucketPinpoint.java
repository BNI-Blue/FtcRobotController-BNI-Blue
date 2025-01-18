package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.Paths.Net;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.BlueAlliance;

//@Disabled

@Autonomous(name ="Blue:Net:TopBucket:Pinpoint")
public class BlueNetTopBucketPinpoint extends BlueAlliance{
    //@Override
    public void runOpMode() throws InterruptedException{
        autoStartUp();
        resetHeadingPinpoint();
        currentHeading = getHeadingPinpoint();
        odo.update();
        waitForStart();

        while(opModeIsActive()) {

            // score preloaded sample
            strafeLeftPinpoint_Cum(0.55, 9);
            sleep(100);
            driveBackPinpoint_Cum(.55, 1.6);
            bucketDumpTopLevel();


            //prepare for first field sample
            strafeRightPinpoint_Cum(0.5,0.2);
            rotateByGyroRev(.3, 27.5);
//            sleep(100);
//

            sleep(5000);
            //collect first field sample

            blueNetSampleOne();
//
//            //move to bucket with first sample
//            rotateByGyroRev(.25, -27.5);
////            strafeGyroPinpoint(.5,4,"RIGHT",0);
//            ITDBot.strafeRight(0.5,1);
//            ITDBot.driveBack(.5, 1.75);
////            driveStraightGyroPinpoint(0.5,6,"BACK",0);
//            ITDBot.intakeStop();
//
//            //score first field sample
//            bucketDumpTopLevel();

            requestOpModeStop();
        }
    }
}

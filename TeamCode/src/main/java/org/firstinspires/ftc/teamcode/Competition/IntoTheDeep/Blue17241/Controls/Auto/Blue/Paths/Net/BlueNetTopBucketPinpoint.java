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
            strafeGyroPinpoint(0.55, 7.5, "LEFT", 0);
//            driveStraightGyroPinpoint(.5, 1.51, "BACK", 0);
            driveBackPinpoint(.5, 1.7);
            //ITDBot.driveBack(0.5,1.5);
            bucketDumpTopLevel();


            //prepare for first field sample
            ITDBot.driveForward(.5, .1);
            //strafeGyroPinpoint(0.5,0.65, "RIGHT",0);
            rotateByGyroRev(.3, 27.5);
            sleep(100);

            //collect first field sample

            blueNetSampleOne();

            //move to bucket with first sample
            rotateByGyroRev(.25, -27.5);
//            strafeGyroPinpoint(.5,4,"RIGHT",0);
            ITDBot.strafeRight(0.5,1);
            ITDBot.driveBack(.5, 1.75);
//            driveStraightGyroPinpoint(0.5,6,"BACK",0);
            ITDBot.intakeStop();

            //score first field sample
            bucketDumpTopLevel();

            requestOpModeStop();
        }
    }
}

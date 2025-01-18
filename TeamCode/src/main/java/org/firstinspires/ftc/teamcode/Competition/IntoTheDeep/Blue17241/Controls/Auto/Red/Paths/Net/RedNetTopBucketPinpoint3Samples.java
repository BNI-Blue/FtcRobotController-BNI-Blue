package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red.Paths.Net;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red.RedAlliance;

@Autonomous(name ="Red:Net:TopBucket:Pinpoint:3Samples")
public class RedNetTopBucketPinpoint3Samples extends RedAlliance {
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
            driveStraightGyroPinpoint(.55, 1.5, "BACK", 0);
            bucketDumpTopLevel();


            //prepare for first field sample
            strafeGyroPinpoint(0.5,0.7, "RIGHT",0);
            rotateByGyroRev(.3, 27.5);
            sleep(100);

            //collect first field sample
            pickUpSampleOne();

            //move to bucket with first sample
            rotateByGyroRev(.25, -27.5);
            driveBackPinpoint(.5, 6);
            strafeGyroPinpoint(.5,2,"RIGHT",0);

            //score first field sample
            bucketDumpTopLevel();

            //rotateByGyroRev(.5, 25);

            //move to second field sample
            rotateByGyroRev(.25, 40.25);

            //collect second field sample
            pickUpSampleOne();

            //move to buckets with second field sample
            rotateByGyroRev(.25, -40.25);
            strafeRightPinpoint(.35, 3);
            driveBackPinpoint(.5, 1.5);
            bucketDumpTopLevel();

//            driveStraightGyroPinpoint(.5, 26, "FORWARD", 0);
//            rotateByGyroRev(.5, 50);

            requestOpModeStop();
        }
    }
}

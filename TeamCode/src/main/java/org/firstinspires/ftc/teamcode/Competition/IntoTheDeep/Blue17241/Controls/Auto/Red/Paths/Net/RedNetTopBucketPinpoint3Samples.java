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
            strafeGyroPinpoint(0.55, 7, "LEFT", 0);
            sleep(500);
            driveStraightGyroPinpoint(.55, 0.5, "BACK", 0);
            bucketDumpTopLevel();


            //prepare for first field sample
            rotateByGyroRev(.3, 21);
            sleep(100);

            pickUpSampleOne();

            rotateByGyroRev(.25, -21);
            driveBackPinpoint(.5, 1.5);
            bucketDumpTopLevel();

            //rotateByGyroRev(.5, 25);

            rotateByGyroRev(.25, 41);

            pickUpSampleOne();

            rotateByGyroRev(.25, -41);
            strafeRightPinpoint(.35, 8);
            driveBackPinpoint(.5, 1.25);
            bucketDumpTopLevel();

            driveStraightGyroPinpoint(.5, 26, "FORWARD", 0);
            rotateByGyroRev(.5, 50);

            requestOpModeStop();
        }
    }
}

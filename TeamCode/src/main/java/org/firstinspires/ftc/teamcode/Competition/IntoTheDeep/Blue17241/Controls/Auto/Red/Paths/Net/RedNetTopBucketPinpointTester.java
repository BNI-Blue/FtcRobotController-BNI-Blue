package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red.Paths.Net;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red.RedAlliance;

@Disabled
@Autonomous(name ="Red:Net:TopBucket:Pinpoint")
public class RedNetTopBucketPinpointTester extends RedAlliance {
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
            driveStraightGyroPinpoint(.55, 0.5, "BACK", 0);
            bucketDumpTopLevelOne();


            //prepare for first field sample
            rotateByGyroRev(.3, 21);
            sleep(100);

            redNetSampleOne();

            rotateByGyroRev(.25, -21);
            driveBackPinpoint(.5, 1.5);
            bucketDumpTopLevelTwo();

            //rotateByGyroRev(.5, 25);

            rotateByGyroRev(.25, 41);

            redNetSampleTwo();

            rotateByGyroRev(.25, -41);
            strafeRightPinpoint(.35, 8);
            driveBackPinpoint(.5, 1.25);
            bucketDumpTopLevelOne();

            driveStraightGyroPinpoint(.5, 26, "FORWARD", 0);
            rotateByGyroRev(.5, 50);


            requestOpModeStop();
        }
    }
}

package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.Paths;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.BlueAlliance;

@Disabled

@Autonomous(name ="Blue:Net:TopBucket:Pinpoint")
public class BlueNetTopBucketPinpoint extends BlueAlliance{
    //@Override
    public void runOpMode() throws InterruptedException{
        autoStartUp();
        resetHeading();
        currentHeading = getHeading();
        odo.update();
        waitForStart();

        while(opModeIsActive()) {

            strafeGyroPinpoint(0.5, 1, "LEFT", 0);
            driveStraightGyroPinpoint(.5, .25, "BACK", 0);
            sleep(1000);
            ITDBot.extendIntake();
            sleep(1000);
            bucketDumpTopLevel();
            sleep(1000);

//            driveStraightGyroPinpoint(.5, 13, "BACK", 0);
//            ITDBot.rotateRight(0.65, 3.5);
//            strafeGyroPinpoint(0.5, 1.5, "LEFT", 0);
//            driveStraightGyroPinpoint(0.5, 15, "FORWARD", 0);
//            ITDBot.rotateLeft(0.65, 3);
//            driveStraightGyroPinpoint(.5, 14, "FORWARD", 0);
//            driveStraightGyroPinpoint(.5, 18, "BACK", 0);
//            ITDBot.rotateRight(0.65, 3.5);

//            ITDBot.extendIntake();
//            sleep(500);
//            ITDBot.intakeHolderDown();
//            sleep(500);
//            ITDBot.sampleIntake();
//            sleep(1000);
//            ITDBot.intakeStop();
//            sleep(500);
//            ITDBot.intakeHolderUp();
//            sleep(1000);
//            ITDBot.retractIntake();
//            ITDBot.fillBucket();
//            ITDBot.sampleOuttakeAuto();

            requestOpModeStop();
        }
    }
}

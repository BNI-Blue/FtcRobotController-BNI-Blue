package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red.Paths;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.BlueAlliance;
import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red.RedAlliance;

@Autonomous(name ="Red:Net:TopBucket:Pinpoint")
public class RedNetTopBucketPinpoint extends RedAlliance {
    //@Override
    public void runOpMode() throws InterruptedException{
        autoStartUp();
        resetHeading();
        currentHeading = getHeading();
        odo.update();
        waitForStart();

        while(opModeIsActive()) {


            strafeGyroPinpoint(0.5, 5, "RIGHT", 0);
            sleep(1000);
            driveStraightGyroPinpoint(.5, 1, "FORWARD", 0);
            sleep(1000);
            ITDBot.extendIntake();
            bucketDumpTopLevel();
            sleep(1000);

            driveStraightGyroPinpoint(.5, 13, "BACK", 0);
            sleep(1000);
            ITDBot.rotateRight(0.65, 3.5);
            sleep(1000);
            strafeGyroPinpoint(0.5, 2, "RIGHT", 0);
            sleep(1000);
            driveStraightGyroPinpoint(0.5, 12, "FORWARD", 0);
            sleep(1000);
            ITDBot.rotateLeft(0.65, 3.5);
            sleep(1000);

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
//            ITDBot.sampleOuttake();


//            driveStraightGyroPinpoint(.5, 14, "FORWARD", 0);
//            sleep(1000);
//            bucketDumpTopLevel();

//            driveStraightGyroPinpoint(.5, 18, "BACK", 0);
//            sleep(1000);
//            ITDBot.rotateRight(0.65, 3.5);
//            sleep(1000);

            requestOpModeStop();
        }
    }
}

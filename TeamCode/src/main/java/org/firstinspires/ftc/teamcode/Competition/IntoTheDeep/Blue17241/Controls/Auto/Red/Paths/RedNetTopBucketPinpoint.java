package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red.Paths;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

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

            strafeGyroPinpoint(0.55, 7, "LEFT", 0);
            driveStraightGyroPinpoint(.55, 0.74, "BACK", 0);
            bucketDumpTopLevel();
            strafeGyroPinpoint(.55, 2.8, "RIGHT", 0);

            driveStraightGyroPinpoint(.65, 22.5, "FORWARD", 0);
            sleep(250);
            ITDBot.rotateLeft(.65, 2.25);

            ITDBot.extendIntake();
            sleep(250);
            ITDBot.intakeHolderDown();
            sleep(250);
            driveForwardPinpoint(.25, 10);
            ITDBot.sampleIntake();
            driveForwardPinpoint(.25, 9.25);
            sleep(800);
            ITDBot.intakeHolderUpAuto();
            sleep(250);
            ITDBot.intakeStop();
            ITDBot.retractIntake();
            ITDBot.fillBucket();
            sleep(250);
            ITDBot.sampleOuttakeAuto();
            sleep(600);
            ITDBot.intakeStop();
            ITDBot.intakeHolderUp();

            ITDBot.rotateRight(.65, 2.625);
            sleep(250);
            strafeGyroPinpoint(.5 ,3, "RIGHT", 0);
            driveStraightGyroPinpoint(.5, 16, "BACK", 0);
            ITDBot.rotateLeft(.65, .6);
            strafeGyroPinpoint(.5, 4, "LEFT", 0);
            bucketDumpTopLevel();

            driveStraightGyroPinpoint(.55, 27, "FORWARD", 0);
            ITDBot.rotateLeft(.5, 1.85);

            ITDBot.extendIntake();
            sleep(250);
            ITDBot.intakeHolderDown();
            sleep(250);
            driveForwardPinpoint(.25, 10);
            ITDBot.sampleIntake();
            driveForwardPinpoint(.25, 6.5);
            sleep(800);
            ITDBot.intakeHolderUpAuto();
            sleep(250);
            ITDBot.intakeStop();
            ITDBot.retractIntake();
            ITDBot.fillBucket();
            sleep(250);
            ITDBot.sampleOuttakeAuto();
            sleep(600);
            ITDBot.intakeStop();
            ITDBot.intakeHolderUp();

            ITDBot.rotateRight(.5, 1);
            driveStraightGyroPinpoint(.5, 18, "BACK", 0);
            ITDBot.rotateRight(.5, 2);
//            bucketDumpTopLevel();
//            bucketDumpTopLevel();


            requestOpModeStop();
        }
    }
}

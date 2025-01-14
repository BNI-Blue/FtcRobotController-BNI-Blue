package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red.Paths.Net;

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
            driveStraightGyroPinpoint(.55, 0.65, "BACK", 0);
            bucketDumpTopLevel();
            strafeGyroPinpoint(.55, 1.2, "RIGHT", 0);

            gyroCorrection(.25, 48.5);
            sleep(100);
            //driveStraightGyroPinpoint(.65, 2, "FORWARD", 0);

            //rotateByGyro(turnSpeed, 37.25);

            ITDBot.extendIntake();
            sleep(250);
            ITDBot.collectIntake();
            sleep(250);
            ITDBot.sampleIntake();
            sleep(250);
            ITDBot.driveForward(.25);
            sleep(750);
            ITDBot.stopMotors();
            sleep(550);
            ITDBot.intakeStop();
            ITDBot.scoreIntake();
            sleep(250);
            ITDBot.retractIntake();
            ITDBot.fillBucket();
            sleep(250);
            ITDBot.scoreIntake();
            sleep(200);
            ITDBot.sampleOuttake();
            sleep(750);
            ITDBot.intakeStop();
            sleep(100);
            gyroCorrection(.25, -15);
            bucketDumpTopLevel();


            gyroCorrection(correctSpeed, -40);
            //rotateByGyro(turnSpeed, -40);
            sleep(250);
            strafeGyroPinpoint(.5 ,1, "RIGHT", 0);
            driveStraightGyroPinpoint(.5, 3, "BACK", 0);
            strafeGyroPinpoint(.5, 1, "RIGHT", 0);
            bucketDumpTopLevel();

            driveStraightGyroPinpoint(.55, 1, "FORWARD", 0);
            //rotateByGyro(turnSpeed, 53.5);
            gyroCorrection(correctSpeed, 53.5);

            ITDBot.extendIntake();
            sleep(250);
            ITDBot.collectIntake();
            sleep(250);
            ITDBot.sampleIntake();
            driveForwardPinpoint(.25, 5.5);
            sleep(100);
            ITDBot.intakeHolderUpAuto();
            sleep(250);
            ITDBot.intakeStop();
            ITDBot.retractIntake();
            ITDBot.emptyBucket();
            sleep(250);
            ITDBot.sampleOuttakeAuto();
            sleep(600);
            ITDBot.intakeStop();
            ITDBot.scoreIntake();

            gyroCorrection(correctSpeed, -37.5);
            //rotateByGyro(turnSpeed, -37.5);
            //ITDBot.rotateRight(.5, 1);
            driveStraightGyroPinpoint(.5, 1, "BACK", 0);
            gyroCorrection(.5, 0);
            gyroCorrection(.5, -3);
            //rotateByGyro(turnSpeed, -3);
//            bucketDumpTopLevel();


            requestOpModeStop();
        }
    }
}

package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red.Paths.Net;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red.RedAlliance;

@Disabled
@Autonomous (name = "Red:Net:Top Bucket")
public class RedNetTopBucket extends RedAlliance {
    @Override
    public void runOpMode() throws InterruptedException{

        // Global Method for Initializing Auto
        autoStartUp();

        waitForStart();

        ITDBot.retractIntake();

        while(opModeIsActive()){

            ITDBot.strafeLeft(0.5, 1.6);
            sleep(100);
            ITDBot.driveBack(0.5, .25);
            bucketDumpTopLevel();
            ITDBot.retractIntake();

            ITDBot.strafeRight(.5, 1);
            ITDBot.driveForward(.5, 3);
            ITDBot.rotateLeft(.5, 2.575);
            ITDBot.strafeRight(.5, 0.75);
            //ITDBot.rotateLeft(.5, .3);

            ITDBot.extendIntake();
            ITDBot.collectIntake();
            sleep(1000);
            ITDBot.driveForward(.5, .6);
            ITDBot.sampleIntakeAuto();
            ITDBot.driveForward(.35, .55);
            sleep(1000);
            ITDBot.intakeStop();
            ITDBot.scoreIntake();
            ITDBot.retractIntake();
            sleep(500);
            ITDBot.sampleOuttakeAuto();
            sleep(1250);

            ITDBot.intakeStop();
            ITDBot.strafeLeft(.5, 0.85);
            ITDBot.rotateRight(.5, 2.625);
            ITDBot.strafeRight(.5, .4);
            ITDBot.driveBack(.5, 2.2);
            bucketDumpTopLevel();

            requestOpModeStop();


        }
        idle();
    }
}

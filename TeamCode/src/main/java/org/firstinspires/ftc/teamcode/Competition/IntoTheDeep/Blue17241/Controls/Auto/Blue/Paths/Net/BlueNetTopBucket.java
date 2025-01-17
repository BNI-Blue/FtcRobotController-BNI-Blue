package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.Paths.Net;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.BlueAlliance;

@Disabled
@Autonomous(name = "Blue:Net:TopBucket")
public class BlueNetTopBucket extends BlueAlliance {
    @Override
    public void runOpMode() throws InterruptedException{

        // Global Method for Initializing Auto
        autoStartUp();

        waitForStart();

        ITDBot.retractIntake();

        while(opModeIsActive()){
// Preloaded sample scoring in top bucket
            ITDBot.strafeLeft(0.5, 1.6);
            sleep(100);
            ITDBot.driveBack(0.5, .45);
            bucketDumpTopLevel();
            ITDBot.retractIntake();
//
            ITDBot.strafeRight(.5, 1);
            ITDBot.driveForward(.5, 3);
            ITDBot.rotateLeft(.5, 2.65);
            ITDBot.strafeRight(.5, 1.2);
            //ITDBot.rotateLeft(.5, .3);

            ITDBot.extendIntake();
            ITDBot.collectIntake();
            sleep(1000);
            ITDBot.driveForward(.5, .45);
            ITDBot.sampleIntake();
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
            ITDBot.rotateRight(.5, 2.5);
            ITDBot.driveBack(.5, 2.2);
            ITDBot.strafeLeft(.5,  .275);
            bucketDumpTopLevel();

            requestOpModeStop();

        }
        idle();
    }
}

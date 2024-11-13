package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.Paths;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.BlueAlliance;

@Autonomous(name = "Blue:Net:TopBucket:ObsPark")
public class BlueNetTopBucketObsPark extends BlueAlliance {
    @Override
    public void runOpMode() throws InterruptedException{
        // Global Method for Initializing Auto
        autoStartUp();

        waitForStart();

        ITDBot.retractIntake();

        while(opModeIsActive()){

            sleep(25000);

            ITDBot.strafeLeft(0.5, 1.6);
            sleep(100);
            ITDBot.driveBack(0.5, .1);
            bucketDumpTopLevel();

// Code to drive to observation zone, not tested
            ITDBot.driveForward(1,1);
            ITDBot.rotateRight(0.5, .2);
            ITDBot.driveForward(0.5, 2.5);

            requestOpModeStop();

    }
    idle();
}
}

package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red.Paths.Net;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red.RedAlliance;

@Disabled
@Autonomous(name = "Red:Net:TopBucket:ObsPark")
public class RedNetTopBucketObsPark extends RedAlliance {
    @Override
    public void runOpMode() throws InterruptedException {

        // Global Method for Initializing Auto
        autoStartUp();

        waitForStart();

        ITDBot.retractIntake();

        while (opModeIsActive()) {

            sleep(25000);

            ITDBot.strafeRight(1, 1.6);
            ITDBot.driveForward(1, .1);
            bucketDumpTopLevelOne();

            //NOT Tested
            ITDBot.driveBack(1, .15);
            ITDBot.rotateLeft(1,1.75);
            ITDBot.driveForward(1, 6);

            requestOpModeStop();

        }
        idle();
    }
}

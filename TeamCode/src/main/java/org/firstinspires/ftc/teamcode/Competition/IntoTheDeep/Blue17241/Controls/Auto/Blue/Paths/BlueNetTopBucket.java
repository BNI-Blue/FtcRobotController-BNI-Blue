package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.Paths;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.BlueAlliance;

@Autonomous(name = "Blue:Net:TopBucket")
public class BlueNetTopBucket extends BlueAlliance {
    @Override
    public void runOpMode() throws InterruptedException{

        // Global Method for Initializing Auto
        autoStartUp();

        waitForStart();

        ITDBot.retractIntake();

        while(opModeIsActive()){

            ITDBot.strafeLeft(0.5, 1.6);
            sleep(100);
            ITDBot.driveBack(0.5, .1);
            bucketDumpTopLevel();

            requestOpModeStop();

        }
        idle();
    }
}

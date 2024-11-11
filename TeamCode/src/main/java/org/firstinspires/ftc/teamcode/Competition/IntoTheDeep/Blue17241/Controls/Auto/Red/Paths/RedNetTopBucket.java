package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red.Paths;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red.RedAlliance;

@Autonomous (name = "Red:Net:Top Bucket")
public class RedNetTopBucket extends RedAlliance {
    @Override
    public void runOpMode() throws InterruptedException{

        // Global Method for Initializing Auto
        autoStartUp();

        waitForStart();

        ITDBot.retractIntake();

        while(opModeIsActive()){

            ITDBot.strafeLeft(0.5, 1.3);
            sleep(100);
            ITDBot.driveBack(0.5, .1);
            bucketDumpTopLevel();


        }
        idle();
    }
}

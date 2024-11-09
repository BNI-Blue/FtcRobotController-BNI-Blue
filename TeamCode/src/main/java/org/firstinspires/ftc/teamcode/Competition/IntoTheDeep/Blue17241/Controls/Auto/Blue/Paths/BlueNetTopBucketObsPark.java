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

            ITDBot.strafeRight(1, .15);
            ITDBot.driveForward(1, .75);
            bucketDumpTopLevel();

            ITDBot.strafeRight(1, .15);
            ITDBot.driveBack(1,1);

            requestOpModeStop();

    }
    idle();
}
}

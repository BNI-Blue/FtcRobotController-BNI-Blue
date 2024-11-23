package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red.Paths;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red.RedAlliance;

@Autonomous(name = "Red:Net:TopBucket:LowBarTouch")
public class RedNetTopBucketLowBar extends RedAlliance {
    @Override
    public void runOpMode() throws InterruptedException {
        // Global Method for Initializing Auto
        autoStartUp();

        waitForStart();

        ITDBot.retractIntake();

        while (opModeIsActive()) {

// Go to net and place sample
            ITDBot.strafeLeft(0.5, 1.6);
            sleep(100);
            ITDBot.driveBack(0.5, .1);
            bucketDumpTopLevel();

// Move to face bar
            ITDBot.rotateRight(0.5,1);
// Go to bar and touch
            ITDBot.strafeLeft(0.5,3);
            sleep(50);
            ITDBot.driveForward(0.5,2);
            ITDBot.climbing_lift(0.5);

            requestOpModeStop();
        }
        idle();
    }
}

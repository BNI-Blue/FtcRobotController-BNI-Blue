package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Tester;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

//@Disabled
@Autonomous(name = "Tester:Rotations", group = "Testers")
public class TesterRotations extends TesterBlueAlliance{
    @Override
    public void runOpMode() throws InterruptedException {

        // Global Method for Initializing Auto
        autoStartUp();

        waitForStart();

        //drive methods are pulled from Drivetrain
        while (opModeIsActive()) {

            //drive code
            while (opModeIsActive()) {

                Bot.driveForward(1, 1);
                sleep(2000);
                Bot.driveBack(1, 0.5);
                sleep(2000);
                Bot.strafeLeft(1, 1);
                sleep(2000);
                Bot.strafeRight(1, 0.5);
                sleep(2000);
                Bot.rotateLeft(1, 1);
                sleep(2000);
                Bot.rotateRight(1, 0.5);
                sleep(2000);

                requestOpModeStop();

            }
            idle();
        }
    }
}

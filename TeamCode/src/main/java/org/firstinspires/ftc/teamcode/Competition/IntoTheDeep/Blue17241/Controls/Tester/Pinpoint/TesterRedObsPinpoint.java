package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Tester.Pinpoint;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Tester.TesterRedAlliance;

@Disabled
@Autonomous(name = "TesterRedObsPinpoint")
public class TesterRedObsPinpoint extends TesterRedAlliance {
    @Override
    public void runOpMode() throws InterruptedException {

        // Global Method for Initializing Auto
        autoStartUp();

        waitForStart();

        //drive methods are pulled from Drivetrain
        while (opModeIsActive()) {

            driveStraightGyroPinpoint(.5, 7, "FORWARD", 0);
            Bot.rotateLeft(.5, 3.25);
            driveStraightGyroPinpoint(0.5, 1.5, "FORWARD", 0);
            Bot.rotateRight(.5, 2.5);
            driveStraightGyroPinpoint(0.5, 15, "FORWARD", 0);
            Bot.rotateLeft(0.65, 3.5);
            driveStraightGyroPinpoint(0.5, 5, "FORWARD", 0);
            Bot.rotateRight(0.65, 4);
            driveStraightGyroPinpoint(0.5, 14, "FORWARD", 0);

            requestOpModeStop();

        }
        idle();
    }
}

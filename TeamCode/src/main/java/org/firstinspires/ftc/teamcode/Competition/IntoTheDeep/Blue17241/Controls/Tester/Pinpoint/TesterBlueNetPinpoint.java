package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Tester.Pinpoint;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Tester.TesterBlueAlliance;
import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Robots.ProgrammerBot;

//@Disabled
@Autonomous(name = "TesterBlueNetPinpoint")
public class TesterBlueNetPinpoint extends TesterBlueAlliance {
    @Override
    public void runOpMode() throws InterruptedException {

        // Global Method for Initializing Auto
        autoStartUp();

        waitForStart();

        //drive methods are pulled from Drivetrain

            //drive code
            while (opModeIsActive()) {

                strafeGyroPinpoint(0.5, 5, "RIGHT", 0);
                driveStraightGyroPinpoint(.5, 1.1, "FORWARD", 0);
                driveStraightGyroPinpoint(.5, 13, "BACK", 0);
                Bot.rotateRight(0.65, 3.5);
                strafeGyroPinpoint(0.5, 3, "RIGHT", 0);
                driveStraightGyroPinpoint(0.5, 15, "FORWARD", 0);
                Bot.rotateLeft(0.65, 3);
                driveStraightGyroPinpoint(.5, 14, "FORWARD", 0);
                driveStraightGyroPinpoint(.5, 18, "BACK", 0);
                Bot.rotateRight(0.65, 3.5);



                requestOpModeStop();

            }
            idle();

    }
}

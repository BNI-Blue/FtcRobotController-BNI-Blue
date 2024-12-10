package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Tester.Pinpoint;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Tester.TesterRedAlliance;

@Autonomous(name = "RedNetPinpoint")
//@Disabled
public class TesterRedNetPinpoint extends TesterRedAlliance {
    @Override
    public void runOpMode() throws InterruptedException {

        // Global Method for Initializing Auto
        autoStartUp();

        waitForStart();

        //drive methods are pulled from Drivetrain
        while (opModeIsActive()) {


                strafeGyroPinpoint(0.5, 5, "RIGHT", 0);
                driveStraightGyroPinpoint(0.5, 1.5, "FORWARD", 0);
                driveStraightGyroPinpoint(.5, 13, "BACK", 0);
                Bot.rotateRight(0.65, 3.2);
                strafeGyroPinpoint(0.5, 3, "RIGHT", 0);
                driveStraightGyroPinpoint(0.5, 12, "FORWARD", 0);
                Bot.rotateLeft(0.65, 2.5);
                driveStraightGyroPinpoint(0.5, 5, "FORWARD", 0);
                Bot.rotateLeft(0.65, 1);
                driveStraightGyroPinpoint(0.5, 12, "FORWARD", 0);


                requestOpModeStop();

            }
            idle();
    }
}

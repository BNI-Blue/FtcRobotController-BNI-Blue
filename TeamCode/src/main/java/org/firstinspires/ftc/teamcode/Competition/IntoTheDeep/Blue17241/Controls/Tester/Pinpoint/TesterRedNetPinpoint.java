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
            sleep(1000);
            driveStraightGyroPinpoint(.5, 1.5, "FORWARD", 0);
            sleep(1000);
            driveStraightGyroPinpoint(.5, 13, "BACK", 0);
            sleep(1000);
            Bot.rotateRight(0.65, 3.5);
            sleep(1000);
            strafeGyroPinpoint(0.5, 2, "RIGHT", 0);
            sleep(1000);
            driveStraightGyroPinpoint(0.5, 12, "FORWARD", 0);
            sleep(1000);
            Bot.rotateLeft(0.65, 3.5);
            sleep(1000);
            driveStraightGyroPinpoint(.5, 14, "FORWARD", 0);
            sleep(1000);
            driveStraightGyroPinpoint(.5, 18, "BACK", 0);
            sleep(1000);
            Bot.rotateRight(0.65, 3.5);
            sleep(1000);

                requestOpModeStop();

            }
            idle();
    }
}

package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Tester.Pintpoint;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Tester.TesterBlueAlliance;
import org.firstinspires.ftc.teamcode.Competition.Z20232024CenterStage.Blue17241.Robots.ProgramBot;

//@Disabled
@Autonomous(name = "TesterBlueNetPinpoint")
public class TesterBlueNetPinpoint extends TesterBlueAlliance {
    @Override
    public void runOpMode() throws InterruptedException {

        // Global Method for Initializing Auto
        autoStartUp();

        waitForStart();

        //drive methods are pulled from Drivetrain
        while (opModeIsActive()) {

            //drive code
            while (opModeIsActive()) {

                strafeLeftPinpoint(.5, 24);
                driveStraightGyroPinpoint(1, 24, "FORWARD");


                requestOpModeStop();

            }
            idle();
        }
    }
}

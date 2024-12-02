package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Tester.Pinpoint;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Tester.TesterBlueAlliance;

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

                strafeGyroPinpoint(0.5, 24, "RIGHT", 0);


                requestOpModeStop();

            }
            idle();
        }
    }
}

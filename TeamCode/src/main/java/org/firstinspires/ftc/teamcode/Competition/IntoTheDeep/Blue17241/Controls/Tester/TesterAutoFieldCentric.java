package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Tester;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

//@Disabled
@Autonomous(name = "Tester:Blue:FieldCentric", group = "Testers")
public class TesterAutoFieldCentric extends TesterBlueAlliance {
    @Override
    public void runOpMode() throws InterruptedException {

        // Global Method for Initializing Auto
        autoStartUp();

        resetHeading();
        currentHeading = getHeading();
        odo.update();
        waitForStart();


        while (opModeIsActive()) {

            // Insert Tester Code
            driveToPosition(10,10,45,.40);

            requestOpModeStop();

        }
        idle();
    }



}

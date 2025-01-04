package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Tester;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

//@Disabled
@Autonomous(name = "Tester:Blue:FieldCentricPID", group = "Testers")
public class TesterAutoFieldCentricPID extends TesterBlueAlliance {
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

            driveToPositionPID(15,-15,45,.50);
            sleep(4000);

            requestOpModeStop();

        }
        idle();
    }



}


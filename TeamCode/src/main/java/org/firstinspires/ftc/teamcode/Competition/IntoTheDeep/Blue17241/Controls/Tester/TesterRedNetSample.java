package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Tester;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Disabled
@Autonomous(name = "Tester:Red:Net:Sample", group = "Testers")
public class TesterRedNetSample extends TesterRedAlliance{
    @Override
    public void runOpMode() throws InterruptedException {

        // Global Method for Initializing Auto
        autoStartUp();

        waitForStart();

        //drive methods are pulled from Drivetrain
        while (opModeIsActive()) {

            //drive code
            while (opModeIsActive()) {

                strafeRightPinpoint(0.5, 0.5);
                sleep(1000);

                driveForwardPinpoint(0.5, 1);
                sleep(1000);

                driveBackPinpoint(.5, 8);
                sleep(1000);

//                Bot.rotateRight(.5 ,7);
//                sleep(100);
//


                odo.update();
                requestOpModeStop();

                requestOpModeStop();

            }
            idle();
        }
    }
}

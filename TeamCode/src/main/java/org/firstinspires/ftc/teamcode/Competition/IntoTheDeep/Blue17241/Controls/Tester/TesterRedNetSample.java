package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Tester;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

//@Disabled
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

                Bot.strafeRight(1, .15);
                Bot.driveForward(1, 3.85);
                sleep(1300);

                requestOpModeStop();

            }
            idle();
        }
    }
}

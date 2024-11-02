package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

//@Disabled
@Autonomous(name = "Red:Net:Sample:Park")
public class RedNetSamplePark extends RedAlliance {
    @Override
    public void runOpMode() throws InterruptedException{

        // Global Method for Initializing Auto
        autoStartUp();

        waitForStart();


        //drive methods are pulled from Drivetrain
        while(opModeIsActive()){

            ITDBot.strafeLeft(1, .13);
            ITDBot.driveBack(1, 3.7);
            ITDBot.sampleOuttake();
            sleep(1400);

            ITDBot.intakeStop();

            //Code for if partner can move away from wall
            ITDBot.strafeRight(1, .15);
            ITDBot.driveForward(1, 8);

            requestOpModeStop();

        }
        idle();
    }
}
package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

//@Disabled
@Autonomous(name = "Blue:Observation:Auto")
public class BlueObsAuto extends BlueAlliance {
    @Override
    public void runOpMode() throws InterruptedException{

        // Global Method for Initializing Auto
        autoStartUp();

        waitForStart();

        //drive methods are pulled from Drivetrain
        while (opModeIsActive()){

//            blueObsSampleOne();
//            blueObsSampleTwo();
//            blueObsSampleThree();
            ITDBot.strafeLeft(1, .2);
            ITDBot.driveForward(1, 2.5);

            requestOpModeStop();

        }
        idle();
    }
}
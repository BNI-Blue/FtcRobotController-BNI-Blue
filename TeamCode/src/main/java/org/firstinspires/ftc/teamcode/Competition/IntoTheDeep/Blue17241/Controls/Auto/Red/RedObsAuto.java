package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

//@Disabled
@Autonomous(name = "RedObsAuto")
public class RedObsAuto extends RedAlliance {
    @Override
    public void runOpMode() throws InterruptedException{
        autoStartUp();

        waitForStart();

        //drive methods are pulled from Drivetrain
        while (opModeIsActive()){

//            redObsSampleOne();
//            redObsSampleTwo();
//            redObsSampleThree();
            ITDBot.strafeRight(1, .2);
            ITDBot.driveBack(1, 2.2);


            requestOpModeStop();

        }
        idle();
    }
}
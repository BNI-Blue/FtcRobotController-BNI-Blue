package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

//@Disabled
@Autonomous(name = "BlueNetAuto")
public class BlueNetAuto extends BlueAlliance {
    @Override
    public void runOpMode() throws InterruptedException {
        // Initializes and sets up robot for auto (code in AutoMain)
        autoStartUp();
        waitForStart();


        //drive methods are pulled from Drivetrain
        while (opModeIsActive()) {

            //drive code
            while (opModeIsActive()) {

                ITDBot.strafeRight(1, .15);
                ITDBot.driveForward(1, 3.85);
                ITDBot.sampleOuttake();
                sleep(1300);
                ITDBot.intakeStop();

                //Code for if partner can move away from wall
                //ITDBot.strafeRight(1, .15);
                //ITDBot.driveBack(1, 8);


                requestOpModeStop();
//            blueNetSampleOne();
//            blueNetSampleTwo();

//            blueNetSampleThree();

            }
            idle();
        }
    }
}


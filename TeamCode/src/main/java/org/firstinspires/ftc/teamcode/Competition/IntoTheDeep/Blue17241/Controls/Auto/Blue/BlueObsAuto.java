package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

//@Disabled
@Autonomous(name = "BlueObsAuto")
public class BlueObsAuto extends BlueAlliance {
    @Override
    public void runOpMode() throws InterruptedException{
        ITDBot.initRobot(hardwareMap);
        ITDBot.setLinearOp(this);

        telemetry.addLine("Awaiting Start");
        telemetry.update();
        ITDBot.retractIntake();
        waitForStart();


        //drive methods are pulled from Drivetrain
        while (opModeIsActive()){

//            blueObsSampleOne();
//            blueObsSampleTwo();
//            blueObsSampleThree();
            ITDBot.strafeRight(1, .2);
            ITDBot.driveBack(1, 2.5);

            requestOpModeStop();

        }
        idle();
    }
}
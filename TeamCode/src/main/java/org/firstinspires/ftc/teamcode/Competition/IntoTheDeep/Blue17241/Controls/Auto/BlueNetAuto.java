package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Robots.ITDBot;

@Autonomous(name = "BlueNetAuto")
public class BlueNetAuto extends BlueAlliance {
    @Override
    public void runOpMode() throws InterruptedException{
        ITDBot.initRobot(hardwareMap);
        ITDBot.setLinearOp(this);

        telemetry.addLine("Awaiting Start");
        telemetry.update();

        waitForStart();

        //drive methods are pulled from Drivetrain
        while (opModeIsActive()){

            //drive code

            blueNetSampleOne();
            blueNetSampleTwo();
            blueNetSampleThree();



            requestOpModeStop();
        }
        idle();
    }
}
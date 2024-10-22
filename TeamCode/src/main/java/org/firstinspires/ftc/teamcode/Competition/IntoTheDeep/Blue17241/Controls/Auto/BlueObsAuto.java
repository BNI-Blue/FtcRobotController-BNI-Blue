package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "BlueObsAuto")
public class BlueObsAuto extends BlueAlliance{
    @Override
    public void runOpMode() throws InterruptedException{
        ITDBot.initRobot(hardwareMap);
        ITDBot.setLinearOp(this);

        telemetry.addLine("Awaitng Start");
        telemetry.update();

        waitForStart();

        //drive methods are pulled from Drivetrain
        while (opModeIsActive()){

            blueObsSampleOne();
            blueObsSampleTwo();
            blueObsSampleThree();

            requestOpModeStop();

        }
        idle();
    }
}
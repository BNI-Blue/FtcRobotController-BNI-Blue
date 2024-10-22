package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "RedObsAuto")
public class RedObsAuto extends RedAlliance{
    @Override
    public void runOpMode() throws InterruptedException{
        ITDBot.initRobot(hardwareMap);
        ITDBot.setLinearOp(this);

        telemetry.addLine("Awaiting Start");
        telemetry.update();

        waitForStart();

        //drive methods are pulled from Drivetrain
        while (opModeIsActive()){

            redObsSampleOne();
            redObsSampleTwo();
            redObsSampleThree();

            requestOpModeStop();

        }
        idle();
    }
}
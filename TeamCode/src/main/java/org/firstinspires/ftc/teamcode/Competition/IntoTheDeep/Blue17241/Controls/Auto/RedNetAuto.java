package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "RedNetAuto")
public class RedNetAuto extends RedAlliance{
    @Override
    public void runOpMode() throws InterruptedException{
        Bot.initRobot(hardwareMap);
        Bot.setLinearOp(this);

        telemetry.addLine("Awaiting Start");
        telemetry.update();

        waitForStart();

        //drive methods are pulled from Drivetrain
        while(opModeIsActive()){

            Bot.strafeLeft(1, 3.4);
            Bot.driveForward(1, 2);
            Bot.rotateLeft(1, 3.7);
            Bot.driveForward(1, 2.4);

            Bot.driveBack(1, 2.8);
            Bot.rotateRight(1, 1.8);
            Bot.driveForward(1, 1.2);
            Bot.rotateLeft(1, 1.5);
            Bot.driveForward(1, 2);

            Bot.driveBack(1, 2.8);
            Bot.rotateRight(1, 1.8);
            Bot.driveForward(1, 1.2);
            Bot.rotateLeft(1, 1.5);
            Bot.driveForward(1, 2);

            requestOpModeStop();

        }
        idle();
    }
}
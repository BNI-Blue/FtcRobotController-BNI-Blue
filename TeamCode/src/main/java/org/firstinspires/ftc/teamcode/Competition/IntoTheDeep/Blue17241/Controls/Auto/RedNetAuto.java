package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "RedNetAuto")
public class RedNetAuto extends RedAlliance{
    @Override
    public void runOpMode() throws InterruptedException{
        ITDBot.initRobot(hardwareMap);
        ITDBot.setLinearOp(this);

        telemetry.addLine("Awaiting Start");
        telemetry.update();

        waitForStart();

        //drive methods are pulled from Drivetrain
        while(opModeIsActive()){

            ITDBot.strafeLeft(1, 3.4);
            ITDBot.driveForward(1, 2);
            ITDBot.rotateLeft(1, 3.7);
            ITDBot.driveForward(1, 2.4);

            ITDBot.driveBack(1, 2.8);
            ITDBot.rotateRight(1, 1.8);
            ITDBot.driveForward(1, 1.2);
            ITDBot.rotateLeft(1, 1.5);
            ITDBot.driveForward(1, 2);

            ITDBot.driveBack(1, 2.8);
            ITDBot.rotateRight(1, 1.8);
            ITDBot.driveForward(1, 1.2);
            ITDBot.rotateLeft(1, 1.5);
            ITDBot.driveForward(1, 2);

            requestOpModeStop();

        }
        idle();
    }
}
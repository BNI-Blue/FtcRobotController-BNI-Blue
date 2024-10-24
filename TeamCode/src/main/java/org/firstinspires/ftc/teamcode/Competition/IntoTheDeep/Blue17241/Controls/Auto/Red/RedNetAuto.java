package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Disabled
@Autonomous(name = "RedNetAuto")
public class RedNetAuto extends RedAlliance {
    @Override
    public void runOpMode() throws InterruptedException{
        ITDBot.initRobot(hardwareMap);
        ITDBot.setLinearOp(this);

        telemetry.addLine("Awaiting Start");
        telemetry.update();

        waitForStart();

        //drive methods are pulled from Drivetrain
        while(opModeIsActive()){

            redNetSampleOne();
            redNetSampleTwo();
            redNetSampleThree();

            requestOpModeStop();

        }
        idle();
    }
}
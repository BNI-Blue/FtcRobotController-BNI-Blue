package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

//@Disabled
@Autonomous(name = "Blue Net Park")
public class BlueNetPark extends BlueAlliance{
    @Override
    public void runOpMode() throws InterruptedException{
        ITDBot.initRobot(hardwareMap);
        ITDBot.setLinearOp(this);

        telemetry.addLine("Awaiting Start");
        telemetry.update();

        waitForStart();

        //drive methods are pulled from Drivetrain
        while(opModeIsActive()){

            sleep(25000);

            ITDBot.strafeRight(1, 7);

            requestOpModeStop();

        }
        idle();
    }
}

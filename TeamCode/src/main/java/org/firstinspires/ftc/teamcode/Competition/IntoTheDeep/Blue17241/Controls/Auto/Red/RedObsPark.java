package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Disabled
@Autonomous(name = "Red Obs Park")
public class RedObsPark extends RedAlliance{
    @Override
    public void runOpMode() throws InterruptedException{
        autoStartUp();
        waitForStart();

        //drive methods are pulled from Drivetrain
        while(opModeIsActive()){

            sleep(25000);

            ITDBot.strafeRight(1, 3);

            requestOpModeStop();

        }
        idle();
    }
}

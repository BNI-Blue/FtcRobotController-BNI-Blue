package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Disabled
@Autonomous(name = "Blue Obs Park")
public class BlueObsPark extends BlueAlliance{
    @Override
    public void runOpMode() throws InterruptedException{
        autoStartUp();

        waitForStart();
        ITDBot.retractIntake();

        //drive methods are pulled from Drivetrain
        while(opModeIsActive()){

            sleep(25000);

            ITDBot.strafeLeft(1, 3);

            requestOpModeStop();

        }
        idle();
    }
}

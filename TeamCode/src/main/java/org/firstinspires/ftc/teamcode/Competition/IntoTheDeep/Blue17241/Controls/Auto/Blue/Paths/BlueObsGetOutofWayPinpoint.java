package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.Paths;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.BlueAlliance;

@Disabled

@Autonomous(name = "Blue:Obs:GetoutWay:Pinpoint")
public class BlueObsGetOutofWayPinpoint extends BlueAlliance {
    //@Override
    public void runOpMode() throws InterruptedException{
        autoStartUp();
        resetHeading();
        currentHeading = getHeading();
        odo.update();
        waitForStart();


        //drive methods are pulled from Drivetrain
        while(opModeIsActive()){

            strafeRightPinpoint(1, 2);
            sleep(25000);
            requestOpModeStop();

        }
        idle();
    }
}

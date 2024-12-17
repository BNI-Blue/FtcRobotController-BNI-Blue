package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red.Paths;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red.RedAlliance;

@Disabled
@Autonomous(name = "Red:Obs:GetoutWay:Pinpoint")
public class RedObsGetOutOfWayPinpoint extends RedAlliance {
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

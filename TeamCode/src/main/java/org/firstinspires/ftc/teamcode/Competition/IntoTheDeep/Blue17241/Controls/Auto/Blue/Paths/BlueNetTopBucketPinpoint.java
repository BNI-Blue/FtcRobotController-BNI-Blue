package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.Paths;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.BlueAlliance;

//@Disabled

@Autonomous(name ="Blue:Net:TopBucket:Pinpoint")
public class BlueNetTopBucketPinpoint extends BlueAlliance{
    //@Override
    public void runOpMode() throws InterruptedException{
        autoStartUp();
        resetHeading();
        currentHeading = getHeading();
        odo.update();
        waitForStart();

        while(opModeIsActive()) {

            strafeLeftPinpoint(0.5, 1.6);
            sleep(100);
            driveBackPinpoint(0.5, .1);
            bucketDumpTopLevel();

            requestOpModeStop();
        }
    }
}

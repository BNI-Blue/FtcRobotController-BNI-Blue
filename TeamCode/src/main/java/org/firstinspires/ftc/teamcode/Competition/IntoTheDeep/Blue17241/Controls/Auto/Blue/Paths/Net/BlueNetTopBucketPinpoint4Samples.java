package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.Paths.Net;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.BlueAlliance;


@Disabled
@Autonomous(name ="Blue:Net:TopBucket:Pinpoint:4Samples")
public class BlueNetTopBucketPinpoint4Samples extends BlueAlliance{
    //@Override
    public void runOpMode() throws InterruptedException{
        autoStartUp();
        resetHeadingPinpoint();
        currentHeading = getHeadingPinpoint();
        odo.update();
        waitForStart();

        while(opModeIsActive()) {

            blueNetPreloadSpikeOne();

            blueNetSpikeTwo();

            blueNetSpikeThree();

            requestOpModeStop();
        }
    }
}

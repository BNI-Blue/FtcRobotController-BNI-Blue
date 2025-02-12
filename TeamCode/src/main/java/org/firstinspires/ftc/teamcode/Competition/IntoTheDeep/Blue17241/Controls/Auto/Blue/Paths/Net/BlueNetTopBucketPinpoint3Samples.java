package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.Paths.Net;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.BlueAlliance;

//@Disabled

@Autonomous(name ="Blue:Net:TopBucket:Pinpoint:3Samples")
public class BlueNetTopBucketPinpoint3Samples extends BlueAlliance{
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

            requestOpModeStop();
        }
    }
}

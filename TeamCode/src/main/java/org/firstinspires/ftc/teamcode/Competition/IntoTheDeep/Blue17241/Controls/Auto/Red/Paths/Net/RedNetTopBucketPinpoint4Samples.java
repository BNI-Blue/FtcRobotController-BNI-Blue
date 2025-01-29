package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red.Paths.Net;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red.RedAlliance;

@Autonomous(name ="Red:Net:TopBucket:Pinpoint:3Samples")
public class RedNetTopBucketPinpoint4Samples extends RedAlliance {
    //@Override
    public void runOpMode() throws InterruptedException{
        autoStartUp();
        resetHeadingPinpoint();
        currentHeading = getHeadingPinpoint();
        odo.update();
        waitForStart();

        while(opModeIsActive()) {

            redNetPreloadSpikeOne();

            //move to second field sample
            redNetSpikeTwo();

            redNetSpikeThree();

            requestOpModeStop();
        }
    }
}

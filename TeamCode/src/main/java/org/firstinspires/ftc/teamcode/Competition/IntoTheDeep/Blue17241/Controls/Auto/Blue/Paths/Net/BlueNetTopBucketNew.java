package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.Paths.Net;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.BlueAlliance;

@Autonomous(name = "Blue:Net:TopBucket:New")
public class BlueNetTopBucketNew extends BlueAlliance{
    @Override
    public void runOpMode() throws InterruptedException{
        autoStartUp();

        waitForStart();

        ITDBot.neutralIntake();

        while(opModeIsActive()){

            //Move robot to score the pre-loaded sample.
            ITDBot.strafeLeft(0.5, 1.6);
            sleep(100);
            ITDBot.driveBack(0.5, .45);
            bucketDumpTopLevel();
            ITDBot.retractIntake();

            //Engage intake to intake! and Extend extender WITH INTAKE INTAKING
            ITDBot.sampleIntake();
            ITDBot.extendIntake();

            ITDBot.driveForward(0.5,0.5);
            ITDBot.rotateLeft(0.5,1);
            ITDBot.intakeStop();

            ITDBot.scoreIntake();
            ITDBot.retractIntake();

            ITDBot.sampleOuttake();
            sleep(200);
            ITDBot.intakeStop();

            ITDBot.neutralIntake();
            ITDBot.driveBack(0.5,0.5);
            ITDBot.rotateRight(0.5,1);

            bucketDumpTopLevel();
            ITDBot.retractIntake();
        }


    }
}

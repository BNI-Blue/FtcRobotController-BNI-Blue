package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

//@Disabled
@Autonomous(name = "RedNetAuto")
public class RedNetAuto extends RedAlliance {
    @Override
    public void runOpMode() throws InterruptedException{
        ITDBot.initRobot(hardwareMap);
        ITDBot.setLinearOp(this);

        telemetry.addLine("Awaiting Start");
        telemetry.update();
        ITDBot.retractIntake();
        waitForStart();
        ITDBot.retractIntake();

        //drive methods are pulled from Drivetrain
        while(opModeIsActive()){

            ITDBot.strafeLeft(1, .2);
            ITDBot.driveBack(1, 3.5);
            ITDBot.sampleOuttake();
            sleep(1000);
            ITDBot.intakeStop();

//            redNetSampleOne();
//            redNetSampleTwo();
//            redNetSampleThree();

            requestOpModeStop();

        }
        idle();
    }
}
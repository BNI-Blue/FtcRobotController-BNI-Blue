package org.firstinspires.ftc.teamcode.Competition.Z20232024CenterStage.Blue17241.Controls.Autonomous.StartPositions.NoCamera;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.Z20232024CenterStage.Blue17241.Controls.Autonomous.AutoBlueAlliance;

@Disabled
@Autonomous(name="Blue:Audience:Start_1")
public class BlueAudienceStart_Truss1 extends AutoBlueAlliance {


    @Override
    public void runOpMode() throws InterruptedException{
        Bot.initRobot(hardwareMap);
        Bot.setLinearOp(this);

        telemetry.addLine("Awaiting Start");
        telemetry.update();


        waitForStart();

        while(opModeIsActive()){

            // INSERT AUTO CODE BELOW


            Bot.driveForward(.25, .28);
            sleep(100);


            Bot.rotateLeft(0.25, 3);
            sleep(100);


            Bot.driveForward(.5,9);
            sleep(100);

            // INSERT AUTO CODE ABOVE

            requestOpModeStop();

        }

        idle();
    }
}

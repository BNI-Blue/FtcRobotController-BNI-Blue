package org.firstinspires.ftc.teamcode.Competition.Z20232024CenterStage.Blue17241.Controls.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.Z20232024CenterStage.Blue17241.Robots.AckerBot;
import org.firstinspires.ftc.teamcode.Competition.Z20232024CenterStage.Blue17241.Robots.BlueBot;

@Disabled
@Autonomous(name= "Encoder Tester")
public class Auto_Encoder_Tester extends AutoMain{
    // Construct Competition and Programming Robots
    public BlueBot Bot = new BlueBot();
    public AckerBot programBot = new AckerBot();

    // Boolean Flag to determine which robot we are using
    public boolean isCompetition = true;

    @Override
    public void runOpMode() throws InterruptedException {

        if (isCompetition) {
            Bot.initRobot(hardwareMap);
            Bot.setLinearOp(this);
        } else {
            programBot.initRobot(hardwareMap);
           // programBot.setLinearOp(this);
        }

        telemetry.addLine("WAITING FOR START >");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            // ***** INSERT AUTONOMOUS CODE BELOW THIS LINE  *****

            telemetry.addLine("Driving Forward");
            telemetry.update();
            Bot.driveForward(.75, 2);
            sleep(1000);

            telemetry.addLine("Rotating Left");
            telemetry.update();
            Bot.strafeLeft(.40, 2);
            sleep(1000);

            telemetry.addLine("Rotating Right");
            telemetry.update();
            Bot.strafeRight(.75, 2);
            sleep(1000);

            telemetry.addLine("Driving Backwards");
            telemetry.update();
            Bot.driveBack(.40, 2);
            sleep(1000);

            telemetry.addLine("Strafe Left");
            telemetry.update();
            Bot.rotateLeft(.5, 2);
            sleep(1000);

            telemetry.addLine("Strafe Right");
            telemetry.update();
            Bot.rotateRight(.5, 2);
            sleep(1000);


            // ***** INSERT AUTONOMOUS CODE ABOVE THIS LINE  *****


            requestOpModeStop();
        }
        idle();
    }
}

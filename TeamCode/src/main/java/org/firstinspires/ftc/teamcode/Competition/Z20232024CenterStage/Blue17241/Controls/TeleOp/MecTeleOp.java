package org.firstinspires.ftc.teamcode.Competition.Z20232024CenterStage.Blue17241.Controls.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Competition.Z20232024CenterStage.Blue17241.Robots.AckerBot;
@Disabled
@TeleOp (name = "MecTeleOp")
public class MecTeleOp extends OpMode {

    double leftStickYVal;
    double leftStickXVal;
    double rightStickYVal;
    double rightStickXVal;

    double frontLeftSpeed;
    double frontRightSpeed;
    double rearLeftSpeed;
    double rearRightLeftSpeed;

    double powerThreshold = 0;
    double speedMultiply = 1;

    public AckerBot MecBot = new AckerBot();

    @Override
    public void init(){MecBot.initRobot(hardwareMap);}
    @Override
    public void loop(){};

}

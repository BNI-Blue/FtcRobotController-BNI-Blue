package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Sensors;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Robots.ProgrammerBot;

import java.util.concurrent.TimeUnit;

@TeleOp (name = "RGB Light Tester")
public class TesterRGBLight extends OpMode{

    //Instantiate Desired Robot
    ProgrammerBot Bot = new ProgrammerBot();

    //Instantiate RGB Light
    RGBLight led = new RGBLight();

    //Initiliaze Variables for Time Tracking
    public ElapsedTime timer = new ElapsedTime();
    public double remainingTime;
    public double elapsedTime;

    //Initiliaze and Declare Variables for Color Enum
    public RGBLight.ColorOptions color = RGBLight.ColorOptions.OFF;

    @Override
    public void init() {

        Bot.initRobot(hardwareMap);
        led.initRGBLight(hardwareMap);
        led.setColor(RGBLight.ColorOptions.OFF);
    }

    @Override
    public void start() {

        timer.reset();
    }

    @Override
    public void loop() {

        lightControl();
        telemetry();
    }



    public void lightControl() {
        elapsedTime = timer.time(TimeUnit.SECONDS);
        remainingTime = 30 - elapsedTime;

        if (remainingTime > 20) {
            led.setColor(RGBLight.ColorOptions.GREEN);
            color = RGBLight.ColorOptions.GREEN;
        }
        else if (remainingTime > 10) {
            led.setColor(RGBLight.ColorOptions.YELLOW);
            color = RGBLight.ColorOptions.YELLOW;
        }
        else if (remainingTime > 3) {
            led.setColor(RGBLight.ColorOptions.RED);
            color = RGBLight.ColorOptions.RED;
        }
        else {
            led.setColor(RGBLight.ColorOptions.OFF);
            color = RGBLight.ColorOptions.OFF;
        }
    }



    public void telemetry(){

        telemetry.addData("Color: ", color);
        telemetry.addData("Elapsed Time: ", elapsedTime);
        telemetry.addData("Remaining Time: ", remainingTime);
        telemetry.update();
    }


}

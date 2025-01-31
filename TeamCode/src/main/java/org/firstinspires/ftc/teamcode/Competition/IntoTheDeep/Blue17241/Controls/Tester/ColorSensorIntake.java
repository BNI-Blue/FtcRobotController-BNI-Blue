package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Tester;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.LEDGold.IndicatorStrip;
import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Robots.ProgrammerBot;

@TeleOp (name = "Color Sensor Tester")
public class ColorSensorIntake extends OpMode{

    HardwareMap hwBot = null;

    ProgrammerBot Bot = new ProgrammerBot();
    public RevColorSensorV3 sensor;
    IndicatorStrip indicator = new IndicatorStrip();
    public RevBlinkinLedDriver strip;
    double distance = sensor.getDistance(DistanceUnit.INCH);

    private ElapsedTime time = new ElapsedTime();

    double sampleSecuredDistance = 1.3;

    public void initRobot(HardwareMap hwMap) {
       hwBot = hwMap;
       sensor = hwBot.get(RevColorSensorV3.class, "sample_sensor");
       //indicator = hwBot.get(RevBlinkinLedDriver.class, "indicator_strip");
    }

    @Override
    public void init() {
        initRobot(hardwareMap);
    }

    public void loop() {
        calcIntake();
        telemetry();
    }


    public void calcIntake() {
        NormalizedRGBA colors = sensor.getNormalizedColors();
        double red = colors.red;
        double green = colors.green;
        double blue = colors.blue;


        RevBlinkinLedDriver.BlinkinPattern color;

        double max = Math.max(red, Math.max(green, blue));//why do i need: Math.max(green, blue)(doesnt work if thats not there)

        if(max == green) color = RevBlinkinLedDriver.BlinkinPattern.GREEN;
        else color = RevBlinkinLedDriver.BlinkinPattern.BLACK;

        indicator.capture(color);

        if(distance > sampleSecuredDistance){
            color = RevBlinkinLedDriver.BlinkinPattern.GREEN;
        }
        else{
            color = RevBlinkinLedDriver.BlinkinPattern.BLACK;
        }
    }

    public void telemetry(){
        telemetry.addData("Distance: ", + distance);
    }


}

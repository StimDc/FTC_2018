package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class MyTeleOpModePentruBicicleta extends LinearOpMode
{
    private DcMotor motor;

    @Override
    public void runOpMode()
    {
        motor = hardwareMap.get(DcMotor.class, "miscare_stanga");

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        float power;
        waitForStart();

        while(opModeIsActive())
        {
            power = this.gamepad1.left_stick_y;
            telemetry.addData("Status", "Running");
            telemetry.addData("MotorPower", power);
            telemetry.update();
            motor.setPower(power);
        }
    }
}

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class MiscareRotiNoi extends LinearOpMode
{
    private DcMotor motor_fata_stanga;
    private DcMotor motor_fata_dreapta;
    private DcMotor motor_spate_stanga;
    private DcMotor motor_spate_dreapta;

    @Override
    public void runOpMode()
    {
        motor_fata_dreapta = hardwareMap.get(DcMotor.class, "FR");
        motor_fata_stanga = hardwareMap.get(DcMotor.class, "FL");
        motor_spate_dreapta = hardwareMap.get(DcMotor.class, "BR");
        motor_spate_stanga = hardwareMap.get(DcMotor.class, "BL");

        motor_fata_dreapta.setDirection(DcMotorSimple.Direction.FORWARD);
        motor_fata_stanga.setDirection(DcMotorSimple.Direction.REVERSE);
        motor_spate_dreapta.setDirection(DcMotorSimple.Direction.FORWARD);
        motor_spate_stanga.setDirection(DcMotorSimple.Direction.REVERSE);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        boolean lateral=false;

        while(opModeIsActive())
        {
            telemetry.addData("Status", "Running");
            telemetry.update();

            if(this.gamepad1.left_stick_y==0 && lateral ==false)
            {
                motor_fata_stanga.setPower(0);
                motor_fata_dreapta.setPower(0);
                motor_spate_stanga.setPower(0);
                motor_spate_dreapta.setPower(0);
            }
            if(this.gamepad1.left_stick_y==-1)
            {
                motor_fata_stanga.setPower(0.5);
                motor_fata_dreapta.setPower(0.5);
                motor_spate_stanga.setPower(0.5);
                motor_spate_dreapta.setPower(0.5);
            }
            if(this.gamepad1.left_stick_y==1)
            {
                motor_fata_stanga.setPower(-0.5);
                motor_fata_dreapta.setPower(-0.5);
                motor_spate_stanga.setPower(-0.5);
                motor_spate_dreapta.setPower(-0.5);
            }
            if(this.gamepad1.right_stick_x==1)
            {
                lateral = true;
                motor_fata_stanga.setPower(-0.5);
                motor_fata_dreapta.setPower(-0.5);
                motor_spate_stanga.setPower(0.5);
                motor_spate_dreapta.setPower(0.5);
            }
            if(this.gamepad1.right_stick_x==-1)
            {
                lateral = true;
                motor_fata_stanga.setPower(0.5);
                motor_fata_dreapta.setPower(0.5);
                motor_spate_stanga.setPower(-0.5);
                motor_spate_dreapta.setPower(-0.5);
            }
            if(this.gamepad1.right_stick_x==0)
            {
                lateral = false;
            }
            if(this.gamepad1.b == true)
            {
                motor_fata_stanga.setPower(0.5);
                motor_fata_dreapta.setPower(-0.5);
                motor_spate_stanga.setPower(0.5);
                motor_spate_dreapta.setPower(-0.5);
            }
            if(this.gamepad1.x == true)
            {
                motor_fata_stanga.setPower(-0.5);
                motor_fata_dreapta.setPower(0.5);
                motor_spate_stanga.setPower(-0.5);
                motor_spate_dreapta.setPower(0.5);
            }
        }
    }





}

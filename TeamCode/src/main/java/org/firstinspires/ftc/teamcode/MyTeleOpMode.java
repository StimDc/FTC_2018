package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp
public class MyTeleOpMode extends LinearOpMode
{
    private DcMotor motor_stanga;
    private DcMotor motor_dreapta;
    private DcMotor motor_brat;
    private Servo servo_brat;

    @Override
    public void runOpMode()
    {
        motor_dreapta = hardwareMap.get(DcMotor.class, "miscare_dreapta");
        motor_stanga = hardwareMap.get(DcMotor.class, "miscare_stanga");
        //motor_brat = hardwareMap.get(DcMotor.class, "motor_brat");
        //servo_brat = hardwareMap.get(Servo.class, "servo_brat");

        motor_stanga.setDirection(DcMotorSimple.Direction.FORWARD);
        motor_dreapta.setDirection(DcMotorSimple.Direction.REVERSE);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        double msPower, mdPower, mbPower, sbPower;
        float forward, right;
        forward=0; right=0;

        while(opModeIsActive())
        {
            telemetry.addData("Status", "Running");
            telemetry.addData("forward", forward);
            telemetry.addData("right", right);
            telemetry.update();
            forward = -this.gamepad1.left_stick_y;
            right = this.gamepad1.right_stick_x;

            if(right==0)
            {
                msPower = forward;
                mdPower = forward;
            }
            else
            {
                if(right>0)
                {
                    if(forward>=0)
                    {
                        msPower=right;
                        mdPower=0;
                    }
                    else
                    {
                        msPower=0;
                        mdPower=-right;
                    }
                }
                else
                {
                    if(forward>=0)
                    {
                        msPower=0;
                        mdPower=right;
                    }
                    else
                    {
                        msPower=right;
                        mdPower=0;
                    }
                }
            }
            motor_dreapta.setPower(mdPower);
            motor_stanga.setPower(msPower);
        }
    }





}

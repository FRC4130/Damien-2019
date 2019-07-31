/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Robots;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;

public class RobotMap {

    public static TalonSRX leftDrive;
    public static TalonSRX leftDrive2;
    public static TalonSRX leftDrive3;

    public static TalonSRX rightDrive;
    public static TalonSRX rightDrive2;
    public static TalonSRX rightDrive3;

    public static TalonSRX elevator;

    public static VictorSPX intake;

    public static Joystick DriverStick;
    public static Joystick OperatorStick;

    public static DoubleSolenoid shifter;
    public static DoubleSolenoid clamp;
        
    

    public static void Init(){

        leftDrive = new TalonSRX(1);
        leftDrive2 = new TalonSRX(2);
        leftDrive3 = new TalonSRX(3);

        rightDrive = new TalonSRX(4);
        rightDrive2 = new TalonSRX(5);
        rightDrive3 = new TalonSRX(6);

        elevator = new TalonSRX(7);

        intake = new VictorSPX(1);

        DriverStick = new Joystick(0);
        OperatorStick = new Joystick(1);

        shifter = new DoubleSolenoid(0, 1);
        clamp = new DoubleSolenoid(3, 2);

    }
 
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Robots.RobotMap;

public class DriveTrain {

    private TalonSRX leftDrive;
    private TalonSRX leftDrive2;
    private TalonSRX leftDrive3;

    private TalonSRX rightDrive;
    private TalonSRX rightDrive2;
    private TalonSRX rightDrive3;

    public DoubleSolenoid Air;

    public final Value low = Value.kForward;
    public final Value high = Value.kReverse;

    public DriveTrain() {

        leftDrive = RobotMap.leftDrive;
        leftDrive2 = RobotMap.leftDrive2;
        leftDrive3 = RobotMap.leftDrive3;

        rightDrive = RobotMap.rightDrive;
        rightDrive2 = RobotMap.rightDrive2;
        rightDrive3 = RobotMap.rightDrive3;

        Air = RobotMap.shifter;

        leftDrive2.follow(leftDrive);
        leftDrive3.follow(leftDrive);

        leftDrive.setInverted(true);
        leftDrive2.setInverted(InvertType.FollowMaster);
        leftDrive3.setInverted(InvertType.FollowMaster);

        rightDrive2.follow(rightDrive);
        rightDrive3.follow(rightDrive);

        rightDrive.setInverted(false);
        rightDrive2.setInverted(InvertType.FollowMaster);
        rightDrive3.setInverted(InvertType.FollowMaster);

        leftDrive.set(ControlMode.PercentOutput, 0);
        rightDrive.set(ControlMode.PercentOutput, 0);

        leftDrive.setNeutralMode(NeutralMode.Brake);
        rightDrive.setNeutralMode(NeutralMode.Brake);

        Air.set(high);



    }

    public void Movement(double leftThrottle,double rightThrottle){

        leftDrive.set(ControlMode.PercentOutput,leftThrottle);
        rightDrive.set(ControlMode.PercentOutput,rightThrottle);

    }

    public void setNuetralMode(NeutralMode nm) {

        leftDrive.setNeutralMode(nm);
        leftDrive2.setNeutralMode(nm);
        leftDrive3.setNeutralMode(nm);

        rightDrive.setNeutralMode(nm);
        rightDrive2.setNeutralMode(nm);
        rightDrive3.setNeutralMode(nm);
        
    }

    public void Shifter(Value vl) {

    Air.set(vl);
        
    }
    
}
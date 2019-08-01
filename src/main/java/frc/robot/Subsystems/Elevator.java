/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.Robots.RobotMap;

public class Elevator {

    private TalonSRX elevator;

    public Elevator(){

        elevator = RobotMap.elevator;

        elevator.set(ControlMode.PercentOutput, 0);

        elevator.setNeutralMode(NeutralMode.Brake);

        elevator.configPeakOutputForward(1);
        elevator.configPeakOutputReverse(-1);
        elevator.configNominalOutputForward(0);
        elevator.configNominalOutputReverse(0);
        
        elevator.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);
        elevator.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);
        elevator.configClearPositionOnLimitF(true, 5);

        elevator.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);


    }

    public void Elevate (double elevatorThrottle){

        elevator.set(ControlMode.PercentOutput, elevatorThrottle);

    }

    public void setNuetralMode(NeutralMode nm) {

        elevator.setNeutralMode(nm);
        
    }

}

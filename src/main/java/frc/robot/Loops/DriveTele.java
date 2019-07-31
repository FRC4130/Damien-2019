/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Loops;

import com.ctre.phoenix.ILoopable;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Robot;
import frc.robot.Robots.RobotMap;
import frc.robot.Robots.Subsystems;
import frc.robot.Subsystems.DriveTrain;

public class DriveTele implements ILoopable{

    DriveTrain train;
    Joystick stick;
    DoubleSolenoid shifter;

    public DriveTele() {

        train = Subsystems.driveTrain;
        stick = RobotMap.DriverStick;
        shifter = RobotMap.shifter;
        
    }

    public void onStart() {

        train.setNuetralMode(NeutralMode.Brake);
        train.Shifter(train.high);
        
    }

    public void onLoop() {

        train.Movement(stick.getRawAxis(1)*-1, stick.getRawAxis(5)*-1);;

        if(stick.getRawButtonPressed(5)){

            train.Shifter(train.high);

        }

        else if(stick.getRawButtonPressed(6)) { 

            train.Shifter(train.low);
        }

    }

    public boolean isDone() {

        return false;
        
    }

    public void onStop() {

        train.Movement(0, 0);
        
    }

}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Loops;

import com.ctre.phoenix.ILoopable;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Robots.RobotMap;
import frc.robot.Robots.Subsystems;
import frc.robot.Subsystems.Elevator;

public class ElevatorTele implements ILoopable{

    Elevator elevator;
    Joystick opstick;

    public ElevatorTele() {

        elevator = Subsystems.elevator;
        opstick = RobotMap.OperatorStick;
        
    }

    public void onStart() {

        elevator.setNuetralMode(NeutralMode.Brake);
        
    }

    public void onLoop() {

        elevator.Elevate(opstick.getRawAxis(1));
        
    }

    
    public boolean isDone() {

        return false;
        
    }

    public void onStop() {

        elevator.Elevate(0);

    }


}

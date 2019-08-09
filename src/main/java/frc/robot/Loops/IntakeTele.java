/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Loops;

import com.ctre.phoenix.ILoopable;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Robots.RobotMap;
import frc.robot.Robots.Subsystems;
import frc.robot.Subsystems.Intake;


public class IntakeTele implements ILoopable{

    Intake takeIn;
    Joystick joy;
    DoubleSolenoid clap;

    public IntakeTele(){
        
        takeIn = Subsystems.intake;
        joy = RobotMap.OperatorStick;
        clap = RobotMap.clamp;

    }

    public void onStart(){

        takeIn.clamp(takeIn.closed);

    }

    public void onLoop(){

        updateClamp();
        takeIn.succ(joy.getRawAxis(5)*-.80);

    }

    public void updateClamp(){

        if(joy.getRawButton(5)){

            takeIn.clamp(takeIn.closed);

        }
        else{
            
            takeIn.clamp(takeIn.open);

        }

    }

    public boolean isDone(){

        return false;

    }

    public void onStop(){

    }

}

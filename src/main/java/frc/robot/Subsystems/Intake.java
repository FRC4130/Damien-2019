/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.Robots.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Intake {

    private DoubleSolenoid grabber;

    public final Value closed = Value.kForward;
    public final Value open = Value.kReverse;

    public final VictorSPX take;

    public Intake(){

        grabber = RobotMap.clamp;

        take = RobotMap.intake;

        grabber.set(closed);

    }

    public void clamp(Value vl) {

        grabber.set(vl);
            
        }

        public void succ(double succThrottle){

            take.set(ControlMode.PercentOutput, succThrottle);

        }

}

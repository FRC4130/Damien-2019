/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Robots;

import frc.robot.Subsystems.DriveTrain;
import frc.robot.Subsystems.Elevator;
import frc.robot.Subsystems.Intake;

public class Subsystems {

    public static DriveTrain driveTrain;
    public static  Elevator elevator;
    public static Intake intake;



    public static void Init() {

        driveTrain = new DriveTrain();
        elevator = new Elevator();
        intake = new Intake();
        
    }
        
    

}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Robots;

import com.ctre.phoenix.schedulers.ConcurrentScheduler;
import frc.robot.Loops.*;

public class Loops {

    public static void sTeleop(ConcurrentScheduler teleop) {

        teleop.add(new DriveTele());
        teleop.add(new ElevatorTele());
        teleop.add(new IntakeTele());

    }

}

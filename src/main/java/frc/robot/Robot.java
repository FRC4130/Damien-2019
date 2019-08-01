/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robots.Loops;
import frc.robot.Robots.RobotMap;
import frc.robot.Robots.Subsystems;
import com.ctre.phoenix.schedulers.ConcurrentScheduler;

public class Robot extends IterativeRobot {
  
  ConcurrentScheduler teleop;

  @Override
  public void robotInit() {

    RobotMap.Init();
    Subsystems.Init();

  }

  @Override
  public void robotPeriodic() {

    SmartDashboard.putNumber("Battery", RobotController.getBatteryVoltage());

  }

  @Override
  public void autonomousInit() {

    teleop = new ConcurrentScheduler();
    Loops.sTeleop(teleop);
    teleop.startAll();

  }

  @Override
  public void autonomousPeriodic() {

    teleop.process();

  }


  public void teleopInit() {
    
    teleop = new ConcurrentScheduler();
    Loops.sTeleop(teleop);
    teleop.startAll();

  }

  @Override
  public void teleopPeriodic() {

    teleop.process();

  }

}

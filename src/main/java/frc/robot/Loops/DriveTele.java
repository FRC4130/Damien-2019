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
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.Robot;
import frc.robot.Robots.RobotMap;
import frc.robot.Robots.Subsystems;
import frc.robot.Subsystems.DriveTrain;

public class DriveTele implements ILoopable{

    DriveTrain train;
    Joystick stick;
    DoubleSolenoid shifter;

    //NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    //NetworkTableEntry tv = table.getEntry("tv");
    //NetworkTableEntry ty = table.getEntry("tx");
    //NetworkTableEntry ta = table.getEntry("ta");

    //double m_LimelightDriveCommand = 0.0;
    //double m_LimelightSteerCommand = 0.0;
    //boolean m_LimelightHasValidTarget = false;

    public DriveTele() {

        System.out.println("[INFO] Teleop Drive Controls Starting");

        train = Subsystems.driveTrain;
        stick = RobotMap.DriverStick;
        shifter = RobotMap.shifter;

        //NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(0);
        //NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(1);
        //NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1);
        
    }

    public void onStart() {

        train.setNuetralMode(NeutralMode.Brake);
        train.Shifter(train.high);
        
    }

    public void onLoop() {

        train.Movement(stick.getRawAxis(1)*-1, stick.getRawAxis(5)*-1);

        if(stick.getRawButtonPressed(5)){

            train.Shifter(train.high);

        }

        if(stick.getRawButtonPressed(6)){

            train.Shifter(train.low);

        }
    }

        //Driver Control Input
        //Limelight - read variables tv, tx, ty, ta, ts, tl, tshort, tlong, thor, and tvert
        //NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
        //NetworkTableInstance.getDefault().getTable("limelight").getEntry("ts").getDouble(0);
        //NetworkTableInstance.getDefault().getTable("limelight").getEntry("tl").getDouble(0);
        //NetworkTableInstance.getDefault().getTable("limelight").getEntry("tshort").getDouble(0);
        //NetworkTableInstance.getDefault().getTable("limelight").getEntry("tlong").getDouble(0);
        //NetworkTableInstance.getDefault().getTable("limelight").getEntry("thor").getDouble(0);
        //NetworkTableInstance.getDefault().getTable("limelight").getEntry("tvert").getDouble(0);

        //Limelight - Limelight Autonomous Aim/Seek/Range w/ button
        //LimelightTracking();
        //double steer = -stick.getX(Hand.kRight);
        //double drive = -stick.getY(Hand.kLeft);
        //boolean auto = stick.getRawButton(2);

        //steer *= 1;
        //drive *= 1;
        //if (auto) {

        //    train.Shifter(train.high);

        //    NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(0); //0
        //    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(3); //3
        //    if (m_LimelightHasValidTarget) {
        //        train.arcadeDrive(m_LimelightDriveCommand, -m_LimelightSteerCommand);
        //    }
        //    else {
        //        NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(0); //0
        //        NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(3); //3
        //        train.arcadeDrive(drive,steer);
        //    }
        //}
        //else {

        //    train.Shifter(train.high);

        //    NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(0); //0
        //    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(3); //3

        //    if(stick.getRawButton(3)) {
        //        train.driveDirect(0, 0);
        //    }
            //else if (stick.getRawButton(6)) {
            //    train.driveDirect(stick.getRawAxis(1)*-.50, stick.getRawAxis(5)*-.50);
            //}
            //else if (stick.getRawButton(5)) {
            //    train.driveDirect(stick.getRawAxis(1)*-.20, stick.getRawAxis(5)*-.20);
            //}

        //    else { 
        //        train.driveDirect(stick.getRawAxis(1)*-1, stick.getRawAxis(5)*-1);
        //    }

        //}
    //}

    //public void LimelightTracking() {

        // These numbers must be tuned...
        //final double STEER_K = 0.04; // How hard to turn toward the target
        //final double DRIVE_K = 0.40; // How hard to drive fwd toward the target
        //final double DESIRED_TARGET_AREA = 2; // Area of the target when the robot reaches the wall at level 1
        //final double MAX_DRIVE = .70; // Speed limit so we don't drive too fast
        //double tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
        //double tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
        //double ta = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);

        // Function to determine autonomous drive and steering settings
        //if (tv < 0.5) {
        //    m_LimelightHasValidTarget = false;
        //    m_LimelightDriveCommand = 0.0;
        //    m_LimelightSteerCommand = 0.0;
        //    return;
        //}
        //m_LimelightHasValidTarget = true;
        // Start with proportional steering
        //double steer_cmd = tx * STEER_K;
        //m_LimelightSteerCommand = steer_cmd;
        // Try to drive forward until the target area reaches our desired area
        //double drive_cmd = (DESIRED_TARGET_AREA - ta) * DRIVE_K;
        // Don't let the robot drive too fast into the target
        //if (drive_cmd > MAX_DRIVE) {
         //   drive_cmd = MAX_DRIVE;
        //}
        //m_LimelightDriveCommand = drive_cmd;
    //}


    public boolean isDone() {

        return false;
        
    }

    public void onStop() {

        train.Movement(0, 0);
        train.Shifter(train.high);
        
    }

}

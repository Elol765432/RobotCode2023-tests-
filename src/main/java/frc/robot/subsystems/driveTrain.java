// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.driveForwardDT;
import frc.robot.commands.onMotors;
import frc.robot.commands.turnLeftDriveTrain;
import frc.robot.resources.TecbotSpeedController;

public class driveTrain extends SubsystemBase {
  /** Creates a new driveTrain2. */
  TecbotSpeedController m1;
  TecbotSpeedController m2;
  TecbotSpeedController m3;
  TecbotSpeedController m4; 
  Timer t1;

  public driveTrain() {
  m1 = new TecbotSpeedController(RobotMap.driveTrainPorts[0], RobotMap.chassisMotor[0]);
  m2 = new TecbotSpeedController(RobotMap.driveTrainPorts[1], RobotMap.chassisMotor[1]); 
  m3 = new TecbotSpeedController(RobotMap.driveTrainPorts[2], RobotMap.chassisMotor[1]);
  m4 = new TecbotSpeedController(RobotMap.driveTrainPorts[3], RobotMap.chassisMotor[1]);
  
  m1.getCANSparkMax().setIdleMode(IdleMode.kBrake);
  m2.getCANSparkMax().setIdleMode(IdleMode.kBrake);
  m3.getCANSparkMax().setIdleMode(IdleMode.kBrake);
  m4.getCANSparkMax().setIdleMode(IdleMode.kBrake);
  
  

  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void driveForward(){
  System.out.println("drive forward");
   m1.set(-RobotMap.chassisSpeedL);
   m2.set(-RobotMap.chassisSpeedL); 
   m3.set(RobotMap.chassisSpeedR);
   m4.set(RobotMap.chassisSpeedR); 
  }

  

  public void stop(){
    System.out.println("stop");
    m1.set(0);
    m2.set(0);
    m3.set(0);
    m4.set(0);
  }
  
 // public boolean hasElapsed (double sec) {
    //sec = 1.5;
//return t.get() >= sec;
 //}
  public void turnLeft(){
    System.out.println("turn");
    m1.set(RobotMap.chassisSpeedL);
    m2.set(RobotMap.chassisSpeedL);
    m3.set(RobotMap.chassisSpeedR);
    m4.set(RobotMap.chassisSpeedR);
  }

  public void turnRight(){
    m1.set(-RobotMap.chassisSpeedL);
    m2.set(-RobotMap.chassisSpeedL);
    m3.set(-RobotMap.chassisSpeedR);
    m4.set(-RobotMap.chassisSpeedR);
  }

  public void drive(double x, double y){
    Robot.getRobotContainer().getOI().getPilot().setOffset(RobotMap.OFFSET);
    double rightSpeed = (-x - y);
    double leftSpeed = (-x + y);
    m1.set(leftSpeed);
    m2.set(leftSpeed);
    m3.set(rightSpeed);
    m4.set(rightSpeed);
  }
}



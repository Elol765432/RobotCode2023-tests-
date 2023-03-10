// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.driveForwardDT;
import frc.robot.commands.onMotors;
import frc.robot.commands.turnLeftDriveTrain;
import frc.robot.resources.Navx;
import frc.robot.resources.RobotConfigurator;
import frc.robot.resources.TecbotConstants;
import frc.robot.resources.TecbotSpeedController;

public class driveTrain extends SubsystemBase {
  /** Creates a new driveTrain2. */
  TecbotSpeedController m1;
  TecbotSpeedController m2;
  TecbotSpeedController m3;
  TecbotSpeedController m4; 
  


  RelativeEncoder driveTrainEncoderL1, driveTrainEncoderL2, driveTrainEncoderR1, driveTrainEncoderR2;

  DoubleSolenoid transmition;

  private static final SPI.Port kGyroPort = SPI.Port.kOnboardCS0;

  private ADXRS450_Gyro gyro = new ADXRS450_Gyro(kGyroPort);
  
 
  public driveTrain() {
  m1 = new TecbotSpeedController(RobotMap.driveTrainPorts[3], RobotMap.chassisMotor[0]);
  m2 = new TecbotSpeedController(RobotMap.driveTrainPorts[1], RobotMap.chassisMotor[1]); 
  m3 = new TecbotSpeedController(RobotMap.driveTrainPorts[0], RobotMap.chassisMotor[1]);
  m4 = new TecbotSpeedController(RobotMap.driveTrainPorts[2], RobotMap.chassisMotor[1]);
  
  m1.getCANSparkMax().setIdleMode(IdleMode.kBrake);
  m2.getCANSparkMax().setIdleMode(IdleMode.kBrake);
  m3.getCANSparkMax().setIdleMode(IdleMode.kBrake);
  m4.getCANSparkMax().setIdleMode(IdleMode.kBrake);
  
  driveTrainEncoderL1 = m1.getCANSparkMax().getEncoder();
  driveTrainEncoderL2 = m2.getCANSparkMax().getEncoder();
  driveTrainEncoderR1 = m3.getCANSparkMax().getEncoder();
  driveTrainEncoderR2 = m4.getCANSparkMax().getEncoder();
  
  transmition = RobotConfigurator.buildDoubleSolenoid(RobotMap.SolenoidPortTransmition);
  
  
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  public void driveForwardWithEncoders(){
  double sensorPosition =  -1 * driveTrainEncoderL1.getPosition() * TecbotConstants.kDriveTick2Feet;

  double error = TecbotConstants.setpoint - sensorPosition;

  System.out.println("distance: " + TecbotConstants.setpoint);

  double outputSpeed = TecbotConstants.kP*error/TecbotConstants.setpoint;

  SmartDashboard.putNumber("Drivetrain distance: ", sensorPosition);
  SmartDashboard.putNumber("setpoint: ", TecbotConstants.setpoint);
  SmartDashboard.putNumber("error: ", error);
  SmartDashboard.putNumber("output speed: ", outputSpeed);
   
   m1.set(-outputSpeed);
   m2.set(-outputSpeed); 
   m3.set(outputSpeed);
   m4.set(outputSpeed); 
  }

  public void driveForwardWithEncodersShort(){
    double sensorPosition =  driveTrainEncoderL1.getPosition() * TecbotConstants.kDriveTick2Feet;
  
    double error = TecbotConstants.setpointShort - sensorPosition;
  
    System.out.println("distance: " + TecbotConstants.setpoint);
  
    double outputSpeed = TecbotConstants.kP*error/TecbotConstants.setpoint;
  
    SmartDashboard.putNumber("Drivetrain distance: ", sensorPosition);
    SmartDashboard.putNumber("setpoint: ", TecbotConstants.setpoint);
    SmartDashboard.putNumber("error: ", error);
    SmartDashboard.putNumber("output speed: ", outputSpeed);
     
     m1.set(-outputSpeed);
     m2.set(-outputSpeed); 
     m3.set(outputSpeed);
     m4.set(outputSpeed); 
    }

  public void resetEncoderDt(){
    driveTrainEncoderL1.setPosition(0);
    driveTrainEncoderL2.setPosition(0);
    driveTrainEncoderR1.setPosition(0);
    driveTrainEncoderR2.setPosition(0);
  }  

  public double getDriveTrainFeet(){
   return -1 * driveTrainEncoderL1.getPosition() * TecbotConstants.kDriveTick2Feet;
  }
  
  public double getDriveTrainFeetR(){
    return driveTrainEncoderR1.getPosition();
  }

  public void driveForward(){
   m1.set(-RobotMap.chassisSpeedL);
   m2.set(-RobotMap.chassisSpeedL); 
   m3.set(RobotMap.chassisSpeedR);
   m4.set(RobotMap.chassisSpeedR); 
  }

  public void driveBackwards(){
    double sensorPositionBackWards = driveTrainEncoderL1.getPosition() * TecbotConstants.kDriveTick2Feet;

    double error = TecbotConstants.setpointBakcwards - sensorPositionBackWards;

    double outputSpeedBackwards = TecbotConstants.kP*error/TecbotConstants.setpointBakcwards;

     m1.set(outputSpeedBackwards);
     m2.set(outputSpeedBackwards); 
     m3.set(-outputSpeedBackwards);
     m4.set(-outputSpeedBackwards); 
    }
  
  

  public void stop(){
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
    double sensorPostionTurn = driveTrainEncoderL1.getPosition()*TecbotConstants.kDriveTick2Feet;

    double errorTurn = TecbotConstants.setpointTurn - sensorPostionTurn;

    double outputSpeedTurn = TecbotConstants.kP*errorTurn/TecbotConstants.setpointTurn;

    SmartDashboard.putNumber("Encoder Position: ", sensorPostionTurn);
    SmartDashboard.putNumber("setpoint: ", TecbotConstants.setpointTurn);
    SmartDashboard.putNumber("error: ", errorTurn);
    SmartDashboard.putNumber("output speed: ", outputSpeedTurn);

    System.out.println("Encoder Position: " + sensorPostionTurn);
    System.out.println("setpoint: " + TecbotConstants.setpointTurn);
    System.out.println("error: " + errorTurn);
    System.out.println("output speed: " + outputSpeedTurn);
    

    //m1.set(outputSpeedTurn);
    //m2.set(outputSpeedTurn); 
    //m3.set(outputSpeedTurn);
    //m4.set(outputSpeedTurn); 
  }

  public void turnRight(){
    double sensorPostionTurn = -1*driveTrainEncoderR1.getPosition();

    double errorTurn = TecbotConstants.setpointTurnR - sensorPostionTurn;

    double outputSpeedTurn = TecbotConstants.kP*errorTurn/TecbotConstants.setpointTurn;

    SmartDashboard.putNumber("Encoder Position: ", sensorPostionTurn);
    SmartDashboard.putNumber("setpoint: ", TecbotConstants.setpointTurn);
    SmartDashboard.putNumber("error: ", errorTurn);
    SmartDashboard.putNumber("output speed: ", outputSpeedTurn);
    
    m1.set(-outputSpeedTurn);
    m2.set(-outputSpeedTurn); 
    m3.set(-outputSpeedTurn);
    m4.set(-outputSpeedTurn);
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

  public void changeToSpeed(){
    transmition.set(Value.kForward);
    m1.getCANSparkMax().setIdleMode(IdleMode.kBrake);
    m2.getCANSparkMax().setIdleMode(IdleMode.kBrake);
    m3.getCANSparkMax().setIdleMode(IdleMode.kBrake);
    m4.getCANSparkMax().setIdleMode(IdleMode.kBrake);
  }

  public void changeToTorque(){
    transmition.set(Value.kReverse);
    m1.getCANSparkMax().setIdleMode(IdleMode.kCoast);
    m2.getCANSparkMax().setIdleMode(IdleMode.kCoast);
    m3.getCANSparkMax().setIdleMode(IdleMode.kCoast);
    m4.getCANSparkMax().setIdleMode(IdleMode.kCoast);
  }

  public void getAngle(){
  System.out.println(gyro.getAngle());
  SmartDashboard.putNumber("Angle: ", gyro.getAngle());
  }

  public void driveBackwardsTime(){
m1.set(RobotMap.chassisSpeedL);
m2.set(RobotMap.chassisSpeedL);
m3.set(-RobotMap.chassisSpeedR);
m4.set(-RobotMap.chassisSpeedR); 
  }
}



// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.RobotMap;
import frc.robot.resources.TecbotSpeedController;
import com.revrobotics.CANSparkMax.IdleMode;

public class Arm extends SubsystemBase {
  /** Creates a new Arm. */
  TecbotSpeedController m5;
  TecbotSpeedController m6;
  public Arm() {
    m5 = new TecbotSpeedController(RobotMap.driveTrainPorts[6], RobotMap.chassisMotor[0]);
    m6 = new TecbotSpeedController(RobotMap.driveTrainPorts[7], RobotMap.chassisMotor[0]);

    m5.getCANSparkMax().setIdleMode(IdleMode.kBrake);
    m6.getCANSparkMax().setIdleMode(IdleMode.kBrake);
  } 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void onArmB(){
    m5.set(RobotMap.armSpeedB);
    m6.set(-RobotMap.armSpeedB);
  }

  public void onArmF(){
    m5.set(-RobotMap.armspeedF);
    m6.set(RobotMap.armspeedF);
  }

  public void stopArm(){
    m5.set(0);
    m6.set(0);
  }

  public void onArmController(double RT, double LT){
    m5.set((RT-LT)*RobotMap.teleop_armspeed);
    m6.set((RT-LT)*-RobotMap.teleop_armspeed);
  }


public void keepArm(int side){
  int[] sideArray = {1, -1};
  m5.set(-0.07*sideArray[side]);
  m6.set(0.07*sideArray[side]);
}

}


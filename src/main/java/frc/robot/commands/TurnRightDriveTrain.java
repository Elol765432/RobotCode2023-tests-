// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.resources.TecbotConstants;

public class TurnRightDriveTrain extends CommandBase {
  /** Creates a new TurnRight. */
  boolean finished = false;
  public TurnRightDriveTrain() {
    addRequirements(Robot.getRobotContainer().getDriveTrain());
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.getRobotContainer().getDriveTrain().turnRight();
    
    double distance = TecbotConstants.setpointTurnR - Robot.getRobotContainer().getDriveTrain().getDriveTrainFeet();
    
    if(distance*TecbotConstants.kP <= 0.03){
      finished = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}

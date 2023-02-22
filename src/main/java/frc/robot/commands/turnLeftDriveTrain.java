// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class turnLeftDriveTrain extends CommandBase {
  /** Creates a new trunLeft. */
  Timer t2;
  boolean finished = false;
  public turnLeftDriveTrain() {
    // Use addRequirements() here to declare subsystem dependencies.
    t2 = new Timer();
    addRequirements(Robot.getRobotContainer().getDriveTrain());
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    t2.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() { 
    Robot.getRobotContainer().getDriveTrain().turnLeft();
    
    if(t2.get()>=0.32){
      Robot.getRobotContainer().getDriveTrain().stop();
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

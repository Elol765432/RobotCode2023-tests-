// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutonomousRoute extends SequentialCommandGroup {
  /** Creates a new AutonomousRoute. */
  public AutonomousRoute() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new OnArm(), new WaitCommand(0.32), new OffArm(), new WaitCommand(1),new IntakeOff(),new WaitCommand(1),new OnArmF(), new WaitCommand(.3), new OffArm(),new WaitCommand(1),new onMotors(), new WaitCommand(.95), new OffMotors(),new WaitCommand(1), new ReturnRobot(), new WaitCommand(0.75), new IntakeOn(), new WaitCommand(0.5), new DriveRobotBackwards(), new WaitCommand(.65), new OffMotors(), new WaitCommand(0.5), new ReturnRobot());
  }
}

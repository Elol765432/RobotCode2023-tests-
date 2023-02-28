// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class GoUpChargedStation extends SequentialCommandGroup {
  /** Creates a new GoUpChargedStation. */
  public GoUpChargedStation() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new OnArm(), new WaitCommand(1.2), new OffArm(), new WaitCommand(1),new IntakeOn(),new OnArmF(), new WaitCommand(.7), new OffArm(),new WaitCommand(1),new onMotors(), new WaitCommand(.99), new OffMotors(),new WaitCommand(0.5),new IntakeOff(),new WaitCommand(0.5), new turnLeftDriveTrain(),new WaitCommand(0.5),new onMotors(), new WaitCommand(.65), new OffMotors(), new WaitCommand(0.5), new TurnRightDriveTrain(), new WaitCommand(0.75), new DriveRobotBackwards(), new WaitCommand(.9), new OffMotors());
  }
}

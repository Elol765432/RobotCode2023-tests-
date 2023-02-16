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
public class AutomousGoAndReturn extends SequentialCommandGroup {
  /** Creates a new AutomousGoAndReturn. */
  public AutomousGoAndReturn() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new onMotors(), new WaitCommand(1.25),new OffMotors(),new WaitCommand(0.5),new turnLeftDriveTrain(), new WaitCommand(1), new onMotors(), new WaitCommand(1), new OffMotors(),new WaitCommand(1), new TurnRightDriveTrain(),new WaitCommand(1),new onMotors(), new WaitCommand(0.9), new OffMotors(), new WaitCommand(1.5), new turnLeftDriveTrain(),new turnLeftDriveTrain(),new WaitCommand(1),new onMotors(), new WaitCommand(.75), new OffMotors(), new WaitCommand(1), new turnLeftDriveTrain(), new WaitCommand(1),new onMotors(), new WaitCommand(.8), new OffMotors(), new WaitCommand(1), new TurnRightDriveTrain(), new WaitCommand(1), new onMotors(), new WaitCommand(1), new OffMotors(), new WaitCommand(1), new turnLeftDriveTrain(), new turnLeftDriveTrain());
  }
}

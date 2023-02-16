// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.autonomusCommandGroup;
import frc.robot.commands.onMotors;
import frc.robot.commands.turnLeftDriveTrain;
import frc.robot.commands.driveForwardDT;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.driveTrain;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private driveTrain drivetrain;
  private OI oi;
  private Intake intake;
  public Arm arm;

  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
     drivetrain = new driveTrain();
     oi = new OI();
     intake = new Intake();
     arm = new Arm();
     //configureButtonBindings();
  }

  public driveTrain getDriveTrain() {

    return drivetrain;

  }

  public OI getOI(){
    return oi;
  }

  public Intake getIntake(){
    return intake;
  }

  public Arm getArm(){
    return arm;
  }
  

  private void configureButtonBindings() {
    oi.configureButtonBindings();
  }


  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }



  

}

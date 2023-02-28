// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ArmEncoder;
import frc.robot.commands.AutomousGoAndReturn;
import frc.robot.commands.AutonomousRoute;
import frc.robot.commands.AutonomousSequence1;
import frc.robot.commands.EncoderArmBackwards;
import frc.robot.commands.GetArmAngleL;
import frc.robot.commands.GoUpChargedStation;
import frc.robot.commands.IntakeOff;
import frc.robot.commands.IntakeOn;
import frc.robot.commands.MoveArm;
import frc.robot.commands.OnArm;
import frc.robot.commands.OpenAndCloseClaw;
import frc.robot.commands.ResetEncoder;
import frc.robot.commands.ResetEncoderDt;
import frc.robot.commands.ReturnRobot;
import frc.robot.commands.TurnLeftDTE;
import frc.robot.commands.autonomusCommandGroup;
import frc.robot.commands.driveForwardDT;
import frc.robot.commands.driveRobot;
import frc.robot.commands.onMotors;
import frc.robot.commands.turnLeftDriveTrain;
import frc.robot.resources.Navx;
import frc.robot.subsystems.driveTrain;
import frc.robot.RobotContainer;
/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static RobotContainer robotcontainer;
  private Command m_autonomousCommand;


  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    robotcontainer = new RobotContainer();
    robotcontainer.configureButtonBindings();
   
  }
  public static RobotContainer getRobotContainer() {

    return robotcontainer;
  }
  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
    SmartDashboard.putNumber("angle", Navx.getGyro());
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = robotcontainer.getAutonomousCommand();
    //m_robotContainer.getDriveTrain().setDefaultCommand(new turnLeftDriveTrain());  
    // schedule the autonomous command (example)
    
    autonomusCommandGroup a = new autonomusCommandGroup();
    AutomousGoAndReturn a1 = new AutomousGoAndReturn();
    OnArm a2 = new OnArm();
    GoUpChargedStation a3 = new GoUpChargedStation();
    IntakeOn a4 = new IntakeOn();
    IntakeOff a5 = new IntakeOff();
    OpenAndCloseClaw a6 = new OpenAndCloseClaw();
    AutonomousRoute a7 = new AutonomousRoute();
    ReturnRobot a8 = new ReturnRobot();
    turnLeftDriveTrain a9 = new turnLeftDriveTrain();
    OnArm a10 = new OnArm();
    ArmEncoder a11 = new ArmEncoder();
    EncoderArmBackwards a12 = new EncoderArmBackwards();
    onMotors xd = new onMotors();
    ResetEncoderDt a13 = new ResetEncoderDt();
    TurnLeftDTE a14 = new TurnLeftDTE();
    AutonomousSequence1 a15 = new AutonomousSequence1();
    
    Robot.getRobotContainer().getDriveTrain().resetEncoderDt();
   
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }

  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    Robot.getRobotContainer().getDriveTrain().turnLeft();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    MoveArm t1 = new MoveArm();
    driveRobot t2 = new driveRobot();
    
    t1.schedule();
    t2.schedule();
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {


  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}

 
}

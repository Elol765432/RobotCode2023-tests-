// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import frc.robot.resources.TecbotConstants;
import frc.robot.resources.TecbotController;
import frc.robot.resources.TecbotController.ButtonType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.IntakeOff;
import frc.robot.commands.IntakeOn;
import frc.robot.commands.OffArm;
import frc.robot.commands.OffArmT;
import frc.robot.commands.OnArm;
import frc.robot.commands.OnArmT;

/** Add your docs here. */
public class OI {
   public static OI instance;
 private TecbotController pilot;
 

    public OI(){
      pilot = new TecbotController(RobotMap.pilotPort, TecbotConstants.CONTROLLER_TYPE_PILOT);
   }

   public void configureButtonBindings(){
      
      

      pilot.whenPressed(TecbotController.ButtonType.A, new IntakeOn());
      pilot.whenPressed(TecbotController.ButtonType.B, new IntakeOff());
      pilot.whenPressed(TecbotController.ButtonType.POV_DOWN, new OffArm());
      pilot.whenPressed(TecbotController.ButtonType.POV_LEFT, new OnArmT());
      pilot.whenPressed(TecbotController.ButtonType.POV_RIGHT, new OffArmT());
   }

   public static OI getInstance() {
      if (instance == null)
          instance = new OI();

      return instance;
  }

   public TecbotController getPilot(){
      return pilot;
   }

     
 



}

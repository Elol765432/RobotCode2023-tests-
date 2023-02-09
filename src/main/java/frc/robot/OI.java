// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import frc.robot.resources.TecbotConstants;
import frc.robot.resources.TecbotController;
import frc.robot.resources.TecbotController.ButtonType;
import frc.robot.RobotMap;
import frc.robot.commands.OffArm;
import frc.robot.commands.OnArm;

/** Add your docs here. */
public class OI {
 private TecbotController pilot;

    private OI(){
   }

   public void configureButtonBindings(){
      pilot = new TecbotController(RobotMap.pilotPort, TecbotConstants.CONTROLLER_TYPE_PILOT);

      pilot.whenPressed(ButtonType.A, new OnArm());
      pilot.whenPressed(ButtonType.B, new OffArm());
   }

   public TecbotController getPilot(){
      return pilot;
     }
     
 



}

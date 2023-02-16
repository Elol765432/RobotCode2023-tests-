// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import frc.robot.resources.TecbotConstants;
import frc.robot.resources.TecbotController;
import frc.robot.resources.TecbotController.ButtonType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.OffArm;
import frc.robot.commands.OnArm;

/** Add your docs here. */
public class OI {
 private TecbotController pilot;

    public OI(){
      pilot = new TecbotController(RobotMap.pilotPort, TecbotConstants.CONTROLLER_TYPE_PILOT);
   }

   public void configureButtonBindings(){
      
      

      pilot.whenPressed(TecbotController.ButtonType.A, new OnArm());
      pilot.whenPressed(TecbotController.ButtonType.B, new OffArm());
   }

   public TecbotController getPilot(){
      return pilot;
   }

     
 



}

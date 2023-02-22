// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.resources.TecbotSpeedController.TypeOfMotor;

/** Add your docs here. */
public class RobotMap {

public static final double OFFSET = 0.05;

public static final int driveTrainPorts[] = {10, 11, 12, 13,40, 41, 45 ,50};

public static final TypeOfMotor chassisMotor[] = {TypeOfMotor.CAN_SPARK_BRUSHLESS, TypeOfMotor.CAN_SPARK_BRUSHLESS};

public static final int pilotPort = 0;

public static final double chassisSpeedL = 0.6;

public static final double chassisSpeedR = 0.62;

public static final double armSpeedB = 0.20;

public static final double armspeedF = 0.20;

public static final double teleop_armspeed = 0.3;

public static final int PCM_1_PORT = 7;

public static final int SolenoidPort[] = {PCM_1_PORT, 5, 10};

 
}


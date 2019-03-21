/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

   // PWM Ports
   /* Drive Motor PWM IDs - Not required because we switched to Spark Max (CAN based) controlers
   public static int motorPortFrontLeft = 0;
   public static int motorPortFrontRight = 3;
   public static int motorPortRearLeft = 1;
   public static int motorPortRearRight = 2;
   */

   //Elevator Motor PWM ID - Not required because we switched to Talon SRX
   //public static int motorPortElevator = 4;
   
   public static int motorPortCargo = 2;

  

   // PID
 
   // CAN
   // Drive Motor CAN IDs
   public static int drivemotorFrontLeftCANID = 10;
   public static int drivemotorRearLeftCANID = 11;
   public static int drivemotorRearRightCANID = 12;
   public static int drivemotorFrontRightCANID = 13;

  // Elevator Motor CAN ID
   public static int elevmotorCANID = 4;
  
  // Pneumatic Control Module CAN IDs
   public static int pcmACANID = 0;
   public static int pcmBCANID = 1;
 
   // USB
     // Joystics and Controllers
     public static int leftcontrollerPort = 0;
     public static int rightcontrollerPort = 1;
     public static int bBBluePort = 2;
     public static int bBRedPort = 3;
     //public static int xboxControllerPort = 3;

     // Cameras
     public static int camera1Port = 0;
     public static int camera2Port = 0;

  // Analog Ports
  public static int gyroPort = 0;

}
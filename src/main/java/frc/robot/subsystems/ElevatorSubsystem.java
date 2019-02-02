/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;



/**
 * Add your docs here.
 */
public class ElevatorSubsystem extends PIDSubsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    // instantiate new motor controller objects

    public Spark elevatorEncoderMotor = new Spark(RobotMap.motorPortEncoder);
    Encoder elevEnc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);

    public double elevTarget = 0.0;
    public static final double firstLevel = 0.0;
    public static final double secondLevel = 5000;
    public static final double thirdLevel = 6000;
    public static final double fourthLevel = 300;
    public static final double fithLevel = 400;
    public static final double sixthLevel = 500;
    public static final double elevP = 2.0;
    public static final double elevI = 0.0;
    public static final double elevD = 0.0;

      public ElevatorSubsystem() {

       
     // The constructor passes a name for the subsystem and the P, I and D constants that are used when computing the motor output 
      super("ElevatorSubsystem", 2.0, 0.0, 0.0);
      setAbsoluteTolerance(0.05);
      getPIDController().setContinuous(false);
      setSetpoint(elevTarget);    
    }
    
      public void initDefaultCommand() {
      }
  
      protected double returnPIDInput() {
        // returns the encoder count
        return elevEnc.get();
      } 
  
      protected void usePIDOutput(double elevMotorTargetSpeed) {
      // this is where the computed output value fromthe PIDController is applied to the motor
        elevatorEncoderMotor.pidWrite(elevMotorTargetSpeed); 
      }
  }

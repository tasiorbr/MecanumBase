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


    public ElevatorSubsystem() {

       
     // The constructor passes a name for the subsystem and 
     // the P, I and D constants that are used when computing the motor output 
      super("ElevatorSubsystem", 2.0, 0.0, 0.0);
      setAbsoluteTolerance(0.05);
      getPIDController().setContinuous(false);
      // No longer needed because setSetpoint is called in the command
      //  setSetpoint(elevTarget);    
    }

      protected double returnPIDInput() {
        // returns the encoder count
        return elevEnc.get();
      } 
  
      protected void usePIDOutput(double elevMotorTargetSpeed) {
      // this is where the computed output value fromthe PIDController is applied to the motor
        elevatorEncoderMotor.pidWrite(elevMotorTargetSpeed); 
      }

      public void initDefaultCommand() {
      }
  
}

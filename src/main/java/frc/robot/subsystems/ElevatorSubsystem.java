/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 * 
 */
public class ElevatorSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public TalonSRX elevatorMotor = new TalonSRX(RobotMap.elevmotorCANID);
 
  public ElevatorSubsystem () {
  // Joel's comment:  Adding this section is what allows us to call the PneumaticSubsystem from other parts of the code


  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    
    //Set the feedback device that is hooked up to the talon
    elevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    
    elevatorMotor.setInverted(true);
    elevatorMotor.setSensorPhase(false);
    elevatorMotor.configFactoryDefault();
    elevatorMotor.setNeutralMode(NeutralMode.Brake);
    
    // Config Position Closed Loop gains in slot0
    elevatorMotor.config_kP(0, 0.15, 0);
	  elevatorMotor.config_kI(0, 0.0, 0);
	  elevatorMotor.config_kD(0, 1.0, 0);
    elevatorMotor.config_kF(0, 0.0, 0); 
  }

}

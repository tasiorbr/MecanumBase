/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ElevatorManualMove;

/**
 * Add your docs here.
 * 
 */



public class ElevatorSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public TalonSRX elevatorMotor = new TalonSRX(RobotMap.elevmotorCANID);
 
  
  // Joel's comment:  Adding this section is what allows us to call the Subsystem from other parts of the code

  public void elevSetToPosition(double setElevLevelCommandSetpoint) {
      elevatorMotor.set(ControlMode.Position, setElevLevelCommandSetpoint);
  };

  public void elevManualPosition(double manualMove) {
      elevatorMotor.set(ControlMode.PercentOutput, manualMove);
  };

  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    
    setDefaultCommand(new ElevatorManualMove());
    

  }

}

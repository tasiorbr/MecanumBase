/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class SetElevatorLevel extends Command {
        
    private int setElevLevelCommandSetpoint;

    public SetElevatorLevel(int setElevLevelSetpoint) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.elevatorSubsystem);
    
    setElevLevelCommandSetpoint = setElevLevelSetpoint;
    
    
    }
  
    // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    

    
    //Set the motor control mode and target value (for position target is in encloder 'ticks')
    //Robot.elevatorSubsystem.elevatorMotor.set(ControlMode.Position, setElevLevelCommandSetpoint);
    
    
    

 
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() { 
    System.out.println(setElevLevelCommandSetpoint);
    Robot.elevatorSubsystem.elevatorMotor.set(ControlMode.Position, setElevLevelCommandSetpoint);
    

    


       
  } 

// Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
    // This exits the command when the elvevator gets to the target value
        return false;
    }

// Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.elevatorSubsystem.elevatorMotor.set(ControlMode.PercentOutput, 0);
   
        
    }

// Called when another command which requires one or more of the same
// subsystems is scheduled to run
    @Override
    protected void interrupted() { 
        Robot.elevatorSubsystem.elevatorMotor.set(ControlMode.PercentOutput, 0);
    //    Robot.elevatorSubsystem.disable();
    }

}
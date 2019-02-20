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

    StringBuilder sb = new StringBuilder();
	int loops = 0;

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
    
    Robot.elevatorSubsystem.elevatorMotor.set(ControlMode.Position, setElevLevelCommandSetpoint);
    
    double motorOutput = Robot.elevatorSubsystem.elevatorMotor.getMotorOutputPercent();
    /* Prepare line to print */
		sb.append("\tout:");
		/* Cast to int to remove decimal places */
		sb.append((int) (motorOutput * 100));
		sb.append("%");	// Percent

		sb.append("\tpos:");
		sb.append(Robot.elevatorSubsystem.elevatorMotor.getSelectedSensorPosition(0));
		sb.append("u"); 	// Native units

    		/* If Talon is in position closed-loop, print some more info */
		if (Robot.elevatorSubsystem.elevatorMotor.getControlMode() == ControlMode.Position) {
			sb.append("\terr:");
			sb.append(Robot.elevatorSubsystem.elevatorMotor.getClosedLoopError(0));
			sb.append("u");	// Native Units

			sb.append("\ttrg:");
			sb.append(setElevLevelCommandSetpoint);
			sb.append("u");	/// Native Units
		}

		/**
		 * Print every ten loops, printing too much too fast is generally bad
		 * for performance.
		 */
		if (++loops >= 10) {
			loops = 0;
			System.out.println(sb.toString());
		}

		/* Reset built string for next loop */
		sb.setLength(0);
		

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
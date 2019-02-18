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
    /**
	 * Which PID slot to pull gains from. Starting 2018, you can choose from
	 * 0,1,2 or 3. Only the first two (0,1) are visible in web-based
	 * configuration.
	 */
	public static final int slotIdx = 0;

	/**
	 * Talon SRX/ Victor SPX will supported multiple (cascaded) PID loops. For
	 * now we just want the primary one.
	 */
	public static final int pIDLoopIdx = 0;

	/**
	 * Set to zero to skip waiting for confirmation, set to nonzero to wait and
	 * report to DS if action fails.
	 */
	public static final int timeoutMs = 0;
	
	/* Choose so that Talon does not report sensor out of phase */
	public static boolean sensorPhase = true;

	/**
	 * Choose based on what direction you want to be positive,
	 * this does not affect motor invert. 
	 */
	public static boolean kMotorInvert = false;
    
    //Proportional Gain
    public final double p = 0.15;
    
    //Integral Gain
    public final double i = 0.0;
    
    //Derivative Gain
    public final double d = 1.0;
    
    //Feed-Forward Gain (an open loop offset added to the closed loop control)
    public final double f = 0.0;
    
    public final int izone = 0;
    
    //Maximum allowable output for the control loop, 1 = 100%
    public final double peakOudtput = 1;
    
    
        
    private int setElevLevelCommandSetpoint;

    public SetElevatorLevel(int setElevLevelSetpoint) {
    // Use requires() here to declare subsystem dependencies
    setElevLevelCommandSetpoint = setElevLevelSetpoint;
    
    requires(Robot.elevatorSubsystem);
    }
  
    // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    

    
    //Set the motor control mode and target value (for position target is in encloder 'ticks')
    Robot.elevatorSubsystem.elevatorMotor.set(ControlMode.Position, setElevLevelCommandSetpoint);
    
    
    

 
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() { 
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
   //     Robot.elevatorSubsystem.elevatorMotor.disable();
    }

// Called when another command which requires one or more of the same
// subsystems is scheduled to run
    @Override
    protected void interrupted() {
    //    Robot.elevatorSubsystem.disable();
    }

}
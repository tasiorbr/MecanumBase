/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SetElevatorLevel extends Command {
        
    private int setElevLevelCommandSetpoint;

    //Set the PID Loop allowable error
    public int allowableError = 2000;

    

    public SetElevatorLevel(int setElevLevelSetpoint) {
    
    
    // Use requires() here to declare subsystem dependencies
    requires(Robot.elevatorSubsystem);
    
    setElevLevelCommandSetpoint = setElevLevelSetpoint;
    
    
    }
  
    // Called just before this Command runs the first time
  @Override
  protected void initialize() {

            //Basline Startup initialization (inverted, sensor config, etc.) is in Robot.java

            
            //Set Limites for Motor
                // These two don't seem to be needed
                //Robot.elevatorSubsystem.elevatorMotor.configNominalOutputForward(0, 0);
                //Robot.elevatorSubsystem.elevatorMotor.configNominalOutputReverse(0, 0);
            // peak output forward reduced for testing without the lift
            Robot.elevatorSubsystem.elevatorMotor.configPeakOutputForward(1.0, 0);
            Robot.elevatorSubsystem.elevatorMotor.configPeakOutputReverse(-.5,0);
            
            //Set the PID Loop allowable error
            //Allowable error in "Native Units" (i.e. encoder 'ticks') for loop to be considered "On Target" 
            Robot.elevatorSubsystem.elevatorMotor.configAllowableClosedloopError(0, allowableError, 0);
        
        
            // Config Position Closed Loop gains in slot0
            Robot.elevatorSubsystem.elevatorMotor.config_kP(0, 0.5, 0);
            Robot.elevatorSubsystem.elevatorMotor.config_kI(0, 0.0, 0);
            Robot.elevatorSubsystem.elevatorMotor.config_kD(0, 1.0, 0);
            Robot.elevatorSubsystem.elevatorMotor.config_kF(0, 0.0, 0);
    
         
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() { 
    
    Robot.elevatorSubsystem.elevSetToPosition(setElevLevelCommandSetpoint);

    if (setElevLevelCommandSetpoint == 0 &  Robot.elevatorSubsystem.elevatorMotor.getClosedLoopError() < allowableError) {
     setTimeout(3);   
    }
    
    }


       
   

// Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

// Called once after isFinished returns true
    @Override
    protected void end() {
            
    }

// Called when another command which requires one or more of the same
// subsystems is scheduled to run
    @Override
    protected void interrupted() { 
    
     end();
    }

}
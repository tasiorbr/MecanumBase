/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.ElevatorSubsystem;

public class SetElevatorLevel extends Command {
  public void ElevatorSubsystem() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.elevatorSubsystem);
    }
  
    // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
     /* Defining what the buttons do for rotating motor
     boolean isClockwisePressed = Robot.oi.rightstick.getRawButtonPressed(1);
     boolean isCounterClockwisePressed = Robot.oi.rightstick.getRawButtonPressed(2);
    */

     // Defining what the buttons do for moving the elevator
     boolean isFirstLevelPressed = Robot.oi.rightstick.getRawButtonPressed(5);
     boolean isSecondLevelPressed = Robot.oi.rightstick.getRawButtonPressed(6);
     boolean isThirdLevelPressed = Robot.oi.rightstick.getRawButtonPressed(7);


/*   if(isClockwisePressed) {
         boolean rotateClockwise = Robot.oi.rightstick.getRawButton(1);
         Robot.elevatorEncoderMotor.set(0.1);
     }
 
     if(isCounterClockwisePressed) {
         boolean rotateCounterClockwise = Robot.oi.rightstick.getRawButton(2);
         elevatorEncoderMotor.set(-0.1); 
     }
*/ 
     if(isFirstLevelPressed) {
        Robot.elevatorSubsystem.setSetpoint(Robot.elevatorSubsystem.firstLevel);
        
         
     }
 
     if(isSecondLevelPressed) {
        Robot.elevatorSubsystem.setSetpoint(Robot.elevatorSubsystem.secondLevel);     
        
     }
 
     if(isThirdLevelPressed) {
        Robot.elevatorSubsystem.setSetpoint(Robot.elevatorSubsystem.thirdLevel);       
        
     }
 
     

  }

 
// Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
    return false;
    }

// Called once after isFinished returns true
    @Override
    protected void end() {
    }

// Called when another command which requires one or more of the same
// subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }

}
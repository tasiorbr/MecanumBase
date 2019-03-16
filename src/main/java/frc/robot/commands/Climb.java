/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;



public class Climb extends Command {

  private boolean allDone = false;

  public Climb() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.pneumaticSubsystem);
    requires(Robot.elevatorSubsystem);    
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.elevatorSubsystem.elevSetToPosition(0);
    Robot.pneumaticSubsystem.mainPlateDouble.set(Value.kOff);
    Robot.pneumaticSubsystem.mainPlateDouble.set(Value.kForward); 
    Robot.pneumaticSubsystem.secondaryPlateDouble.set(Value.kOff);
    Robot.pneumaticSubsystem.secondaryPlateDouble.set(Value.kForward);

    
 

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() { 
    
    

    if(Robot.pneumaticSubsystem.mainPlateDownLimitSwitch.get() && Robot.pneumaticSubsystem.backPlateDownLimitSwitch.get()) {
      Robot.pneumaticSubsystem.forwardBackwardDouble.set(Value.kOff);
      Robot.pneumaticSubsystem.forwardBackwardDouble.set(Value.kForward);
     
      if(Robot.pneumaticSubsystem.elevForwardLimitSwitch.get()){
        Robot.pneumaticSubsystem.mainPlateDouble.set(Value.kOff);
        Robot.pneumaticSubsystem.mainPlateDouble.set(Value.kReverse);
        allDone = true;
          
               
      }
    }


  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (allDone) {
      return true;
    }
        
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

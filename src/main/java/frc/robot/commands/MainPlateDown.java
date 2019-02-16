/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
/*
We need to make it so that both the plates drop down, we move forward,
the center one moves back up, we move forward again, drop down the center
one again, move forward again, pick up the center one, move forward, pick
up the back one, and then move forward again to get the rest of the way 
on the plateform. 
*/
package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class MainPlateDown extends Command {
  public MainPlateDown() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.pneumaticSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.pneumaticSubsystem.mainPlateDouble.set(Value.kOff);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.pneumaticSubsystem.mainPlateDouble.set(Value.kForward);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.pneumaticSubsystem.mainPlateDouble.set(Value.kOff);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.pneumaticSubsystem.mainPlateDouble.set(Value.kOff);
  }
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Pneumatics extends Command {
  public Pneumatics() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    //Shaddai added
    requires(Robot.pneumaticSubsystem); 
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //Shaddai added
   /* Robot.pneumaticSubsystem.mainPlateDouble.set(kOff);
    Robot.pneumaticSubsystem.mainPlateDouble.set(kForward);

    Robot.pneumaticSubsystem.secondaryPlate.set(kOff);
    Robot.pneumaticSubsystem.secondaryPlate.set(kForward);*/
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    //Shaddai added
    /*Robot.pneumaticSubsystem.mainPlateDouble.set(kOff);

    Robot.pneumaticSubsystem.secondaryPlate.set(kOff);*/
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    //Shaddai added
    /*Robot.pneumaticSubsystem.mainPlateDouble.set(kOff);

    Robot.pneumaticSubsystem.secondaryPlate.set(kOff);*/
  }
}

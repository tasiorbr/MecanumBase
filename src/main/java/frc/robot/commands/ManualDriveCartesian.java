/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ManualDriveCartesian extends Command {
  public ManualDriveCartesian() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.mecDriveSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //  Use this section to drive with xbox controller
    double moveX = -0.7 * Robot.oi.xboxController.getRawAxis(1);
    double moveY =  Robot.oi.xboxController.getRawAxis(4);
    double rotateZ = 0.5 * (-Robot.oi.xboxController.getRawAxis(2) + Robot.oi.xboxController.getRawAxis(3));
   
    /*  Use this section to drive with joysticks
    double moveX = -0.7 * Robot.oi.leftstick.getRawAxis(1);
    double moveY =  Robot.oi.rightstick.getRawAxis(0);
    double rotateZ = 0.5 * Robot.oi.rightstick.getRawAxis(2);
    */
    int loops = 0;
    double currentGyroAngle = Robot.mecDriveSubsystem.gyro1.getAngle();
    double targetGyroAngle = 0;
    double rotateZCommanded = 0;
    double rotateError;
    double rotateErrorAllowable = 2;
    double rotateP = 0.0003;
    boolean snapAngle = false;

    if(Robot.oi.xboxController.getRawButton(1) == true) {
      targetGyroAngle = 180;
      snapAngle = true;
    };

    if(Robot.oi.xboxController.getRawButton(2) == true) {
      targetGyroAngle = 270;
      snapAngle = true;
    };

    if(Robot.oi.xboxController.getRawButton(3) == true) {
      targetGyroAngle = 90;
      snapAngle = true;
    };

    if(Robot.oi.xboxController.getRawButton(4) == true) {
      targetGyroAngle = 0;
      snapAngle = true;
    };

    if (snapAngle == true) {
      rotateError = targetGyroAngle - currentGyroAngle;
      if (rotateError > rotateErrorAllowable) {
        rotateZCommanded = rotateError * rotateP;
      } else rotateZCommanded = 0;
    }

    if (snapAngle == false) {
      rotateZCommanded = rotateZ;
    }

		/**
		 * Print every ten loops, printing too much too fast is generally bad
		 * for performance.
		 */
		if (++loops >= 10) {
			loops = 0;
			System.out.println(currentGyroAngle);
		}

    Robot.mecDriveSubsystem.driveC(moveY, moveX, rotateZCommanded);
    
  
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

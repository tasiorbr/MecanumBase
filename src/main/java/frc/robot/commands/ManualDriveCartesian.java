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
  
  double targetAngle = 0;
  boolean snapToAngle = false;
  
  
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
    /*  Use this section to drive with xbox controller
    double moveX = -0.25 * Robot.oi.xboxController.getRawAxis(1);
    double moveY =  0.25 * Robot.oi.xboxController.getRawAxis(4);
    double rotateZ = 0.25 * (-Robot.oi.xboxController.getRawAxis(2) + Robot.oi.xboxController.getRawAxis(3));
    */
   
    /*  Use this section to drive with joysticks */
    double moveX = -0.7 * Robot.oi.leftstick.getRawAxis(1);
    double moveY =  Robot.oi.rightstick.getRawAxis(0);
    double rotateZ = 0.5 * Robot.oi.rightstick.getRawAxis(2);
    double hatAngle = Robot.oi.rightstick.getPOV();
  

 

    // This Section looks for joystic pov hat button presses to over ride manual twist
   
    if(hatAngle == 0) {
      targetAngle = 0;
      snapToAngle = true;
    };

    if(hatAngle == 45) {
      targetAngle = 28.75;
      snapToAngle = true;
    };

    if(hatAngle == 90) {
      targetAngle = 90;
      snapToAngle = true;
    };

 if(hatAngle == 135) {
      targetAngle = 118.75;
      snapToAngle = true;
    };
    
    if(hatAngle == 180) {
      targetAngle = 180;
      snapToAngle = true;
    };

    if(hatAngle == 225) {
      targetAngle = 151.25;
      snapToAngle = true;
    };

    if(hatAngle == 270) {
      targetAngle = 270;
      snapToAngle = true;
    };

    if(hatAngle == 315) {
      targetAngle = 298.75;
      snapToAngle = true;
    };


    // This section checks the actual angle vs the desired angle and calculates how much twist to use
    if (snapToAngle == true) {
      Robot.mecDriveSubsystem.driveAngle(moveY, moveX, targetAngle);
    }
    else {
   // This section sets twist to joystick value if no buttons are pressed
      Robot.mecDriveSubsystem.driveC(moveY, moveX, rotateZ);
    }
    
    snapToAngle = false;

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

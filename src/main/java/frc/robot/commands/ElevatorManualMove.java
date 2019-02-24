/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ElevatorManualMove extends Command {
  public ElevatorManualMove() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.elevatorSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    
    Robot.elevatorSubsystem.elevatorMotor.configPeakOutputForward(.2, 0);
    Robot.elevatorSubsystem.elevatorMotor.configPeakOutputReverse(-.2,0);

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double manualMove = 0;
    //  Use this section to use the joystick on the button box
    //  manualMove = -Robot.oi.gameStick.getRawAxis(0);
    
    //  Use this section to use the arrow pad on the xbox controller
    double povAngle = Robot.oi.xboxController.getPOV();
      if (povAngle == 325 | povAngle == 0 | povAngle == 45) {
        manualMove = 1;
      }

      if (povAngle == 135 | povAngle == 180 | povAngle == 225) {
        manualMove = -1;
      }
      
      if (povAngle == -1) {
        manualMove = 0;
      }


    Robot.elevatorSubsystem.elevManualPosition(manualMove);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.elevatorSubsystem.elevManualPosition(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    
    Robot.elevatorSubsystem.elevManualPosition(0);
  }
}

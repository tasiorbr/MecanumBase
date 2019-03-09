/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;
import frc.robot.commands.ManualDriveCartesian;

/**
 * Add your docs here.
 */
public class MecDriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  double rotateZCommanded = 0;
  double rotateError;
  double rotateErrorAllowable = 1.0;
  double rotateP = 0.0025;
  double newTargetAngle;
  double actualAngle;
  double newRotateError;
  int numberOfTurns;

  // instantiate new motor controller objects 
  public CANSparkMax driveFrontLeft = new CANSparkMax(RobotMap.drivemotorFrontLeftCANID, MotorType.kBrushless);
  public CANSparkMax driveRearLeft = new CANSparkMax(RobotMap.drivemotorRearLeftCANID, MotorType.kBrushless);
  public CANSparkMax driveRearRight = new CANSparkMax(RobotMap.drivemotorRearRightCANID, MotorType.kBrushless);
  public CANSparkMax driveFrontRight = new CANSparkMax(RobotMap.drivemotorFrontRightCANID, MotorType.kBrushless);

  // instantiate new gyro object
  public ADXRS450_Gyro gyro1 = new ADXRS450_Gyro();

  // instantiate a new MecanumDrive object and assign motor controllers to it
  // Note:  no need to invert motors when using mecanum drive (mecanum drive takes care of it internally)
  public MecanumDrive mDrive = new MecanumDrive(driveFrontLeft, driveRearLeft, driveFrontRight, driveRearRight);
     
    public MecDriveSubsystem() {
       mDrive.setSafetyEnabled(false);
       // mDrive.setExpiration(0.1);
        mDrive.setMaxOutput(1.0);
        mDrive.setDeadband(0.05);
    }


   // add manualDrive() method  
   // public void manualDrive(double move, double turn) {
   //   drive.arcadeDrive(move, turn);
   // }
   // public void driveCartesian​(double ySpeed, double xSpeed, double zRotation)
    public void driveC(double moveY, double moveX, double rotateZ) {
      mDrive.driveCartesian(moveY, moveX, rotateZ);   
     }

   // add manualDrive() method with override to drive at an angle 
   // public void driveCartesian​(double ySpeed, double xSpeed, double zRotation)
   public void driveAngle(double moveY, double moveX, double targetAngle) { 
      // This section checks the actual angle vs the desired angle and calculates how much twist to use
      
      actualAngle = gyro1.getAngle();
      rotateError = targetAngle - actualAngle;
      numberOfTurns = (int) (actualAngle / 360);
      newTargetAngle = targetAngle + (360 * numberOfTurns);
      newRotateError = newTargetAngle - actualAngle;

      if ( newTargetAngle - actualAngle  > 180 ) {
        newTargetAngle = newTargetAngle - 360;
        newRotateError = newTargetAngle - actualAngle;
      }

      if ( newTargetAngle - actualAngle  < 180 ) {
        newTargetAngle = newTargetAngle + 360;
        newRotateError = newTargetAngle - actualAngle;
      }

      if ( Math.abs(newRotateError) > rotateErrorAllowable) {
        rotateZCommanded = newRotateError * rotateP;
      }
      else rotateZCommanded = 0;
    mDrive.driveCartesian(moveY, moveX, rotateZCommanded);   
   }


 
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ManualDriveCartesian());
  }
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogGyro;
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
  // instantiate new motor controller objects


  
  public CANSparkMax driveFrontLeft = new CANSparkMax(RobotMap.drivemotorFrontLeftCANID, MotorType.kBrushless);
  public CANSparkMax driveRearLeft = new CANSparkMax(RobotMap.drivemotorRearLeftCANID, MotorType.kBrushless);
  public CANSparkMax driveRearRight = new CANSparkMax(RobotMap.drivemotorRearRightCANID, MotorType.kBrushless);
  public CANSparkMax driveFrontRight = new CANSparkMax(RobotMap.drivemotorFrontRightCANID, MotorType.kBrushless);

  public AnalogGyro gyro1 = new AnalogGyro(RobotMap.gyroPort);

  // instantiate a new MecanumDrive object and assign motor controllers to it
  // Note:  If motor controllers need to be inverted, do that first (or as part of the the joystick call)
  public MecanumDrive mDrive = new MecanumDrive(driveFrontLeft, driveRearLeft, driveFrontRight, driveRearRight);
     
    public MecDriveSubsystem() {
       mDrive.setSafetyEnabled(false);
       // mDrive.setExpiration(0.1);
        mDrive.setMaxOutput(1.0);
       // mDrive.setDeadband(0.05);
    }


   // add manualDrive() method  
   // public void manualDrive(double move, double turn) {
   //   drive.arcadeDrive(move, turn);
   // }
   // public void driveCartesian​(double ySpeed, double xSpeed, double zRotation)
    public void driveC(double moveX, double moveY, double rotateZ) {
      mDrive.driveCartesian(moveX, moveY, rotateZ);   
     }
 
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ManualDriveCartesian());
  }
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * Add your docs here.
 */
public class PneumaticsSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  Compressor c = new Compressor(0); 
  Solenoid gripperSolenoid = new Solenoid(1);
  DoubleSolenoid mainPlateDouble = new DoubleSolenoid(2, 3);
  DoubleSolenoid secondaryPlate = new DoubleSolenoid(4, 5);
  DoubleSolenoid forwardBackwardDouble = new DoubleSolenoid(6, 7);

  
  mainPlateDouble.set(DoubleSolenoid.Value.kOff);
  mainPlateDouble.set(mainPlateDouble.Value.kForward);
  mainPlateDouble.set(DoubleSolenoid.Value.kReverse);

  secondaryPlate.set(DoubleSolenoid.Value.kOff);
  secondaryPlate.set(DoubleSolenoid.Value.kForward);
  secondaryPlate.set(DoubleSolenoid.Value.kReverse);

  forwardBackwardDouble.set(DoubleSolenoid.Value.kOff);
  forwardBackwardDouble.set(DoubleSolenoid.Value.kForward);
  forwardBackwardDouble.set(DoubleSolenoid.Value.kRevrse);

  gripperSolenoid.set(true);
  gripperSolenoid.set(false);

  c.setClosedLoopControl(true);
  c.setClosedLoopControl(false); 

  boolean enabled = c.enabled();
  boolean pressureSwitch = c.getPressureSwitchValue();
  double current = c.getCompressorCurrent(); 

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}

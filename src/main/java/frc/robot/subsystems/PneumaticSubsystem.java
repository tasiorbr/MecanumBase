/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class PneumaticSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  Compressor c = new Compressor(0); 
 

  //DigitalInput forwardLimitSwitch, reverseLimitSwitch;
  public DigitalInput elevForwardLimitSwitch = new DigitalInput(0);
  public DigitalInput elevReverseLimitSwitch = new DigitalInput(1);
  public DigitalInput mainPlateDownLimitSwitch = new DigitalInput(2);
  public DigitalInput mainPlateUpLimitSwitch = new DigitalInput(3);
  public DigitalInput backPlateDownLimitSwitch = new DigitalInput(4);
  public DigitalInput backPlateUpLimitSwitch = new DigitalInput(5);
 
// Joel's comments:  updated wiring on practace 'bot to be the same as 'real' 'bot
  public DoubleSolenoid gripperSolenoid = new DoubleSolenoid(7, 0);
  public DoubleSolenoid mainPlateDouble = new DoubleSolenoid(5, 2);
  public DoubleSolenoid secondaryPlateDouble = new DoubleSolenoid(1, 6);
  public DoubleSolenoid forwardBackwardDouble = new DoubleSolenoid(3, 4);


// Joel's comment:  Adding this section is what allows us to call the PneumaticSubsystem from other parts of the code
    public PneumaticSubsystem () {

    /*
    Joel's comment - These lines simply return the state of the compressor, pressure switch and compressor current
    These are only needed if we want to display them on the driverstation/smart dashboard
    If uncommented they show as unused variables since they aren't currently used anywhere else
    By having them in this section, they should be able to be called from other areas of the code (but I could be wrong aobut that!)
    */
    //  boolean enabled = c.enabled();
    //  boolean pressureSwitch = c.getPressureSwitchValue();
    //  double current =c.getCompressorCurrent();
    
    }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}

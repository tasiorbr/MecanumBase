/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class PneumaticSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  Compressor c = new Compressor(0); 
  public Solenoid gripperSolenoid = new Solenoid(0);
  public DoubleSolenoid mainPlateDouble = new DoubleSolenoid(2, 3);
  public DoubleSolenoid secondaryPlateDouble = new DoubleSolenoid(4, 5);
  public DoubleSolenoid forwardBackwardDouble = new DoubleSolenoid(6, 7);

/*  These will be pulled out of here and used in the vavious commands...
 
  mainPlateDouble.set(DoubleSolenoid.Value.kOff);
  mainPlateDouble.set(DoubleSolenoid.Value.kForward);
  mainPlateDouble.set(DoubleSolenoid.Value.kReverse);

  secondaryPlate.set(DoubleSolenoid.Value.kOff);
  secondaryPlate.set(DoubleSolenoid.Value.kForward);
  secondaryPlate.set(DoubleSolenoid.Value.kReverse);

  forwardBackwardDouble.set(DoubleSolenoid.Value.kOff);
  forwardBackwardDouble.set(DoubleSolenoid.Value.kForward);
  forwardBackwardDouble.set(DoubleSolenoid.Value.kRevrse);
*/

//Joel's comment - Per documentation I don't think these lines are needed anywhere... this is what it says:
//Controlling the Compressor:
//The PCM handles the closed loop control of the compressor internally when the pressure switch and compressor are properly wired. 
//To enable this control, all that is needed is an instantiated Solenoid object and the robot to be Enabled.
//  c.setClosedLoopControl(true);
// c.setClosedLoopControl(false); 

// Joel's comment:  Adding this section is what allows us to call the PneumaticSubsystem from other parts of the code
    public PneumaticSubsystem () {

    //Joel's comment - These lines simply return the state of the compressor, pressure switch and compressor current
    //These are only needed if we want to display them on the driverstation/smart dashboard
    //However, they are not hurting anything as they are but...
    //If uncommented they show as unused variables since they aren't currently used anywhere else
    //By having them in this section, they should be able to be called from other areas of the code (but I could be wrong aobut that!)
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

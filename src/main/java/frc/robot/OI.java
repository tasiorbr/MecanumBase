/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

//cade added >>>>>>>>>>>>>>>>>>>>>>>>>>>
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.CloseGripper;
import frc.robot.commands.ElevatorManualMove;
import frc.robot.commands.LiftBackward;
import frc.robot.commands.LiftForward;
import frc.robot.commands.MainPlateDown;
import frc.robot.commands.MainPlateUp;
import frc.robot.commands.PlatesDown;
import frc.robot.commands.SecondaryPlateDown;
import frc.robot.commands.SecondaryPlateUp;
import frc.robot.commands.SetElevatorLevel;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  public Joystick leftstick = new Joystick(RobotMap.leftcontrollerPort);
  public Joystick rightstick = new Joystick(RobotMap.rightcontrollerPort);
  public Joystick gameStick = new Joystick(RobotMap.gameStickPort);

     
      //Justin changed layout of the buttons
      public Button levelOneHatch = new JoystickButton(gameStick, 11);
      //public Button levelOneCargo = new JoystickButton(gameStick, 7);
      public Button levelTwoHatch = new JoystickButton(gameStick, 5);
      // public Button levelTwoCargo = new JoystickButton(gameStick, 12);
      public Button levelThreeHatch = new JoystickButton(gameStick, 9);
      //public Button levelThreeCargo = new JoystickButton(gameStick, 10);

      public Button elevForward = new JoystickButton(gameStick, 8);
      public Button elevBackward = new JoystickButton(gameStick, 6);

      public Button climbOne = new JoystickButton(gameStick, 7);
      public Button climbTwo = new JoystickButton(gameStick, 12);
      public Button climbThree = new JoystickButton(gameStick, 10);
      public Button climbFour = new JoystickButton(gameStick, 3);


      

      //Joel added - This sets the trigger on the left joystick as the button for the gripper
      public Button gripperTrigger = new JoystickButton(leftstick, 1);
      
      //public Button elevatorStick = new JoystickButton(gameStick, 0);
  
      public OI() {

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    levelOneHatch.whenPressed(new SetElevatorLevel(0));
    //SmartDashboard.putData("Level 1 Hatch", new SetElevatorLevel(0));   
    
    //levelOneCargo.whenPressed(new SetElevatorLevel(200000));
    //SmartDashboard.putData("Level 1 Cargo", new SetElevatorLevel(200000));
    
    levelTwoHatch.whenPressed(new SetElevatorLevel(30000));
    //SmartDashboard.putData("Level 2 Hatch", new SetElevatorLevel(300000));
    
    //levelTwoCargo.whenPressed(new SetElevatorLevel(400000));
    //SmartDashboard.putData("Level 2 Cargo", new SetElevatorLevel(400000));
    
    levelThreeHatch.whenPressed(new SetElevatorLevel(500000));
    //SmartDashboard.putData("Level 3 Hatch", new SetElevatorLevel(500000));

    //levelThreeCargo.whenPressed(new SetElevatorLevel(600000));
    //SmartDashboard.putData("Level 3 Cargo", new SetElevatorLevel(600000));
  
   //  Add remaining buttons above with the others then copy the above syntax and add remaining levels here
  
  //  Joel's Comment:  This command will fire the command to close the gripper
  gripperTrigger.whileHeld(new CloseGripper());

  //  Justin's Comment: This command will fire the command to move lift forward
  elevForward.whenPressed(new LiftForward());

  //  Justin's Comment: This command will fire the command to move lift backward
  elevBackward.whenPressed(new LiftBackward());


  climbOne.whenPressed(new MainPlateDown());

  climbTwo.whenPressed(new SecondaryPlateDown());

  climbThree.whenPressed(new MainPlateUp());

  climbFour.whenPressed(new SecondaryPlateUp());

  //  Joel's Comment:  This command will fire the command to manually move the lift
  //elevatorStick.whileHeld(new ElevatorManualMove());
  Robot.elevatorSubsystem.elevatorMotor.set(ControlMode.PercentOutput, -gameStick.getRawAxis(0));
    



  }
  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}

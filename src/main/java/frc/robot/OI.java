/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//cade added >>>>>>>>>>>>>>>>>>>>>>>>>>>
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.CloseGripper;
import frc.robot.commands.GroundLevel;
import frc.robot.commands.LiftBackward;
import frc.robot.commands.SetElevatorLevel;
import frc.robot.commands.LiftForward;

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
      //Cade added >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
      public Button strafeLeft = new JoystickButton(rightstick, 3);
      public Button strafeRight = new JoystickButton(rightstick, 4);
      //Jade added with Cade's help
      public Button motorClockwise = new JoystickButton(rightstick, 1);
      public Button motorCounterClockwise = new JoystickButton(rightstick, 2);
      //Jade added
     /* public Button firstLevel = new JoystickButton(rightstick, 5);
      public Button secondLevel = new JoystickButton(rightstick, 6);
      public Button thirdLevel = new JoystickButton(rightstick, 7);
      public Button fourthLevel = new JoystickButton(rightstick, 8);
      public Button fifthLevel = new JoystickButton(rightstick, 9);*/
      //Shaddai added by looking at Cade's code
      public Button firstLevel = new JoystickButton(gameStick, 4);
      public Button secondLevel = new JoystickButton(gameStick, 9);
      public Button thirdLevel = new JoystickButton(gameStick, 5);
      public Button fourthLevel = new JoystickButton(gameStick, 11);
      public Button fifthLevel = new JoystickButton(gameStick, 3);

      public Button elevForward = new JoystickButton(gameStick, 8);
      public Button elevBackward = new JoystickButton(gameStick, 6);

      public Button climbOne = new JoystickButton(gameStick, 10);
      public Button climbTwo = new JoystickButton(gameStick, 12);
      public Button climbThree = new JoystickButton(gameStick, 7);

  

      //Joel added - This sets the trigger on the left joystick as the button for the gripper
      public Button grippertrigger = new JoystickButton(leftstick, 1);
  
      public OI() {

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    firstLevel.whenPressed(new GroundLevel());
    SmartDashboard.putData("Level 1", new GroundLevel());   
    
    secondLevel.whenPressed(new SetElevatorLevel(200));
    SmartDashboard.putData("Level 2", new SetElevatorLevel(200));
    
    thirdLevel.whenPressed(new SetElevatorLevel(400));
    SmartDashboard.putData("Level 3", new SetElevatorLevel(400));
    
    fourthLevel.whenPressed(new SetElevatorLevel(600));
    SmartDashboard.putData("Level 4", new SetElevatorLevel(600));
    
    fifthLevel.whenPressed(new SetElevatorLevel(800));
    SmartDashboard.putData("Level 5", new SetElevatorLevel(800));
  
   //  Add remaining buttons above with the others then copy the above syntax and add remaining levels here
  
  //  Joel's Comment:  This command will fire the command to close the gripper
  grippertrigger.whileHeld(new CloseGripper());

  //  Justin's Comment: This command will fire the command to move lift forward
  elevForward.whenPressed(new LiftForward());

  //  Justin's Comment: This command will fire the command to move lift backward
  elevBackward.whenPressed(new LiftBackward());





  }
  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}

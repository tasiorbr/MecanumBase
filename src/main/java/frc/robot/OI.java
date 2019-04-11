/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.Climb;
import frc.robot.commands.ClimpPrep2;
import frc.robot.commands.CloseGripper;
import frc.robot.commands.ElevatorManualMove;
import frc.robot.commands.LiftBackward;
import frc.robot.commands.LiftForward;
import frc.robot.commands.MainPlateDown;
import frc.robot.commands.MainPlateUp;
import frc.robot.commands.RearPlateDown;
import frc.robot.commands.RearPlateUp;
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
  public Joystick bBBlue = new Joystick(RobotMap.bBBluePort);
  public Joystick bBRed = new Joystick(RobotMap.bBRedPort);
  //public Joystick xboxController = new Joystick(RobotMap.xboxControllerPort);

     
      //Justin changed layout of the buttons

      /*
      public Button levelOneHatch = new JoystickButton(xboxController, 5);
      public Button levelOneCargo = new JoystickButton(xboxController, 6);
      public Button levelTwoHatch = new JoystickButton(xboxController, 7);
      public Button levelTwoCargo = new JoystickButton(xboxController, 8);
      //public Button levelThreeHatch = new JoystickButton(xboxController, 8);
      //public Button levelThreeCargo = new JoystickButton(gameStick, 10);
      */

      
      public Button levelOneHatch = new JoystickButton(bBBlue, 4);
      //public Button levelOneCargo = new JoystickButton(bBBlue, 4);
      public Button levelTwoHatch = new JoystickButton(bBBlue, 3);
      //public Button levelTwoCargo = new JoystickButton(bBBlue, 3);
      public Button levelThreeHatch = new JoystickButton(bBBlue, 2);
      //public Button levelThreeCargo = new JoystickButton(bBBlue, 2);
      public Button pClimb = new JoystickButton(bBBlue, 10);
      public Button cStow = new JoystickButton(bBBlue, 9);
      public Button cLoad = new JoystickButton(bBBlue, 5);
      public Button cDrop = new JoystickButton(bBBlue, 1);
      
      public Button elevForward = new JoystickButton(bBRed, 1);
      public Button elevBackward = new JoystickButton(bBRed, 2);

      public Button mainPlateDown = new JoystickButton(bBRed, 8);
      public Button rearPlateDown = new JoystickButton(bBRed, 7);
      public Button mainPlateUp = new JoystickButton(bBRed, 6);
      public Button rearPlateUp = new JoystickButton(bBRed, 5);

      public Button prepClimb = new JoystickButton(bBRed, 10);
      public Button climb = new JoystickButton(bBRed, 9);

      public Button alignCargoShipFront = new JoystickButton(leftstick, 3);
      public Button alignLoadingStation = new JoystickButton(leftstick, 4);      
      public Button alignCargoShipLeft = new JoystickButton(leftstick, 5);
      public Button alignCargoShipRight = new JoystickButton(leftstick, 6);

      public Button alignRocketRightFront = new JoystickButton(rightstick, 3);
      public Button alignRocketLeftFront = new JoystickButton(rightstick, 4);      
      public Button alignRocketRightRear = new JoystickButton(rightstick, 5);
      public Button alignRocketLeftRear = new JoystickButton(rightstick, 6);
      

      
      //Joel added - This sets the trigger on the left joystick as the button for the gripper
      public Button gripperTrigger = new JoystickButton(rightstick, 1);
      
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
        // 10000 = ~2" 
    levelTwoHatch.whenPressed(new SetElevatorLevel(540000));
    
    levelThreeHatch.whenPressed(new SetElevatorLevel(980000));
    
    pClimb.whenPressed(new SetElevatorLevel(300000));
    
    /*
    levelOneCargo.whenPressed(new SetElevatorLevel(270000));
      
    levelTwoCargo.whenPressed(new SetElevatorLevel(640000));
   
    levelThreeCargo.whenPressed(new SetElevatorLevel(1079000));
    */

    prepClimb.whenPressed(new ClimpPrep2());

    climb.whenPressed(new Climb());



    

    // Manual move using the button box joystick
    if (bBRed.getRawAxis(1) != 0) {
      new ElevatorManualMove();
    }
  
   //  Add remaining buttons above with the others then copy the above syntax and add remaining levels here
  
  //  Joel's Comment:  This command will fire the command to close the gripper
  gripperTrigger.whileHeld(new CloseGripper());

  //  Justin's Comment: This command will fire the command to move lift forward
  elevForward.whenPressed(new LiftForward());

  //  Justin's Comment: This command will fire the command to move lift backward
  elevBackward.whenPressed(new LiftBackward());


  mainPlateDown.whenPressed(new MainPlateDown());

  rearPlateDown.whenPressed(new RearPlateDown());

  mainPlateUp.whenPressed(new MainPlateUp());

  rearPlateUp.whenPressed(new RearPlateUp());


  



  }
  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
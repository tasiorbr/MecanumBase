/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * Add your docs here.
 */
public class Gyro {

    private RobotDrive mDrive;
    private Gyro gyro;

    double Kp = 0.03;

    public Gyro() {
        //I'm not sure why there is an error here
        gyro = new AnalogGyro(1);
        /* 
        The RobotDrive command will have to be changed because it is expecting a Talon controller 
        with PWM but we are using the new sparkMax motor controllers 
        */
        mDrive = new RobotDrive(1, 2);
        mDrive.setExpiration(0.1);
    }

}


/* This is the code I (Shaddai) followed to do the above:

package edu.wpi.first.wpilibj.templates;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;
public class GyroSample extends SampleRobot {

 \   private RobotDrive myRobot; // robot drive system
    private Gyro gyro;

 \   double Kp = 0.03;

    public GyroSample() {
        gyro = new AnalogGyro(1); \            // Gyro on Analog Channel 1
        myRobot = new RobotDrive(1,2); \ // Drive train jaguars on PWM 1 and 2
        myRobot.setExpiration(0.1);
 \   }

    public void autonomous() {
        gyro.reset();
        while (isAutonomous()) {
            double angle = gyro.getAngle(); // get current heading
            myRobot.drive(-1.0, -angle*Kp); // drive towards heading 0
            Timer.delay(0.004);
        }
        myRobot.drive(0.0, 0.0);
 \   }
}

*/

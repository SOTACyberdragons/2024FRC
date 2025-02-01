// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;

import frc.robot.Constants;

public class Feeder extends SubsystemBase {

  private TalonSRX motorFeeder = new TalonSRX(Constants.motorFeederID);// feeder conveyor motor

  private DigitalInput feederBeamBreak;
  private DigitalInput feederBeamBreakLow;




  /** Creates a new TalonSRXMotors. */
  public Feeder() {
    feederBeamBreak = new DigitalInput(0);
    feederBeamBreakLow = new DigitalInput(2);

  }

  public void setSpeedFeeder(double speed) {
    motorFeeder.set(ControlMode.PercentOutput,speed);
  }
  
  public boolean getFeederBeamBreak() {
    return !feederBeamBreak.get();
  }

  public boolean getFeederBeamBreakLow() {
    return !feederBeamBreakLow.get();
  }

}

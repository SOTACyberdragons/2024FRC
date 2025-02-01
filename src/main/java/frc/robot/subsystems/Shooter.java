// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.NeutralOut;
import com.ctre.phoenix6.controls.VelocityDutyCycle;
import com.ctre.phoenix6.controls.VelocityTorqueCurrentFOC;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class Shooter extends SubsystemBase {

  private TalonFX motorShooter1 = new TalonFX(Constants.motorShooter1ID); //shooter motor
  //private TalonFX motorShooter2 = new TalonFX(Constants.motorShooter2ID); //shooter motor
  private TalonSRX motorShooterTalon = new TalonSRX(Constants.motorShooter2ID);

  private NeutralOut coast = new NeutralOut();
  
  private VelocityDutyCycle shooterVelocity = new VelocityDutyCycle(0);
  private DutyCycleOut shooterPercentOutput = new DutyCycleOut(0);
  private VelocityVoltage shooterVoltage = new VelocityVoltage(0, 0, true, 0, 0, false, false, false);
  
  
  /** Creates a new Intake. */
  public Shooter() {
    
    configShooterMotor();


  }


  public void shooterRun(double velocity) {

    shooterVelocity.Velocity = velocity;
    motorShooter1.setControl(shooterVelocity);
    motorShooterTalon.set(TalonSRXControlMode.PercentOutput,0.5);
   // motorShooter2.setControl(new Follower(motorShooter1.getDeviceID(), false));

  }

    public void shooterRunVoltage(double velocity) {
      
    motorShooter1.setControl(shooterVoltage.withVelocity(velocity).withFeedForward(0.5));
    motorShooterTalon.set(TalonSRXControlMode.PercentOutput,0.5);
   // motorShooter2.setControl(new Follower(motorShooter1.getDeviceID(), false));

  }



  public void setShooterSpeed(double percentOutput){
    shooterPercentOutput.Output = percentOutput; // -1 reverse, 1 forward 
    motorShooter1.setControl(shooterPercentOutput);
    motorShooterTalon.set(TalonSRXControlMode.PercentOutput,0.95);
    //motorShooter2.setControl(new Follower(motorShooter1.getDeviceID(), false));

  }

  public void shooterStop(){
    motorShooter1.setControl(coast);
    //motorShooterTalon.set(TalonSRXControlMode.Disabled);
    //motorShooter2.setControl(coast);
    motorShooterTalon.neutralOutput();

  }


  public void configShooterMotor() {

    motorShooter1.getConfigurator().apply(new TalonFXConfiguration());
    motorShooter1.getConfigurator().apply(Robot.ctreConfigs.shooterFXConfig);
    //motorShooter2.getConfigurator().apply(new TalonFXConfiguration());
    //motorShooter2.getConfigurator().apply(Robot.ctreConfigs.shooterFXConfig);
    motorShooterTalon.setNeutralMode(NeutralMode.Coast);
    resetShooterEncoder();

  }
  public void resetShooterEncoder() {
    motorShooter1.setPosition(0);
    //motorShooter2.setPosition(0);
  }

  public double getShooterVelocity() {

    return motorShooter1.getRotorVelocity().getValueAsDouble();
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Shooter Speed", getShooterVelocity());
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.controls.NeutralOut;
import com.ctre.phoenix6.controls.PositionDutyCycle;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Intake extends SubsystemBase {


  private TalonFX motorIntakePivot = new TalonFX(Constants.motorIntakePivotID);
  private TalonSRX motorIntake = new TalonSRX(Constants.motorIntakeID);


  private NeutralOut coast = new NeutralOut();

  private PositionDutyCycle intakePivotPosition = new PositionDutyCycle(0,0,true,0,0,false,false,false);
  private DutyCycleOut intakePivotPercentOutput = new DutyCycleOut(0);
  private PositionVoltage intakePivotVoltage = new PositionVoltage(0,0,true,0,1,false,false,false);
  private MotionMagicVoltage intakePivotMM = new MotionMagicVoltage(0,true,0,2,false,false,false);
   

  /** Creates a new Intake. */
  public Intake() {

    configIntakePivotMotor();
    configTalonSRX();

    
  }

  public void intakePivot(double position) {

    intakePivotPosition.Position = position;
    motorIntakePivot.setControl(intakePivotPosition.withSlot(0));
  }

  public void intakePivotVoltage(double position) {

    intakePivotVoltage.Position = position;
    motorIntakePivot.setControl(intakePivotVoltage.withPosition(position).withSlot(1));
  }

  public void intakePivotMM(double position) {

    intakePivotMM.Position = position;
    motorIntakePivot.setControl(intakePivotMM.withPosition(position).withSlot(2));
  }

  public void intakeStop(){
    motorIntakePivot.setControl(coast);

  }

  
  public void intakePivotPercentOutput(double percentOutput) {

    intakePivotPercentOutput.Output = percentOutput;
    motorIntakePivot.setControl(intakePivotPercentOutput);
  }

  public void intakeMotorSpeed(double speed){
    this.motorIntake.set(ControlMode.PercentOutput,speed);
  }

  public void resetIntakePivotEncoder() {

    motorIntakePivot.setPosition(0);

  }

  public void configIntakePivotMotor() {

    motorIntakePivot.getConfigurator().apply(new TalonFXConfiguration());
    motorIntakePivot.getConfigurator().apply(Robot.ctreConfigs.intakePivotFXConfig);
    resetIntakePivotEncoder();

  }
  public void configTalonSRX(){

    
    motorIntake.configFactoryDefault();
    /* 
    motorIntake.enableCurrentLimit(true);
    motorIntake.configPeakCurrentLimit(15, 30); //Constants.kPeakCurrentAmps, Constants.kTimeoutMs
    motorIntake.configPeakCurrentDuration(0, 30); //Constants.kPeakTimeMs, Constants.kTimeoutMs
		motorIntake.configContinuousCurrentLimit(10, 30);//Constants.kContinCurrentAmps, Constants.kTimeoutMs
    */
    motorIntake.setNeutralMode(NeutralMode.Coast); 
  }
  
  public double getIntakePivotPosition() {

    return motorIntakePivot.getPosition().getValueAsDouble();

  }
  public double getIntakeCurrent() {

    return motorIntake.getStatorCurrent();

  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Intake Pivot Position", getIntakePivotPosition());
    SmartDashboard.putNumber("Intake Motor Current", getIntakeCurrent());
  }
}

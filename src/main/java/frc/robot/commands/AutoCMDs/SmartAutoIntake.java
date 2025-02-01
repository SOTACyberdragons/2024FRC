// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutoCMDs;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;
import frc.robot.Constants;
import frc.robot.subsystems.Feeder;



public class SmartAutoIntake extends Command {
  private Intake intake;
  private Feeder feeder;
  private boolean killed = false;
  private boolean beamH = false;
  private boolean beamL = false;
  private boolean clearBL;


  /** Creates a new IntakeCMD. */
  public SmartAutoIntake(Intake intake, Feeder feeder) {
    this.intake = intake;
    this.feeder = feeder;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intake,feeder);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intake.intakePivotMM(Constants.INTAKE_PIVOT_INTAKE);
    System.out.println("Intake Down");
    SmartDashboard.putBoolean("Intaking", true);
    killed = false;
    clearBL=false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intake.intakePivotMM(Constants.INTAKE_PIVOT_INTAKE);
    beamH = feeder.getFeederBeamBreak();
    beamL = feeder.getFeederBeamBreakLow();
    if(!beamH && !beamL){
      intake.intakeMotorSpeed(1);
      feeder.setSpeedFeeder(1);
    } else if(!beamH && beamL){
      intake.intakeMotorSpeed(0);
      feeder.setSpeedFeeder(0.65);
    } else if(beamH && !beamL){
      intake.intakeMotorSpeed(0);
      feeder.setSpeedFeeder(-0.5);
    }else if(beamH && beamL){
      intake.intakeMotorSpeed(0);
      feeder.setSpeedFeeder(0);
      SmartDashboard.putBoolean("Note Not Set", false);
      SmartDashboard.putBoolean("Note Got", true);
      SmartDashboard.putBoolean("Intaking", false);
      
    }
        
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    SmartDashboard.putBoolean("Intaking", false);
    SmartDashboard.putBoolean("Note Not Set", false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return killed;
  }
}
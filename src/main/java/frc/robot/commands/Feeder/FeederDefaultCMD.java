// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Feeder;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.Feeder;


public class FeederDefaultCMD extends Command {
  private Feeder feeder;


  /** Creates a new IntakeCMD. */
  public FeederDefaultCMD(Feeder feeder) {
    this.feeder = feeder;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(feeder);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Feeder Default");
    feeder.setSpeedFeeder(0);
  }

  // Called every time the scheduler runs while the command is scheduled.

  @Override
  public void execute() {
    if(feeder.getFeederBeamBreak() && feeder.getFeederBeamBreakLow()){
      SmartDashboard.putBoolean("Note Got", true);
      SmartDashboard.putBoolean("Note Not Set", false);
      //feeder.setSpeedFeeder(0);
    }
    else if(feeder.getFeederBeamBreakLow() && !feeder.getFeederBeamBreak()){
      SmartDashboard.putBoolean("Note Not Set", false);
      SmartDashboard.putBoolean("Note Got", true);
      //feeder.setSpeedFeeder(0.9);
    }
   else if(!feeder.getFeederBeamBreakLow() && feeder.getFeederBeamBreak()){
      SmartDashboard.putBoolean("Note Not Set", true);
      SmartDashboard.putBoolean("Note Got", false);
      //feeder.setSpeedFeeder(-0.22);
    }
    else if(!feeder.getFeederBeamBreak() && !feeder.getFeederBeamBreakLow()){
      SmartDashboard.putBoolean("Note Got", false);
      SmartDashboard.putBoolean("Note Not Set", false);
      //feeder.setSpeedFeeder(0);
    }
    else{
      SmartDashboard.putBoolean("Note Got", false);
      SmartDashboard.putBoolean("Note Not Set", false);
    }
    
  }

}
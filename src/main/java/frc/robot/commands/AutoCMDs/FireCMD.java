// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutoCMDs;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Feeder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class FireCMD extends Command {
	private final double duration;
  private Feeder feeder;
  private Shooter shooter;
	private double endTime;
	private boolean killed = false;
  private boolean beamH = false;
  private boolean beamL = false;




  /** Creates a new SetTalonSpeed. */
  public FireCMD(Feeder feeder, Shooter shooter) {
    this.duration = 0.5;
    this.feeder = feeder;
    this.shooter = shooter;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(feeder, shooter);
  }
 
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    killed = false;
    endTime = Timer.getFPGATimestamp() + duration;
    System.out.println("Fire");
    shooter.setShooterSpeed(1);
  
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    beamH = feeder.getFeederBeamBreak();
    beamL = feeder.getFeederBeamBreakLow();
    shooter.setShooterSpeed(1);
    feeder.setSpeedFeeder(1);
    if(Timer.getFPGATimestamp() > endTime && !beamH){
      killed = true;
    }

  }
  @Override
  public void end(boolean interrupted) {
    System.out.println("Note Shot"); 
    System.out.println("Shooter Off, Feeder Off, Shooter Down"); 
    shooter.setShooterSpeed(0);
    feeder.setSpeedFeeder(0);
    SmartDashboard.putBoolean("Shooting", false);
    SmartDashboard.putBoolean("Note Got", false);
  }


  @Override
  public boolean isFinished() {
    return killed;
  }

}
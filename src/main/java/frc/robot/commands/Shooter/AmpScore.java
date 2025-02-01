// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Shooter;


public class AmpScore extends Command {

  private Feeder feeder;
  private Shooter shooter;


  /** Creates a new SetTalonSpeed. */
  public AmpScore(Feeder feeder,Shooter shooter) {
    this.feeder = feeder;
    this.shooter = shooter;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(feeder,shooter);
  }
 
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("AMP");
    //SmartDashboard.putBoolean("Shooting", true);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooter.setShooterSpeed(1);
    feeder.setSpeedFeeder(1);

  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("AMP Release");
    shooter.setShooterSpeed(0);
    feeder.setSpeedFeeder(0);
    //SmartDashboard.putBoolean("Shooting", false);
    //.putBoolean("Shot", false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }


}


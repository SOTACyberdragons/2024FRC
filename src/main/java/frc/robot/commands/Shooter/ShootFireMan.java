// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Shooter;


public class ShootFireMan extends Command {

  private Feeder feeder;
  private Shooter shooter;
  private double currentSpeedRPM;

  /** Creates a new SetTalonSpeed. */
  public ShootFireMan (Feeder feeder,Shooter shooter) {

    this.feeder = feeder;
    this.shooter = shooter;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(feeder,shooter);
  }
 
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Shooting Speaker");
    

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooter.setShooterSpeed(1);
    currentSpeedRPM = shooter.getShooterVelocity();
    if(currentSpeedRPM > Constants.SHOOTER_SHOOT){
      shooter.setShooterSpeed(1);
      feeder.setSpeedFeeder(1);
      SmartDashboard.putBoolean("Shooting", true);

    }


  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("Shooting Release");
    //SmartDashboard.putBoolean("Shot", false);
    SmartDashboard.putBoolean("Shooting", false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }


}

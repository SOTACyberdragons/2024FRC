// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Shooter;


public class ShooterCMD extends Command {

  //private double feederdelay;
  private Feeder feeder;
  private Shooter shooter;
  private double currentSpeedRPM;

  /** Creates a new SetTalonSpeed. */
  public ShooterCMD(Feeder feeder,Shooter shooter) {

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
    shooter.shooterRunVoltage(Constants.SHOOTER_SHOOT_REV);
    currentSpeedRPM = shooter.getShooterVelocity();
    if(Math.abs(currentSpeedRPM - Constants.SHOOTER_SHOOT_REV) < 1.5){
      //shooter.setShooterSpeed(1);
      //shooter.shooterRun(Constants.SHOOTER_SHOOT);
      //feeder.setSpeedFeeder(1);
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

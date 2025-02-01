// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutoCMDs;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Shooter;


public class Bloop extends Command {

  private Feeder feeder;
  private Shooter shooter;
  private double feederdelay;
  private boolean killed;




  /** Creates a new SetTalonSpeed. */
  public Bloop(Feeder feeder,Shooter shooter) {
    this.feeder = feeder;
    this.shooter = shooter;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(feeder,shooter);
  }
 
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("AMP");
    //shooter.shooterPistonDown();
    SmartDashboard.putBoolean("Shooting", true);
    feederdelay = Timer.getFPGATimestamp() + 0.7;
    killed = false;
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
    if(Timer.getFPGATimestamp() > feederdelay){
      killed = true;
      SmartDashboard.putBoolean("Shooting", false);
      SmartDashboard.putBoolean("Shot", false);
    }
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return killed;
  }


}

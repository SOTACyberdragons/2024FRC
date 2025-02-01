// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutoCMDs;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Shooter;




public class Shooting extends Command {

  private Shooter shooter;
  private Feeder feeder;
  private boolean killed = false;
  //private final double duration;
	//private double endTime;





  /** Creates a new SetTalonSpeed. */
  public Shooting(Shooter shooter) {
    //this.duration = 0.5;
    this.shooter = shooter;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(shooter);
  }
 
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //endTime = Timer.getFPGATimestamp() + duration;
    killed = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooter.setShooterSpeed(1);
    double currentSpeedRPM = shooter.getShooterVelocity();
    if(currentSpeedRPM > Constants.SHOOTER_SHOOT){
      killed = true;
    }


  }
  @Override
  public void end(boolean interrupted) {
    //shooter.setShooterSpeed(1);
    //feeder.setSpeedFeeder(1);

  }

  @Override
  public boolean isFinished() {
    return killed;
  }

}
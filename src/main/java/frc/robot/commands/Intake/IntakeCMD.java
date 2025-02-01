// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
//import frc.lib.util.MathUtil;
//import frc.robot.RobotContainer;
import frc.robot.subsystems.Intake;


public class IntakeCMD extends Command {
  private Intake intake;

  //private RobotContainer robotContainer;

  /** Creates a new IntakeCMD. */
  public IntakeCMD(Intake intake) {
    this.intake = intake;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intake.intakeMotorSpeed(1);
    intake.intakePivot(Constants.INTAKE_PIVOT_INTAKE);
    System.out.println("Intake Down, Full Speed");
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
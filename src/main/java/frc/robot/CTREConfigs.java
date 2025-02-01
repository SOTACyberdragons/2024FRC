package frc.robot;

import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.configs.FeedbackConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;

public final class CTREConfigs {
    public TalonFXConfiguration swerveAngleFXConfig = new TalonFXConfiguration();
    public TalonFXConfiguration swerveDriveFXConfig = new TalonFXConfiguration();
    public CANcoderConfiguration swerveCANcoderConfig = new CANcoderConfiguration();

    public TalonFXConfiguration shooterFXConfig = new TalonFXConfiguration();
    public TalonFXConfiguration intakePivotFXConfig = new TalonFXConfiguration();

    public CTREConfigs(){



        /*Shooter Motor */

        /* Shooter Output and Neutral Mode */
        var shooterOutput = shooterFXConfig.MotorOutput;
        shooterOutput.Inverted = Constants.SHOOTER_INVERTED;
        shooterOutput.NeutralMode = Constants.SHOOTER_NEUTRAL_MODE;

        /* Shooter Current Limits */
        var shooterCurrentLimits = shooterFXConfig.CurrentLimits;
        shooterCurrentLimits.SupplyCurrentLimitEnable = Constants.SHOOTER_ENABLE_CURRENT_LIMIT;
        shooterCurrentLimits.SupplyCurrentLimit = Constants.SHOOTER_SUPPLY_CURRENT_LIMIT;
        shooterCurrentLimits.SupplyCurrentThreshold = Constants.SHOOTER_SUPPLY_CURRENT_THRESHOLD;
        shooterCurrentLimits.SupplyTimeThreshold = Constants.SHOOTER_SUPPLY_TIME_THRESHOLD;

        /* Shooter PID Config */
        var shooterSlot0 = shooterFXConfig.Slot0;
        shooterSlot0.kP = Constants.SHOOTER_P;
        shooterSlot0.kI = Constants.SHOOTER_I;
        shooterSlot0.kD = Constants.SHOOTER_D;
        shooterSlot0.kV = Constants.SHOOTER_V;


        shooterFXConfig.Voltage.PeakForwardVoltage = 16;
        shooterFXConfig.Voltage.PeakReverseVoltage = 0;

        /*Intake Pivot */

        /* Intake Pivot Output and Neutral Mode */
        var intakePivotOutput = intakePivotFXConfig.MotorOutput;
        intakePivotOutput.Inverted = Constants.INTAKE_PIVOT_INVERTED;
        intakePivotOutput.NeutralMode = Constants.INTAKE_PIVOT_NEUTRAL_MODE;
 
        /* Intake Pivot Current Limits */
        var intakePivotCurrentLimits = intakePivotFXConfig.CurrentLimits;
        intakePivotCurrentLimits.SupplyCurrentLimitEnable = Constants.INTAKE_PIVOT_ENABLE_CURRENT_LIMIT;
        intakePivotCurrentLimits.SupplyCurrentLimit = Constants.INTAKE_PIVOT_SUPPLY_CURRENT_LIMIT;
        intakePivotCurrentLimits.SupplyCurrentThreshold = Constants.INTAKE_PIVOT_SUPPLY_CURRENT_THRESHOLD;
        intakePivotCurrentLimits.SupplyTimeThreshold = Constants.INTAKE_PIVOT_SUPPLY_TIME_THRESHOLD;
 
        /* Intake Pivot PID Config */
        var intakePivotSlot0 = intakePivotFXConfig.Slot0;
        intakePivotSlot0.kP = Constants.INTAKE_PIVOT_P;
        intakePivotSlot0.kI = Constants.INTAKE_PIVOT_I;
        intakePivotSlot0.kD = Constants.INTAKE_PIVOT_D;
        intakePivotSlot0.kV = Constants.INTAKE_PIVOT_V;
        

        var intakePivotSlot1 = intakePivotFXConfig.Slot1;
        intakePivotSlot1.kP = 2;
        intakePivotSlot1.kI = 0.1;
        intakePivotSlot1.kD = 0.5;
        intakePivotSlot1.kV = 0.0;
        intakePivotFXConfig.Voltage.PeakForwardVoltage = 10;
        intakePivotFXConfig.Voltage.PeakReverseVoltage = -10;

        var intakePivotSlot2 = intakePivotFXConfig.Slot2;
        intakePivotSlot2.kP = 4;
        intakePivotSlot2.kI = 0.01;
        intakePivotSlot2.kD = 0.02;
        intakePivotSlot2.kV = 0.15;
        intakePivotSlot2.kS = 0.25;

        
        /* Intake Pivot MM Config */
        var intakePivotMotionMagic = intakePivotFXConfig.MotionMagic;
        intakePivotMotionMagic.MotionMagicCruiseVelocity = 2000;
        intakePivotMotionMagic.MotionMagicAcceleration = 1700;
        intakePivotMotionMagic.MotionMagicJerk = 4000;


        /** Swerve CANCoder Configuration */
        swerveCANcoderConfig.MagnetSensor.SensorDirection = Constants.Swerve.cancoderInvert;

        /** Swerve Angle Motor Configurations */
        /* Motor Inverts and Neutral Mode */
        swerveAngleFXConfig.MotorOutput.Inverted = Constants.Swerve.angleMotorInvert;
        swerveAngleFXConfig.MotorOutput.NeutralMode = Constants.Swerve.angleNeutralMode;

        /* Gear Ratio and Wrapping Config */
        swerveAngleFXConfig.Feedback.SensorToMechanismRatio = Constants.Swerve.angleGearRatio;
        swerveAngleFXConfig.ClosedLoopGeneral.ContinuousWrap = true;
        
        /* Current Limiting */
        swerveAngleFXConfig.CurrentLimits.SupplyCurrentLimitEnable = Constants.Swerve.angleEnableCurrentLimit;
        swerveAngleFXConfig.CurrentLimits.SupplyCurrentLimit = Constants.Swerve.angleCurrentLimit;
        swerveAngleFXConfig.CurrentLimits.SupplyCurrentThreshold = Constants.Swerve.angleCurrentThreshold;
        swerveAngleFXConfig.CurrentLimits.SupplyTimeThreshold = Constants.Swerve.angleCurrentThresholdTime;

        /* PID Config */
        swerveAngleFXConfig.Slot0.kP = Constants.Swerve.angleKP;
        swerveAngleFXConfig.Slot0.kI = Constants.Swerve.angleKI;
        swerveAngleFXConfig.Slot0.kD = Constants.Swerve.angleKD;

        /** Swerve Drive Motor Configuration */
        /* Motor Inverts and Neutral Mode */
        swerveDriveFXConfig.MotorOutput.Inverted = Constants.Swerve.driveMotorInvert;
        swerveDriveFXConfig.MotorOutput.NeutralMode = Constants.Swerve.driveNeutralMode;

        /* Gear Ratio Config */
        swerveDriveFXConfig.Feedback.SensorToMechanismRatio = Constants.Swerve.driveGearRatio;

        /* Current Limiting */
        swerveDriveFXConfig.CurrentLimits.SupplyCurrentLimitEnable = Constants.Swerve.driveEnableCurrentLimit;
        swerveDriveFXConfig.CurrentLimits.SupplyCurrentLimit = Constants.Swerve.driveCurrentLimit;
        swerveDriveFXConfig.CurrentLimits.SupplyCurrentThreshold = Constants.Swerve.driveCurrentThreshold;
        swerveDriveFXConfig.CurrentLimits.SupplyTimeThreshold = Constants.Swerve.driveCurrentThresholdTime;

        /* PID Config */
        swerveDriveFXConfig.Slot0.kP = Constants.Swerve.driveKP;
        swerveDriveFXConfig.Slot0.kI = Constants.Swerve.driveKI;
        swerveDriveFXConfig.Slot0.kD = Constants.Swerve.driveKD;

        /* Open and Closed Loop Ramping */
        swerveDriveFXConfig.OpenLoopRamps.DutyCycleOpenLoopRampPeriod = Constants.Swerve.openLoopRamp;
        swerveDriveFXConfig.OpenLoopRamps.VoltageOpenLoopRampPeriod = Constants.Swerve.openLoopRamp;

        swerveDriveFXConfig.ClosedLoopRamps.DutyCycleClosedLoopRampPeriod = Constants.Swerve.closedLoopRamp;
        swerveDriveFXConfig.ClosedLoopRamps.VoltageClosedLoopRampPeriod = Constants.Swerve.closedLoopRamp;
    }
}
package frc.robot;


import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.signals.SensorDirectionValue;
import com.pathplanner.lib.util.HolonomicPathFollowerConfig;
import com.pathplanner.lib.util.PIDConstants;
import com.pathplanner.lib.util.ReplanningConfig;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;
import frc.lib.util.COTSTalonFXSwerveConstants;
import frc.lib.util.SwerveModuleConstants;

public final class Constants {
    
    //TalonSRX motors
    public static final int motorFeederID = 15; //TalonSRX feeder
    public static final int motorIntakeID = 14; //TalonSRX motor intake

    //TalonFX motors
    public static final int motorIntakePivotID = 16; //TalonFX intake Pivot
    public static final int motorShooter1ID = 17; //TalonFX motor 1 shooter
    public static final int motorShooter2ID = 18; //TalonSRX motor 2 shooter

    //Shooter

    /* Shooter Inverts and Neutral Mode */
    public static final InvertedValue SHOOTER_INVERTED = InvertedValue.CounterClockwise_Positive;
    public static final NeutralModeValue SHOOTER_NEUTRAL_MODE = NeutralModeValue.Coast;

    /* Shooter Current Limits */
    public static final boolean SHOOTER_ENABLE_CURRENT_LIMIT = true;
    public static final int SHOOTER_SUPPLY_CURRENT_LIMIT = 40;
    public static final int SHOOTER_SUPPLY_CURRENT_THRESHOLD = 60;
    public static final double SHOOTER_SUPPLY_TIME_THRESHOLD = 0.1;

    /* Shooter PID Constants */
    public static final double SHOOTER_P = 2.25;
    public static final double SHOOTER_I = 0.02;
    public static final double SHOOTER_D = 0;
    public static final double SHOOTER_V = 0.125;

    /* Shooter Velocities - Rotations per Second */
    public static final double SHOOTER_SHOOT = 36;
    public static final double SHOOTER_SHOOT_REV = 38;
    public static final double SHOOTER_SHOOT_AUTO = 40;
    public static final double SHOOTER_FAST_SPEED = 70;
    public static final double SHOOTER_AMP = 0;
    public static final double SHOOTER_RESET = 0;
    public static final double SHOOTER_OUTTAKE = 70;

    //Intake

    /* Intake Inverts and Neutral Mode */
    public static final InvertedValue INTAKE_PIVOT_INVERTED = InvertedValue.CounterClockwise_Positive;
    public static final NeutralModeValue INTAKE_PIVOT_NEUTRAL_MODE = NeutralModeValue.Coast;

    /* Intake Pivot Current Limits */
    public static final boolean INTAKE_PIVOT_ENABLE_CURRENT_LIMIT = true;
    public static final int INTAKE_PIVOT_SUPPLY_CURRENT_LIMIT = 30;
    public static final int INTAKE_PIVOT_SUPPLY_CURRENT_THRESHOLD = 30;
    public static final double INTAKE_PIVOT_SUPPLY_TIME_THRESHOLD = 0.1;

    /* Intake Pivot PID Constants */
    public static final double INTAKE_PIVOT_P = 0.12; //0.1
    public static final double INTAKE_PIVOT_I = 0;
    public static final double INTAKE_PIVOT_D = 0.01;
    public static final double INTAKE_PIVOT_V = 0.1; //0.01

    /* Intake Pivot Setpoints */
    public static final double INTAKE_PIVOT_RESET = 2.5;
    public static final double INTAKE_PIVOT_INTAKE = 11.3; //24
    public static final int INTAKE_PIVOT_CLIMB = 10;
    public static final double INTAKE_PIVOT_FEED = 2; //1.75 for robot distance
    public static final double INTAKE_PIVOT_ROBOT_DISTANCE = 2.1;
    public static final double INTAKE_PIVOT_PODIUM = 2.7;

    public static final double stickDeadband = 0.15;
    
    //Swerve Constants

    public static final class Swerve {
        public static final int pigeonID = 1;

        public static final COTSTalonFXSwerveConstants chosenModule =  
        COTSTalonFXSwerveConstants.SDS.MK4i.Falcon500(COTSTalonFXSwerveConstants.SDS.MK4i.driveRatios.L2); //This must be tuned to specific robot

        /* Drivetrain Constants */
        public static final double trackWidth = Units.inchesToMeters(22.75); //This must be tuned to specific robot
        public static final double wheelBase = Units.inchesToMeters(22.75); //This must be tuned to specific robot
        public static final double wheelCircumference = chosenModule.wheelCircumference;

        /* Swerve Kinematics 
         * No need to ever change this unless you are not doing a traditional rectangular/square 4 module swerve */
         public static final SwerveDriveKinematics swerveKinematics = new SwerveDriveKinematics(
            new Translation2d(wheelBase / 2.0, trackWidth / 2.0),
            new Translation2d(wheelBase / 2.0, -trackWidth / 2.0),
            new Translation2d(-wheelBase / 2.0, trackWidth / 2.0),
            new Translation2d(-wheelBase / 2.0, -trackWidth / 2.0));

        /* Module Gear Ratios */
        public static final double driveGearRatio = chosenModule.driveGearRatio;
        public static final double angleGearRatio = chosenModule.angleGearRatio;

        /* Motor Inverts */
        public static final InvertedValue angleMotorInvert = chosenModule.angleMotorInvert;
        public static final InvertedValue driveMotorInvert = chosenModule.driveMotorInvert;

        /* Angle Encoder Invert */
        public static final SensorDirectionValue cancoderInvert = chosenModule.cancoderInvert;

        /* Swerve Current Limiting */
        public static final int angleCurrentLimit = 25; //default 25
        public static final int angleCurrentThreshold = 40; //default 40
        public static final double angleCurrentThresholdTime = 0.1;
        public static final boolean angleEnableCurrentLimit = true;

        public static final int driveCurrentLimit = 35; //default 35
        public static final int driveCurrentThreshold = 60; //default 60
        public static final double driveCurrentThresholdTime = 0.1;
        public static final boolean driveEnableCurrentLimit = true;

        /* These values are used by the drive falcon to ramp in open loop and closed loop driving.
         * We found a small open loop ramp (0.25) helps with tread wear, tipping, etc */
        public static final double openLoopRamp = 0.25;
        public static final double closedLoopRamp = 0.0;

        /* Angle Motor PID Values */
        public static final double angleKP = chosenModule.angleKP;
        public static final double angleKI = chosenModule.angleKI;
        public static final double angleKD = chosenModule.angleKD;

        /* Drive Motor PID Values */
        public static final double driveKP = 0.12; //This must be tuned to specific robot 0.12 default
        public static final double driveKI = 0.05;
        public static final double driveKD = 0.05;
        public static final double driveKF = 0.05;

        /* Heading PID Values */
        public static final double HeadingKP = 3;
        public static final double HeadingKI = 0.05;
        public static final double HeadingKD = 0.02;
        public static final double HeadingTolerence = 0;
 

        /* Drive Motor Characterization Values From SYSID */
        public static final double driveKS = 0.32; //This must be tuned to specific robot
        public static final double driveKV = 1.51;
        public static final double driveKA = 0.27;

        /* Swerve Profiling Values */
        /** Meters per Second */
        public static final double maxSpeed = 4.5; //This must be tuned to specific robot default 4.5
        /** Radians per Second */
        public static final double maxAngularVelocity = 4; //This must be tuned to specific robot default 10

        /* Neutral Modes */
        public static final NeutralModeValue angleNeutralMode = NeutralModeValue.Brake;
        public static final NeutralModeValue driveNeutralMode = NeutralModeValue.Brake;

        /* Module Specific Constants */
        /* Front Left Module - Module 0 */
        public static final class Mod0 { //his must be tuned to specific robot
            public static final int driveMotorID = 4;
            public static final int angleMotorID = 3;
            public static final int canCoderID = 2;
            public static final Rotation2d angleOffset = Rotation2d.fromDegrees(-63.23);
            public static final SwerveModuleConstants constants = 
                new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset);
        }

        /* Front Right Module - Module 1 */
        public static final class Mod1 { //This must be tuned to specific robot
            public static final int driveMotorID = 7;
            public static final int angleMotorID = 6;
            public static final int canCoderID = 5;
            public static final Rotation2d angleOffset = Rotation2d.fromDegrees(-43.33);
            public static final SwerveModuleConstants constants = 
                new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset);
        }
        
        /* Back Left Module - Module 2 */
        public static final class Mod2 { //This must be tuned to specific robot
            public static final int driveMotorID = 10;
            public static final int angleMotorID = 9;
            public static final int canCoderID = 8;
            public static final Rotation2d angleOffset = Rotation2d.fromDegrees(146.35);
            public static final SwerveModuleConstants constants = 
                new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset);
        }

        /* Back Right Module - Module 3 */
        public static final class Mod3 { //This must be tuned to specific robot
            public static final int driveMotorID = 13;
            public static final int angleMotorID = 12;
            public static final int canCoderID = 11;
            public static final Rotation2d angleOffset = Rotation2d.fromDegrees(-122.95);
            public static final SwerveModuleConstants constants = 
                new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset);
        }

        public static final HolonomicPathFollowerConfig pathFollowerConfig = new HolonomicPathFollowerConfig( // HolonomicPathFollowerConfig, this should likely live in your Constants class
        new PIDConstants(3, 0.05, 0.05), // Translation PID constants
        new PIDConstants(3, 0.05, 0), // Rotation PID constants
        4.5, // Max module speed, in m/s
        0.4, // Drive base radius in meters. Distance from robot center to furthest module.
        new ReplanningConfig() // Default path replanning config. See the API for the options here
        );

    }

    public static final class AutoConstants { //The below constants are used in the example auto, and must be tuned to specific robot
        public static final double kMaxSpeedMetersPerSecond = 3;
        public static final double kMaxAccelerationMetersPerSecondSquared = 3;
        public static final double kMaxAngularSpeedRadiansPerSecond = Math.PI;
        public static final double kMaxAngularSpeedRadiansPerSecondSquared = Math.PI;
    
        public static final double kPXController = 1;
        public static final double kPYController = 1;
        public static final double kPThetaController = 1;
    
        // Constraint for the motion profilied robot angle controller 
        public static final TrapezoidProfile.Constraints kThetaControllerConstraints =
            new TrapezoidProfile.Constraints(
                kMaxAngularSpeedRadiansPerSecond, kMaxAngularSpeedRadiansPerSecondSquared);
    } 
    

    

}

package org.usfirst.frc.team2485.robot.subsystems;

import org.usfirst.frc.team2485.robot.RobotMap;
import org.usfirst.frc.team2485.robot.commands.DriveWithControllers;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {

	public static final double THROTTLE_DEADBAND = 0.1;
	public static final double STEERING_DEADBAND = 0.1;
	
	private final double NORMAL_SPEED_RATING = 0.8, FAST_SPEED_RATING = 1.0, SLOW_SPEED_RATING = 0.6;
	
	private final double driveSpeed = NORMAL_SPEED_RATING;
	
    public Drivetrain(){
    	RobotMap.leftDriveEncoders.reset();
    	RobotMap.rightDriveEncoders.reset();
    }
    
	public void initDefaultCommand() {
    	new DriveWithControllers();
    }
	
	public void reset(){
		emergencyStop();
	}
	
	public void resetEncoders(){
		RobotMap.leftDriveEncoders.reset();
    	RobotMap.rightDriveEncoders.reset();
	}
	
	public void setLeftRight(double leftOutput, double rightOutput) {
		
		leftOutput *= driveSpeed;
		rightOutput *= driveSpeed;
		
		RobotMap.leftDrive.set(leftOutput);
		RobotMap.rightDrive.set(rightOutput);
	}
	
	public void emergencyStop() {
		RobotMap.leftDrive.set(0);
		RobotMap.rightDrive.set(0);
	}
	
}
  
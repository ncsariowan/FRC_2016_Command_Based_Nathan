package org.usfirst.frc.team2485.robot.subsystems;

import org.usfirst.frc.team2485.robot.RobotMap;
import org.usfirst.frc.team2485.robot.commands.DrivetrainWithControllers;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Takes outputs of Command and sets Wrappers
 *
 */
public class Drivetrain extends Subsystem {

	public static final double THROTTLE_DEADBAND = 0.1, STEERING_DEADBAND = 0.1;
	
	private final double NORMAL_SPEED_RATING = 0.8, FAST_SPEED_RATING = 1.0, SLOW_SPEED_RATING = 0.6;
	
	private final double driveSpeed = NORMAL_SPEED_RATING;
	
    public Drivetrain(){
    	RobotMap.leftDriveEncoders.reset();
    	RobotMap.rightDriveEncoders.reset();
    }
    
	public void initDefaultCommand() {
    	setDefaultCommand(new DrivetrainWithControllers());
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
		
		RobotMap.leftDriveWrapper.set(leftOutput);
		RobotMap.rightDriveWrapper.set(rightOutput);
	}
	
	public void emergencyStop() {
		RobotMap.leftDriveWrapper.set(0);
		RobotMap.rightDriveWrapper.set(0);
	}
	
}
  
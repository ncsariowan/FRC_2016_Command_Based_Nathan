
package org.usfirst.frc.team2485.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2485.robot.OI;
import org.usfirst.frc.team2485.robot.Robot;

import org.usfirst.frc.team2485.robot.RobotMap;
import org.usfirst.frc.team2485.robot.subsystems.Drivetrain;

/**
 *
 */
public class DriveWithControllers extends Command {
	
    public DriveWithControllers() {
        requires(RobotMap.drivetrain);
        setInterruptible(true);
        
    }
    
    protected void execute() {
    	
    	double steering = OI.XBOX.getRawAxis(4);
    	double throttle = -OI.XBOX.getRawAxis(1);
    	 
    	//TODO negative deadband
    	if (steering <= Drivetrain.STEERING_DEADBAND && steering >= -Drivetrain.STEERING_DEADBAND) {
    		steering = 0;
    	}
    	if (throttle <= Drivetrain.THROTTLE_DEADBAND && throttle >= -Drivetrain.THROTTLE_DEADBAND) {
    		throttle = 0;
    	}
    	
    	double leftPWM;
    	double rightPWM;
    	
    	if(!OI.XBOX.getRawButton(6)) { 
    		
	    	leftPWM = throttle * (1 + steering);
	    	rightPWM = throttle * (1 - steering);
	    	
    	} else {
    		
    		leftPWM = (1 + steering);
	    	rightPWM = (1 - steering);
	    	
    	}
    	
    	RobotMap.drivetrain.setLeftRight(leftPWM, rightPWM);
    }

    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}
}

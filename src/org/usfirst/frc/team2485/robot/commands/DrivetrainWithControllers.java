
package org.usfirst.frc.team2485.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2485.robot.OI;
import org.usfirst.frc.team2485.robot.Robot;

import org.usfirst.frc.team2485.robot.RobotMap;
import org.usfirst.frc.team2485.robot.subsystems.Drivetrain;

/**
 *
 */
public class DrivetrainWithControllers extends Command {
	
    public DrivetrainWithControllers() {
        requires(RobotMap.drivetrain);
        setInterruptible(true);
        
    }
    
    protected void execute() {
    	
    	double steering = OI.XBOX.getRawAxis(OI.XBOX_RJOYSTICK_PORT);
    	double throttle = -OI.XBOX.getRawAxis(OI.XBOX_LJOYSTICK_PORT);
    	 
    	if (steering <= Drivetrain.STEERING_DEADBAND && steering >= -Drivetrain.STEERING_DEADBAND) {
    		steering = 0;
    	}
    	if (throttle <= Drivetrain.THROTTLE_DEADBAND && throttle >= -Drivetrain.THROTTLE_DEADBAND) {
    		throttle = 0;
    	}
    	
    	double leftPWM;
    	double rightPWM;
    	
    	boolean quickTurn = OI.XBOX.getRawButton(OI.XBOX_RBUMPER_PORT);
    	
    	if(!quickTurn) {
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

package org.usfirst.frc.team2485.robot.commands;

import org.usfirst.frc.team2485.robot.OI;
import org.usfirst.frc.team2485.robot.RobotMap;
import org.usfirst.frc.team2485.robot.subsystems.IntakeArm;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeArmWithControllers extends Command {

    public IntakeArmWithControllers() {
    	requires(RobotMap.intakearm);
    	setInterruptible(false);
    }

    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	double pwmLeft = OI.XBOX.getRawAxis(OI.XBOX_LTRIGGER_PORT);
    	double pwmRight = OI.XBOX.getRawAxis(OI.XBOX_RTRIGGER_PORT);
    	
    	if (pwmLeft <= IntakeArm.ARM_DEADBAND && pwmLeft >= -IntakeArm.ARM_DEADBAND) {
    		pwmLeft = 0;
		}
    	if (pwmRight <= IntakeArm.ARM_DEADBAND && pwmRight >= -IntakeArm.ARM_DEADBAND) {
    		pwmRight = 0;
		}
    	
    	double pwm = pwmRight - pwmLeft;
    	
    	RobotMap.intakearm.armByManual(pwm);
    }

    // Make this return true when this Command no longer needs to run execute()
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
}

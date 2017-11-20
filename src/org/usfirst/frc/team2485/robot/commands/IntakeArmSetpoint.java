package org.usfirst.frc.team2485.robot.commands;

import org.usfirst.frc.team2485.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeArmSetpoint extends Command {

	private double setpoint;
	
    public IntakeArmSetpoint(double setpointInput) {
        requires(RobotMap.intakeArm);
        
        setpoint = setpointInput;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.intakeArm.armBySetpoint(setpoint);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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

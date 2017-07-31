package org.usfirst.frc.team2485.robot.commands;

import org.usfirst.frc.team2485.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeArmManual extends Command {
	
	private double pwm;

    public IntakeArmManual(double pwm) {
    	requires(RobotMap.intakearm);
    	setInterruptible(false);
    	this.pwm = pwm;
    }

    protected void initialize() {
    }

    protected void execute() {
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

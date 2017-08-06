package org.usfirst.frc.team2485.robot.commands;

import org.usfirst.frc.team2485.robot.RobotMap;
import org.usfirst.frc.team2485.robot.subsystems.IntakeRollers;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeRollersOn extends Command {

	public static boolean rollers;
    public IntakeRollersOn(boolean rollersInput) {
        requires(RobotMap.intakeRollers);
        setInterruptible(true);
        rollers = rollersInput;
    }

    protected void initialize() {
    }

    protected void execute() {
    	if (rollers) {
    		IntakeRollers.startRollers();
    	} else {
    		IntakeRollers.stopRollers();
    	}
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

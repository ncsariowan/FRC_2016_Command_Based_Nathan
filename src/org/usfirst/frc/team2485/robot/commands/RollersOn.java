package org.usfirst.frc.team2485.robot.commands;

import org.usfirst.frc.team2485.robot.RobotMap;
import org.usfirst.frc.team2485.robot.subsystems.IntakeRollers;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RollersOn extends Command {

	public static boolean rollersButton;
    public RollersOn(boolean rollers) {
        requires(RobotMap.intakeRollers);
        setInterruptible(true);
        rollersButton = rollers;
    }

    protected void initialize() {
    }

    protected void execute() {
    	IntakeRollers.startRollers(rollersButton);
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

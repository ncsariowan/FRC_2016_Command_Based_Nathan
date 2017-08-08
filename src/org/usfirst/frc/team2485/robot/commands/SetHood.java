package org.usfirst.frc.team2485.robot.commands;

import org.usfirst.frc.team2485.robot.RobotMap;
import org.usfirst.frc.team2485.robot.subsystems.Hood;
import org.usfirst.frc.team2485.robot.subsystems.Hood.HoodPosition;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetHood extends Command {

	HoodPosition position;
    public SetHood(HoodPosition positionInput) {
        requires(RobotMap.hood);
        setInterruptible(false);
        position = positionInput;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Hood.setHoodPosition(position);
    	
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

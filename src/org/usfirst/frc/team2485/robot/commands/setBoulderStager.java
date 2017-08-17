package org.usfirst.frc.team2485.robot.commands;

import org.usfirst.frc.team2485.robot.RobotMap;
import org.usfirst.frc.team2485.robot.subsystems.BoulderStager;
import org.usfirst.frc.team2485.robot.subsystems.BoulderStager.StagerPosition;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class setBoulderStager extends Command {
	
	StagerPosition position;
    public setBoulderStager(StagerPosition positionInput) {
        requires(RobotMap.boulderStager);
        setInterruptible(false);
        position = positionInput;
    }

    protected void initialize() {
    }

    protected void execute() {
    	BoulderStager.setPosition(position);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}

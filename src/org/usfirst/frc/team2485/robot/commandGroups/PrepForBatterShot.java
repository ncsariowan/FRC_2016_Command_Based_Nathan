package org.usfirst.frc.team2485.robot.commandGroups;

import org.usfirst.frc.team2485.robot.RobotMap;
import org.usfirst.frc.team2485.robot.commands.SetHood;
import org.usfirst.frc.team2485.robot.commands.SpinUpShooter;
import org.usfirst.frc.team2485.robot.subsystems.Hood.HoodPosition;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PrepForBatterShot extends CommandGroup {

    public PrepForBatterShot() {
    	requires(RobotMap.hood);
    	requires(RobotMap.shooter);
    	
    	addSequential(new SetHood(HoodPosition.HIGH_ANGLE));
    	addSequential(new SpinUpShooter());
    }
}

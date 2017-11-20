package org.usfirst.frc.team2485.robot.commandGroups;

import org.usfirst.frc.team2485.robot.RobotMap;
import org.usfirst.frc.team2485.robot.commands.IntakeRollersOff;
import org.usfirst.frc.team2485.robot.commands.setBoulderStager;
import org.usfirst.frc.team2485.robot.subsystems.BoulderStager.StagerPosition;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class StopIntakeBall extends CommandGroup {

    public StopIntakeBall() {
    	requires(RobotMap.boulderStager);
        requires(RobotMap.intakeRollers);
        
        addParallel(new setBoulderStager(StagerPosition.NEUTRAL));
        addSequential(new IntakeRollersOff());
    }
}

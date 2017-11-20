package org.usfirst.frc.team2485.robot.commandGroups;

import org.usfirst.frc.team2485.robot.RobotMap;
import org.usfirst.frc.team2485.robot.commands.IntakeArmSetpoint;
import org.usfirst.frc.team2485.robot.commands.IntakeRollersOn;
import org.usfirst.frc.team2485.robot.commands.setBoulderStager;
import org.usfirst.frc.team2485.robot.subsystems.BoulderStager.StagerPosition;
import org.usfirst.frc.team2485.robot.subsystems.IntakeArm;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeBall extends CommandGroup {

    public IntakeBall() {
       requires(RobotMap.boulderStager);
       requires(RobotMap.intakeRollers);
       requires(RobotMap.intakeArm);
       
       addParallel(new setBoulderStager(StagerPosition.INTAKE));
       addParallel(new IntakeArmSetpoint(IntakeArm.INTAKE_POSITION));
       addSequential(new IntakeRollersOn());
    }
}

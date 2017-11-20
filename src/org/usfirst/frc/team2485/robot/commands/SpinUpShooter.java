package org.usfirst.frc.team2485.robot.commands;

import org.usfirst.frc.team2485.robot.RobotMap;
import org.usfirst.frc.team2485.robot.utils.ConstantsIO;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * Sets the setpoint for the Shooter PID pulled from ConstantsIO
 */
public class SpinUpShooter extends InstantCommand {

    public SpinUpShooter() {
        requires(RobotMap.shooter);
    }

    protected void initialize() {
    	RobotMap.shooter.setSpeed(ConstantsIO.kShotRPS);
    }
    
    

}

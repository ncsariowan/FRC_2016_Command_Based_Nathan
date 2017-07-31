package org.usfirst.frc.team2485.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
    
	public static double RPS_LONG_SHOT = 95, RPS_BATTER_SHOT = 80;
	
	public static enum HoodPosition {
		LOW_ANGLE, HIGH_ANGLE, STOWED
	};
	
    public void initDefaultCommand() {

    }
}


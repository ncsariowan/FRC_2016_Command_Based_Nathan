package org.usfirst.frc.team2485.robot.subsystems;

import org.usfirst.frc.team2485.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Doesn't do anything yet...
 */
public class Shooter extends Subsystem {
    
	public static double RPS_LONG_SHOT = 95, RPS_BATTER_SHOT = 80;
	
    public void initDefaultCommand() {

    }
    
    public void setPWM(double pwm) {
    	RobotMap.shooterWrapper.set(pwm);
    }
    
    public void disableShooter() {
    	RobotMap.shooterWrapper.set(0);
    }
    
    public double getRate() {
		return RobotMap.shooterEncoder.getRate();

	}
}


package org.usfirst.frc.team2485.robot.subsystems;

import org.usfirst.frc.team2485.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;;

public class IntakeRollers extends Subsystem {
	
	public static boolean rollersOn = false;
	
	public IntakeRollers() { 
	}
	
	public void initDefaultCommand() {
		
	}
	
	public static void startRollers(boolean button) {
		
		if (rollersOn = false) {
			if (button == true) {
				RobotMap.rollersWrapper.set(0.5);
				RobotMap.lateralRollersWrapper.set(0.5);
				rollersOn = true;
			} else {
				RobotMap.rollersWrapper.set(0);
				RobotMap.lateralRollersWrapper.set(0);
				rollersOn = false;
			}
		}
	}
	
	public static void reverseRollers(boolean button) {
		if (rollersOn = false) {
			if (button == true) {
				RobotMap.rollersWrapper.set(-0.5);
				RobotMap.lateralRollersWrapper.set(-0.5);
				rollersOn = true;
			} else {
				RobotMap.rollersWrapper.set(0);
				RobotMap.lateralRollersWrapper.set(0);
				rollersOn = false;
			}
		}
	}
	
	public static void stopRollers() {
		RobotMap.rollersWrapper.set(0);
		RobotMap.lateralRollersWrapper.set(0);
		rollersOn = false;
	}
}

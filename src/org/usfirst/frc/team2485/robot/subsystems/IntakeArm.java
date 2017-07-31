package org.usfirst.frc.team2485.robot.subsystems;

import org.usfirst.frc.team2485.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeArm extends Subsystem {

	public static final double ARM_DEADBAND = 0.01;

	public static double FLOOR_POSITION = 0.122;

	public static double LOW_NO_INTAKE_POSITION = (FLOOR_POSITION + 0.06) % 1;
	public static double INTAKE_POSITION = (FLOOR_POSITION + 0.09) % 1;
	public static double PORTCULLIS_POSITION = (FLOOR_POSITION + 0.261) % 1;
	public static double FULL_UP_POSITION = (FLOOR_POSITION + 0.320) % 1;
	

	public void initDefaultCommand() {
	}
	
	public void armByManual(double pwm) {
		double armPosition = RobotMap.intakeArmEncoder.get();
		boolean disableDownwards = false;
		boolean disableUpwards = false;
		
		if (armPosition < FLOOR_POSITION + 0.1) {
			disableDownwards = true;
		} else if (armPosition > FULL_UP_POSITION - 0.1) {
			disableUpwards = true;
		}
		
		if (pwm < 0) {
			if(!disableDownwards) {
				RobotMap.intakeArmWrapper.set(pwm);
			} else {
				RobotMap.intakeArmWrapper.set(0);
			}
		} else {
			if(!disableUpwards) {
				RobotMap.intakeArmWrapper.set(pwm);
			} else {
				RobotMap.intakeArmWrapper.set(0);
			}
		}
		
	}
	
//	public void armBySetpoint() {
//		
//	}
	
	public double getPosition() {
		return RobotMap.intakeArmEncoder.get();
	}
	
}

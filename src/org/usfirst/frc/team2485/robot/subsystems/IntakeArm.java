package org.usfirst.frc.team2485.robot.subsystems;

import org.usfirst.frc.team2485.robot.RobotMap;
import org.usfirst.frc.team2485.robot.utils.ConstantsIO;
import org.usfirst.frc.team2485.robot.utils.InvertedAbsoluteEncoder;
import org.usfirst.frc.team2485.robot.utils.SpeedControllerWrapper;
import org.usfirst.frc.team2485.robot.utils.WarlordsPIDController;

import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeArm extends Subsystem {

	private SpeedControllerWrapper scWrapper;
	
	private InvertedAbsoluteEncoder absEncoder;
	
	private WarlordsPIDController armPID;
	
	public static final double ARM_DEADBAND = 0.01;

	public static double FLOOR_POSITION = 0.122;
	
	public static double SLOW_RATING = 0.1, NORMAL_RATING = 0.5;
	
	public static double LOW_NO_INTAKE_POSITION = (FLOOR_POSITION + 0.06) % 1;
	public static double INTAKE_POSITION = (FLOOR_POSITION + 0.09) % 1;
	public static double PORTCULLIS_POSITION = (FLOOR_POSITION + 0.261) % 1;
	public static double FULL_UP_POSITION = (FLOOR_POSITION + 0.320) % 1;
	
	public IntakeArm() {
		scWrapper = RobotMap.intakeArmWrapper;
		absEncoder = RobotMap.intakeArmEncoder;
		
		armPID = new WarlordsPIDController();
		armPID.setSources(absEncoder);
		armPID.setOutputs(scWrapper);
		armPID.setPID(ConstantsIO.kP_IntakeArm, ConstantsIO.kI_IntakeArm, ConstantsIO.kD_IntakeArm);
		armPID.setAbsoluteTolerance(ARM_DEADBAND);
		
		armPID.setInputRange(0.0, 1.0);
		armPID.setContinuous(true);
		
		armPID.setOutputRange(-0.22, 0.55);
	}

	public void initDefaultCommand() {
	}

	public void armByManual(double pwm) {
		double armPosition = RobotMap.intakeArmEncoder.get();
		boolean disableDownwards = false;
		boolean disableUpwards = false;
		
		//Limits arm position 
		if (armPosition < FLOOR_POSITION + 0.1) {
			disableDownwards = true;
		} else if (armPosition > FULL_UP_POSITION - 0.1) {
			disableUpwards = true;
		}
		
		pwm *= NORMAL_RATING; 
		
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
	
	public void armBySetpoint(double setpoint) {
		armPID.setSetpoint(setpoint);
	}
	
	public boolean isPIDEnabled() {
		return armPID.isEnabled();
	}
	
	public double getPosition() {
		return RobotMap.intakeArmEncoder.get();
	}
	
	public void updateConstants() {
		armPID.setPID(ConstantsIO.kP_IntakeArm, ConstantsIO.kI_IntakeArm,
				ConstantsIO.kD_IntakeArm);
	}

	public void reset() {
		armPID.disable();
	}
	
}

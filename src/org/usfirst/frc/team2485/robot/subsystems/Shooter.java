package org.usfirst.frc.team2485.robot.subsystems;

import org.usfirst.frc.team2485.robot.RobotMap;
import org.usfirst.frc.team2485.robot.utils.ConstantsIO;
import org.usfirst.frc.team2485.robot.utils.EncoderWrapperRateAndDistance;
import org.usfirst.frc.team2485.robot.utils.WarlordsPIDController;

import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {
    
	WarlordsPIDController shooterPID; 
	EncoderWrapperRateAndDistance shooterRate;
	public static double RPS_LONG_SHOT = 95, RPS_BATTER_SHOT = 80;
	
	public Shooter(){
		shooterPID = new WarlordsPIDController();
		shooterRate = new EncoderWrapperRateAndDistance(RobotMap.shooterEncoder, PIDSourceType.kRate);
		shooterPID.setSources(RobotMap.shooterEncoder);
		shooterPID.setOutputs(RobotMap.shooterWrapper);
		shooterPID.setPID(ConstantsIO.kP_Shooter, ConstantsIO.kI_Shooter, 
				ConstantsIO.kD_Shooter, ConstantsIO.kF_Shooter);
	}
	
    public void initDefaultCommand() {

    }
    
    public void setSpeed(double setpoint) {
    	
    	if (!shooterPID.isEnabled()) {
    		shooterPID.enable();
    	}
    	shooterPID.setSetpoint(setpoint);
    }
    
    public void setPWM(double pwm) {
    	if (shooterPID.isEnabled()) {
    		shooterPID.disable();
    	}
    	RobotMap.shooterWrapper.set(pwm);
    }
    
    public void disableShooter() {
    	if (shooterPID.isEnabled()) {
    		shooterPID.disable();
    	}
    	RobotMap.shooterWrapper.set(0);
    }
    
    public double getRate() {
		return RobotMap.shooterEncoder.getRate();

	}
    
    public void updateConstants() {
    	shooterPID.setPID(ConstantsIO.kP_Shooter, ConstantsIO.kI_Shooter, ConstantsIO.kD_Shooter, ConstantsIO.kF_Shooter);
    }
}


package org.usfirst.frc.team2485.robot.subsystems;

import org.usfirst.frc.team2485.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BoulderStager extends Subsystem {
    
	public enum StagerPosition {
		INTAKE, NEUTRAL, SHOOTING;
	}
	
	private static StagerPosition currentPosition;
	private static final StagerPosition defaultPosition = StagerPosition.NEUTRAL;
	
	public BoulderStager() {
		setPosition(defaultPosition);
	}
    public void initDefaultCommand() {
       
    }
    
    public static void setPosition(StagerPosition positionInput){
    	
    	if (positionInput == StagerPosition.INTAKE) {
    		RobotMap.boulderStagerSolenoid1.set(false);
    		RobotMap.boulderStagerSolenoid2.set(true);
    		
    	} else if (positionInput == StagerPosition.SHOOTING) {
    		RobotMap.boulderStagerSolenoid1.set(true);
    		RobotMap.boulderStagerSolenoid1.set(false);
    		
    	} else if (positionInput == StagerPosition.NEUTRAL){
    		RobotMap.boulderStagerSolenoid1.set(false);
    		RobotMap.boulderStagerSolenoid1.set(false);
    	}
    	
    	currentPosition = positionInput;
    }
    
    public StagerPosition getPosition() {
		return currentPosition;
	}

}


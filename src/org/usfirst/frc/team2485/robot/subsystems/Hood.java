package org.usfirst.frc.team2485.robot.subsystems;

import org.usfirst.frc.team2485.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Hood extends Subsystem {
    
	public static enum HoodPosition {
		LOW_ANGLE, HIGH_ANGLE, STOWED
	};
	
	private static final HoodPosition defaultHoodPosition = HoodPosition.HIGH_ANGLE;
	private static HoodPosition currentHoodPosition;
	
	public Hood() {
		setHoodPosition(defaultHoodPosition);
		currentHoodPosition = defaultHoodPosition;
	}
	
    public void initDefaultCommand() {
       
    }
    
    public static void setHoodPosition(HoodPosition newHoodPosition) {
    	
    	if (newHoodPosition == HoodPosition.LOW_ANGLE) {
    		
    		if (currentHoodPosition == HoodPosition.HIGH_ANGLE) {
				RobotMap.upperSolenoid.set(true); 
			
    		} else if (currentHoodPosition == HoodPosition.STOWED) {
				RobotMap.lowerSolenoid.set(false); 
				
				try {
					Thread.sleep(250);
					RobotMap.upperSolenoid.set(true);
				
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}		
			}
    		
    	} else if (newHoodPosition == HoodPosition.HIGH_ANGLE) {
    		
    		if (currentHoodPosition == HoodPosition.LOW_ANGLE) {
    			RobotMap.upperSolenoid.set(false);
    		
    		} else if (currentHoodPosition == HoodPosition.STOWED) {
    			RobotMap.lowerSolenoid.set(true);
    		}
    		
    	} else if (newHoodPosition == HoodPosition.STOWED) {
    		
    		if (currentHoodPosition == HoodPosition.LOW_ANGLE) {
    			RobotMap.upperSolenoid.set(false);
    			
    			try {
					Thread.sleep(250);
					RobotMap.lowerSolenoid.set(true);
				
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}	
    		} else if (currentHoodPosition == HoodPosition.LOW_ANGLE) {
    			RobotMap.lowerSolenoid.set(true);
    		}
    	}
    }
    
    public void resetHood() {
		setHoodPosition(defaultHoodPosition);
	}
    
    public HoodPosition getHoodPosition() {
		return currentHoodPosition;
	}

    public boolean isReadyToFire() {
    	if (currentHoodPosition != HoodPosition.STOWED) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    
 }


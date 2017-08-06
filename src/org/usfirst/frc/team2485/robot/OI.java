package org.usfirst.frc.team2485.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team2485.robot.commands.DrivetrainWithControllers;
import org.usfirst.frc.team2485.robot.commands.QuickTurn;
import org.usfirst.frc.team2485.robot.commands.IntakeRollersOn;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public static final int XBOX_A_PORT = 1;
	public static final int XBOX_B_PORT = 2;
	public static final int XBOX_X_PORT = 3;
	public static final int XBOX_Y_PORT = 4;
	public static final int XBOX_LBUMPER_PORT = 5;
	public static final int XBOX_RBUMPER_PORT = 6;  
	public static final int XBOX_START_PORT = 9;  
	public static final int XBOX_BACK_PORT = 10;  
	public static final int XBOX_XBOX_PORT = 11;  
	public static final int XBOX_UP_PORT = 12;  
	public static final int XBOX_DOWN_PORT = 13;  
	public static final int XBOX_LEFT_PORT = 14;
	public static final int XBOX_RIGHT_PORT = 15;
	
	public static final int XBOX_LJOYSTICK_PORT = 1;
	public static final int XBOX_LTRIGGER_PORT = 2;
	public static final int XBOX_RTRIGGER_PORT = 3;
	public static final int XBOX_RJOYSTICK_PORT = 4;
	    
	public static Joystick XBOX;
	public static Joystick Joystick;
	
	public static JoystickButton XBOX_X;
	public static JoystickButton XBOX_LBUMPER;
	public static JoystickButton XBOX_RBUMPER;
	
	public static void init() {
		
		XBOX = new Joystick(0);
		Joystick = new Joystick(1);
		
		XBOX_X = new JoystickButton(XBOX, 3);
		XBOX_LBUMPER = new JoystickButton(XBOX, 5);
		XBOX_RBUMPER = new JoystickButton(XBOX, 6);
		
		////FUNCTIONS
		
//		XBOX_LBUMPER.whenPressed(new QuickTurn(true));
//		XBOX_LBUMPER.whenPressed(new QuickTurn(false)); // ^ just as a reminder. See DriveWithControllers.	
		XBOX_RBUMPER.whenPressed(new IntakeRollersOn(true));
		XBOX_RBUMPER.whenReleased(new IntakeRollersOn(false));
		
	}
}


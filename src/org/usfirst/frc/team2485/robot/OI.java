package org.usfirst.frc.team2485.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team2485.robot.commands.DrivetrainWithControllers;
import org.usfirst.frc.team2485.robot.commands.SetHood;
import org.usfirst.frc.team2485.robot.commands.setBoulderStager;
import org.usfirst.frc.team2485.robot.subsystems.BoulderStager.StagerPosition;
import org.usfirst.frc.team2485.robot.subsystems.Hood.HoodPosition;
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
	
	public static final int XBOX_LXJOSYSTICK_PORT = 0;
	public static final int XBOX_LYJOYSTICK_PORT = 1;
	public static final int XBOX_LTRIGGER_PORT = 2;
	public static final int XBOX_RTRIGGER_PORT = 3;
	public static final int XBOX_RXJOYSTICK_PORT = 4;
	public static final int XBOX_RYJOYSTICK_PORT = 5;
	
	public static Joystick XBOX;
	public static Joystick Joystick;
	
	public static JoystickButton XBOX_UP;
	public static JoystickButton XBOX_DOWN;
	public static JoystickButton XBOX_LEFT;
	public static JoystickButton XBOX_RIGHT;
	public static JoystickButton XBOX_A;
	public static JoystickButton XBOX_B;
	public static JoystickButton XBOX_X;
	public static JoystickButton XBOX_Y;
	public static JoystickButton XBOX_LBUMPER;
	public static JoystickButton XBOX_RBUMPER;
	public static JoystickButton XBOX_XBOX;
	
	public static JoystickButton Joystick_1;
	public static JoystickButton Joystick_2;
	public static JoystickButton Joystick_3;
	public static JoystickButton Joystick_4;
	public static JoystickButton Joystick_5;
	public static JoystickButton Joystick_6;
	public static JoystickButton Joystick_7;
	public static JoystickButton Joystick_8;
	public static JoystickButton Joystick_9;
	public static JoystickButton Joystick_10;
	public static JoystickButton Joystick_11;
	public static JoystickButton Joystick_12;
	
	/**
	 *  For joysticks:4
	 *  
	 *  @see DrivetrainWithControllers
	 *  @see IntakeArmWithControllers
	 */
	public static void init() {
		
		XBOX = new Joystick(0);
		Joystick = new Joystick(1);
		
		XBOX_UP = new JoystickButton(XBOX, XBOX_UP_PORT);
		XBOX_DOWN = new JoystickButton(XBOX, XBOX_DOWN_PORT);
		XBOX_LEFT = new JoystickButton(XBOX, XBOX_LEFT_PORT);
		XBOX_RIGHT = new JoystickButton(XBOX, XBOX_RIGHT_PORT);
		
		XBOX_A = new JoystickButton(XBOX, XBOX_A_PORT);
		XBOX_B = new JoystickButton(XBOX, XBOX_B_PORT);
		XBOX_X = new JoystickButton(XBOX, XBOX_X_PORT);
		XBOX_Y = new JoystickButton(XBOX, XBOX_Y_PORT);
		
		XBOX_LBUMPER = new JoystickButton(XBOX, XBOX_LBUMPER_PORT);
		XBOX_RBUMPER = new JoystickButton(XBOX, XBOX_RBUMPER_PORT);
		
		XBOX_XBOX = new JoystickButton(XBOX, XBOX_XBOX_PORT);
		
		////FUNCTIONS
		
		Joystick_5.whenPressed(new SetHood(HoodPosition.HIGH_ANGLE));
		Joystick_2.whenPressed(new SetHood(HoodPosition.STOWED));
		Joystick_3.whenPressed(new SetHood(HoodPosition.LOW_ANGLE));
		
		Joystick_6.whenPressed(new setBoulderStager(StagerPosition.INTAKE));
		Joystick_4.whenPressed(new setBoulderStager(StagerPosition.NEUTRAL));
		Joystick_1.whenPressed(new setBoulderStager(StagerPosition.SHOOTING));
		
//		XBOX_RBUMPER.whenPressed(new QuickTurn(true));
//		XBOX_RBUMPER.whenPressed(new QuickTurn(false)); // just as a reminder. See DriveWithControllers.	

		XBOX_LBUMPER.whenPressed(new IntakeRollersOn(true));
		XBOX_LBUMPER.whenReleased(new IntakeRollersOn(false));
		
		 //make start and stop for different spin up shooters
		
	}
}


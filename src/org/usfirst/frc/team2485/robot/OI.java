package org.usfirst.frc.team2485.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team2485.robot.commandGroups.IntakeBall;
import org.usfirst.frc.team2485.robot.commandGroups.PrepForBatterShot;
import org.usfirst.frc.team2485.robot.commandGroups.PrepForLongShot;
import org.usfirst.frc.team2485.robot.commandGroups.StopIntakeBall;
import org.usfirst.frc.team2485.robot.commands.DrivetrainWithControllers;
import org.usfirst.frc.team2485.robot.commands.IntakeArmSetpoint;
import org.usfirst.frc.team2485.robot.commands.IntakeRollersOff;
import org.usfirst.frc.team2485.robot.commands.StopShooter;
import org.usfirst.frc.team2485.robot.commands.setBoulderStager;
import org.usfirst.frc.team2485.robot.subsystems.IntakeArm;
import org.usfirst.frc.team2485.robot.subsystems.BoulderStager.StagerPosition;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public static Joystick XBOX;
	public static Joystick JOYSTICK;
	
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
	
	public static final int JOYSTICK_X_PORT = 0;
	public static final int JOYSTICK_Y_PORT = 1;
	public static final int JOYSTICK_THROTTLE_PORT = 2;
	public static final int JOYSTICK_XHAT_PORT = 3;
	public static final int JOYSTICK_YHAT_PORT = 4;
	
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
	
	public static JoystickButton JOYSTICK_1;
	public static JoystickButton JOYSTICK_2;
	public static JoystickButton JOYSTICK_3;
	public static JoystickButton JOYSTICK_4;
	public static JoystickButton JOYSTICK_TRIGGER;
	public static JoystickButton JOYSTICK_6;
	public static JoystickButton JOYSTICK_7;
	public static JoystickButton JOYSTICK_8;
	public static JoystickButton JOYSTICK_9;
	public static JoystickButton JOYSTICK_10;
	public static JoystickButton JOYSTICK_11;
	public static JoystickButton JOYSTICK_12;
	
	/**
	 *  for joysticks:
	 *  @see DrivetrainWithControllers
	 *  @see IntakeArmWithControllers
	 */
	public static void init() {
		
		XBOX = new Joystick(0);
		JOYSTICK = new Joystick(1);
		
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
		
		JOYSTICK_1 = new JoystickButton(JOYSTICK, 1); 
		JOYSTICK_2 = new JoystickButton(JOYSTICK, 2);
		JOYSTICK_3 = new JoystickButton(JOYSTICK, 3);
		JOYSTICK_4 = new JoystickButton(JOYSTICK, 4);
		JOYSTICK_TRIGGER = new JoystickButton(JOYSTICK, 5);
		JOYSTICK_6 = new JoystickButton(JOYSTICK, 6);
		JOYSTICK_7 = new JoystickButton(JOYSTICK, 7);
		JOYSTICK_8 = new JoystickButton(JOYSTICK, 8);
		JOYSTICK_9 = new JoystickButton(JOYSTICK, 9);
		JOYSTICK_10 = new JoystickButton(JOYSTICK, 10);
		JOYSTICK_11 = new JoystickButton(JOYSTICK, 11);
		JOYSTICK_12 = new JoystickButton(JOYSTICK, 12);
		
		
		////FUNCTIONS
		XBOX_X.whenPressed(new IntakeBall());
		XBOX_Y.whenReleased(new StopIntakeBall());
		
//		XBOX_RBUMPER.whenPressed(new QuickTurn(true));
//		XBOX_RBUMPER.whenReleased(new QuickTurn(false)); // just as a reminder. @see DriveWithControllers.			
		
		JOYSTICK_1.whenPressed(new PrepForLongShot());
		JOYSTICK_2.whenPressed(new PrepForBatterShot());
		
		JOYSTICK_TRIGGER.whenPressed(new setBoulderStager(StagerPosition.SHOOTING));
		JOYSTICK_6.whenPressed(new StopShooter());
		
		JOYSTICK_7.whenPressed(new IntakeRollersOff());
		JOYSTICK_8.whenPressed(new IntakeArmSetpoint(IntakeArm.FLOOR_POSITION));
		JOYSTICK_9.whenPressed(new IntakeArmSetpoint(IntakeArm.LOW_NO_INTAKE_POSITION));
		JOYSTICK_10.whenPressed(new IntakeArmSetpoint(IntakeArm.INTAKE_POSITION));
		JOYSTICK_11.whenPressed(new IntakeArmSetpoint(IntakeArm.PORTCULLIS_POSITION));
		JOYSTICK_12.whenPressed(new IntakeArmSetpoint(IntakeArm.FULL_UP_POSITION));
	}
}


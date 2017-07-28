package org.usfirst.frc.team2485.robot;

import org.usfirst.frc.team2485.robot.subsystems.Drivetrain;
import org.usfirst.frc.team2485.robot.utils.SpeedControllerWrapper;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * From the WPILIB template: "The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around."
 * @author Nathan Sariowan
 */
public class RobotMap {

	//Drive Train
	public static Drivetrain drivetrain;
	
	public static VictorSP[] rightDriveVictorSPs;
	public static VictorSP[] leftDriveVictorSPs;
	
	public static Encoder leftDriveEncoders;
	public static Encoder rightDriveEncoders;
	
	public static SpeedControllerWrapper rightDrive;
	public static SpeedControllerWrapper leftDrive;
	
	public static void init() {
		
		//Drive train
		drivetrain = new Drivetrain();

		rightDriveVictorSPs = new VictorSP[] { new VictorSP(5), new VictorSP(6), new VictorSP(7) };
		leftDriveVictorSPs = new VictorSP[] { new VictorSP(2), new VictorSP(3), new VictorSP(4) };
		
		rightDrive = new SpeedControllerWrapper(rightDriveVictorSPs);
		leftDrive = new SpeedControllerWrapper(leftDriveVictorSPs);
		
		rightDriveEncoders = new Encoder(4, 5);
		leftDriveEncoders = new Encoder(2, 3);
		
	}
	
	
	
	
	
}

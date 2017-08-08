package org.usfirst.frc.team2485.robot;

import org.usfirst.frc.team2485.robot.subsystems.*;
import org.usfirst.frc.team2485.robot.utils.SpeedControllerWrapper;
import org.usfirst.frc.team2485.robot.utils.InvertedAbsoluteEncoder;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
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
	
	public static SpeedControllerWrapper rightDriveWrapper;
	public static SpeedControllerWrapper leftDriveWrapper;
	
	//IntakeRollers
	public static IntakeRollers intakeRollers;
	
	public static VictorSP rollersVictorSP; 
	public static VictorSP lateralRollersVictorSP;
	public static SpeedControllerWrapper rollersWrapper;
	public static SpeedControllerWrapper lateralRollersWrapper;
	
	//IntakeArm
	public static IntakeArm intakearm;
	public static VictorSP intakeArmVictorSP;
	public static SpeedControllerWrapper intakeArmWrapper;
	public static InvertedAbsoluteEncoder intakeArmEncoder;
	
	//Shooter
	public static Shooter shooter;
	public static CANTalon[] shooterCANs;
	public static SpeedControllerWrapper shooterWrapper;
	public static Encoder shooterEncoder;
	
	//Hood
	public static Hood hood;
	public static Solenoid lowerSolenoid; 
	public static Solenoid upperSolenoid;
	
	//BoulderStager
	public static BoulderStager boulderStager;
	public static Solenoid boulderStagerSolenoid1;
	public static Solenoid boulderStagerSolenoid2;
	
	public static void init() {
		
		//DriveTrain
		drivetrain = new Drivetrain();
		
			//port, port, SIM
		rightDriveVictorSPs = new VictorSP[] { new VictorSP(5), new VictorSP(6), new VictorSP(7) };
		leftDriveVictorSPs = new VictorSP[] { new VictorSP(2), new VictorSP(3), new VictorSP(4) };
		
		rightDriveWrapper = new SpeedControllerWrapper(rightDriveVictorSPs);
		leftDriveWrapper = new SpeedControllerWrapper(leftDriveVictorSPs);
		
		rightDriveEncoders = new Encoder(4, 5);
		leftDriveEncoders = new Encoder(2, 3);
		
		//IntakeRollers
		rollersVictorSP = new VictorSP(8);
		lateralRollersVictorSP = new VictorSP(9);
		
		rollersWrapper = new SpeedControllerWrapper(rollersVictorSP);
		lateralRollersWrapper = new SpeedControllerWrapper(lateralRollersVictorSP);
		lateralRollersVictorSP.setInverted(true);
		
		//IntakeArm
		intakearm = new IntakeArm();
		
		intakeArmVictorSP = new VictorSP(1);
		intakeArmWrapper = new SpeedControllerWrapper(intakeArmVictorSP);
		intakeArmEncoder = new InvertedAbsoluteEncoder(new AnalogPotentiometer(0));
		
		//Shooter
		shooterCANs = new CANTalon[] { new CANTalon(2), new CANTalon(3) };
		shooterWrapper = new SpeedControllerWrapper(shooterCANs);
		
		//Hood
		hood = new Hood();
		lowerSolenoid = new Solenoid(4);
		upperSolenoid = new Solenoid(5);
		
		//BoulderStager
		boulderStager = new BoulderStager();
		boulderStagerSolenoid1 = new Solenoid(6);
		boulderStagerSolenoid2 = new Solenoid(7);
		
		
		
	}
	
	
	
	
	
}

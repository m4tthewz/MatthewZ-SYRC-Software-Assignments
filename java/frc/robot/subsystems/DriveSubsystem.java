package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase{
    private final PWMSparkMax frontleft_motor = new PWMSparkMax(DriveConstants.DRIVE_FRONT_LEFT);
    private final PWMSparkMax frontright_motor = new PWMSparkMax(DriveConstants.DRIVE_FRONT_RIGHT);
    private final PWMSparkMax backleft_motor = new PWMSparkMax(DriveConstants.DRIVE_BACK_LEFT);
    private final PWMSparkMax backright_motor = new PWMSparkMax(DriveConstants.DRIVE_BACK_RIGHT);

    private final MotorControllerGroup driveLeft = new MotorControllerGroup(frontleft_motor, backleft_motor);
    private final MotorControllerGroup driveRight = new MotorControllerGroup(frontright_motor, backright_motor);
    private final DifferentialDrive driveRobot = new DifferentialDrive(driveLeft, driveRight);
    
    public void setMotor(double forwardSpeed, double turnSpeed) {
        driveRobot.arcadeDrive(forwardSpeed, turnSpeed);
      }
}

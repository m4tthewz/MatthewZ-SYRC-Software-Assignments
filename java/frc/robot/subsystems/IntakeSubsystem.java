package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase{
    private final PWMSparkMax m_intake = new PWMSparkMax(5);

    public IntakeSubsystem() {

    }


    @Override
    public void periodic() {
      m_intake.set(0.2); // stall
    }

    public void open() {
        m_intake.set(0.4);
    }
    
    public void close() {
        m_intake.set(-0.4);
    }

    public void off() {
        m_intake.stopMotor();
    }

    public void toggle() {
    }
}

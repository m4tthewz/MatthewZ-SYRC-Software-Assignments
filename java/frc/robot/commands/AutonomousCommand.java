package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class AutonomousCommand extends CommandBase{
    private final Timer m_timer = new Timer();
    private final DriveSubsystem driveSubsystem;
    private final IntakeSubsystem intakeSubsystem;

    public AutonomousCommand(DriveSubsystem driveSubsystem, IntakeSubsystem intakeSubsystem) {
        this.driveSubsystem = driveSubsystem;
        this.intakeSubsystem = intakeSubsystem;
        addRequirements(driveSubsystem, intakeSubsystem);
    }

    @Override
    public void initialize() {
        m_timer.reset();
        m_timer.start();
    }

    @Override
    public void execute() {
        if (m_timer.get() < 2.0) {
            new ArcadeDriveCommand(driveSubsystem, 0.5, 0.0).schedule();
            new IntakeCommand(intakeSubsystem, false).schedule();
        } else {
            new ArcadeDriveCommand(driveSubsystem, 0.0, 0.0).schedule();
            new IntakeCommand(intakeSubsystem, true).schedule();
        }
    }

    @Override
    public boolean isFinished() {
        // You may need to specify a condition for when the command should finish
        return false;
    }
}

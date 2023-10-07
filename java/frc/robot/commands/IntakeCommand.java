package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommand extends CommandBase {
    private final IntakeSubsystem intakeSubsystem;
    private final boolean open;

    public IntakeCommand(IntakeSubsystem intakeSubsystem, boolean open) {
        this.intakeSubsystem = intakeSubsystem;
        this.open = open;
        addRequirements(intakeSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        if (open) {
            intakeSubsystem.close();
        } else {
            intakeSubsystem.open();
        }
    }

    @Override
    public void end(boolean interrupted){

    }

    @Override
    public boolean isFinished() {
        return true;
    }
}

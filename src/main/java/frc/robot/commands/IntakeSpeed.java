// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.PWM;
import frc.robot.subsystems.Intake;

/** An example command that uses an example subsystem. */
public class IntakeSpeed extends CommandBase {
    private Intake intake;
    private Spark motors = new Spark(PWM.Intake_Motors); // motor controller

    /** Creates a new deploy. */
    public IntakeSpeed(Intake intake) {
        // Use addRequirements() here to declare subsystem dependencies.
        this.intake = intake;

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        motors.get();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        // if the motor controller has a value that is not zero, (meaning that the motors are going)
        // set the speed to 0, if the motor is not going, set speed to 0.5 -- ER

        if (motors.get() != 0) {              
            intake.intakeSpeed(0.0);
        } else {
            intake.intakeSpeed(0.5);
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}

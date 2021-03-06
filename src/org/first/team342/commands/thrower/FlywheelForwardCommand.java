/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.commands.thrower;

import edu.wpi.first.wpilibj.DriverStation;
import org.first.team342.commands.CommandBase;
import org.first.team342.subsystems.Thrower;

/**
 *
 * @author FIRST Team 342
 */
public class FlywheelForwardCommand extends CommandBase {
    private Thrower thrower;
    private double value;
    
    public FlywheelForwardCommand(double speed) {
        this.thrower = Thrower.getInstance();    
        requires(this.thrower);
        this.value = -speed;
    }
    
    public FlywheelForwardCommand() {
        this.value = -3000;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Spinning thrower forward");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println(value);
//        value = -3000;
        DriverStation driver = DriverStation.getInstance();
        this.value = driver.getAnalogIn(1) * -600;
        this.thrower.throwForward(value);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("Flywheel Forward Done.");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

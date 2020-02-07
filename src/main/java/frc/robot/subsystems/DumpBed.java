/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DumpBed extends SubsystemBase {
  /**
   * Creates a new DumpBed.
   */
  
   private final DoubleSolenoid s1 = new DoubleSolenoid(1, 0, 1);
  public DumpBed() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


public void dropBase() {
  s1.set(Value.kForward);
  System.out.println("The drop base is dropped to unload");
}

public void upBase() {
  s1.set(Value.kReverse);
  System.out.println("The drop base is put back to standard configuration");
}
}

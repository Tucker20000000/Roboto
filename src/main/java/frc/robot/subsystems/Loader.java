/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Convyer;

public class Loader extends SubsystemBase {
  /**
   * Creates a new Loader.
   */
  private final PWMVictorSPX main = new PWMVictorSPX(Convyer.convyerPort);
  public Loader() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  public void startLoader() {
    main.set(.25);
  }

  public void stopLoader() {
    main.set(0);
  }
}

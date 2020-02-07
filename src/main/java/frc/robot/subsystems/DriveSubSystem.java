/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstans;

public class DriveSubSystem extends SubsystemBase {
  /**
   * Creates a new DriveSubSysten.
   */
  //Motor Controller Declarations
  private final PWMVictorSPX lfM = new PWMVictorSPX(DriveConstans.lf);
  private final PWMVictorSPX lbM = new PWMVictorSPX(DriveConstans.lb);
  private final PWMVictorSPX rfM = new PWMVictorSPX(DriveConstans.rf);
  private final PWMVictorSPX rbM = new PWMVictorSPX(DriveConstans.rb);
  //SpeedControllerGroup Declaration
  private final SpeedControllerGroup leftSpeed = new SpeedControllerGroup(lfM, lbM);
  private final SpeedControllerGroup rightSpeed = new SpeedControllerGroup(rfM, rbM);
  //Differantal Drive for Tank Drive
  public final DifferentialDrive drive = new DifferentialDrive(leftSpeed, rightSpeed);


    public DriveSubSystem() {

    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void arcadeDrive(double move, double turn) {
    drive.arcadeDrive(move, turn);
  }
}

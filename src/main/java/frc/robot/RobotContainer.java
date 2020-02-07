/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.DriveSubSystem;
import frc.robot.subsystems.DumpBed;
import frc.robot.subsystems.Loader;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  /* Example Code
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);*/




  private final DriveSubSystem m_driveSubsystem = new DriveSubSystem();
  private final DumpBed m_dumpbed = new DumpBed();
  private final Loader m_loader = new Loader();

  SendableChooser<Command> m_chooser = new SendableChooser<>();
  


  private final Joystick driveStick = new Joystick(0);
  private final Joystick operatorStick = new Joystick(1);
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    m_driveSubsystem.setDefaultCommand(
      new RunCommand(() -> m_driveSubsystem.arcadeDrive(driveStick.getY(), driveStick.getX()), m_driveSubsystem)
    );


    




  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    new JoystickButton(operatorStick, 1).whenPressed(
    new InstantCommand(m_dumpbed::dropBase, m_dumpbed)
    ).whenReleased(m_dumpbed::upBase, m_dumpbed);
          
    new JoystickButton(operatorStick, 2).whenPressed(
    new InstantCommand(m_loader::startLoader, m_loader)
    ).whenReleased(m_loader::stopLoader, m_loader);
    
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_chooser.getSelected();
  }
}

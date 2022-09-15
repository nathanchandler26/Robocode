package IS;
import robocode.*;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * TopGun - a robot by Nate Chandler, Tanner Bacon, Scott Olson, Yun-Chen Lee, and Bryson Barrow
 */
public class TopGun extends Robot
{
	/**
	 * run: TopGun's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		setColors(Color.blue,Color.black,Color.red); // body,gun,radar

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			ahead(100);
			turnGunRight(360);
			back(80);
			turnGunRight(360);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		if (getEnergy() > 50) // If the energy level is over 50 do this
		{ 
			if (e.getDistance() < 50) // If enemy is less than 50 away do this
			{
				fire(1);
			}
			else if (e.getDistance() < 100) // If enemy is less than 100 away do this
			{
				fire(2);
			}
			else
			{
				fire(3); // If enemy is over 100 away do this
			}
		}
		else // If the energy level is below 50 do this
		{
			fire(5);
		}
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(50);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		turnRight(-e.getBearing()); // Turn when you hit a wall
		ahead(100); // Move forward again
	}	
	
	public void onWin(WinEvent e) { // Victory dance
		setAllColors(Color.white);
	}

}

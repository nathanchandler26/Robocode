package IS;
import robocode.*;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * TopGun - a robot by Nate Chandler, Tanner Bacon, Yun-Chen Lee, and Bryson Barrow
 */
public class TopGun extends Robot
{
	boolean forward = true;
	/**
	 * run: TopGun's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		setColors(Color.black,Color.darkGray,Color.blue); // body,gun,radar -- Set the colors

		// Robot main loop
		while(true) {
			setAdjustRadarForRobotTurn(true); // Keep the radar still when bot turns
            setAdjustGunForRobotTurn(true); // Keep the gun still when bot turns
            ahead(100);
            forward = true;
            turnGunRight(360);
            turnLeft(30);
            forward = false;
            turnGunRight(180);
            back(50);
            forward = false;
            turnGunRight(360);
            turnRight(30);
            forward = false;
            turnGunRight(180);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		double Energy =  e.getEnergy(); // Gets the energy of TopGun
		double Distance = e.getDistance(); // Gets the dstance of the scanned robot		

		if (Energy > 50) // If the energy level is over 50 do this
		{ 
			if (Distance < 50) // If enemy is less than 50 away do this
			{
				fire(5);
			}
			else if (Distance < 100) // If enemy is less than 100 away do this
			{
				fire(4);
			}
			else if (Distance < 150) // If enemy is less than 150 away do this
			{
				fire(3);
			}
			else if (Distance < 200) // If enemy is less than 200 away do this
			{
				fire(2);
			}	
			else
			{
				fire(1); // If enemy is over 200 away do this
			}
		}
		else if (Energy > 25) // If the energy level is < 50 and > 25
		{
			fire(1);
		}
		else // If energy is less than 25
		{
			fire(.5);
		}
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(20);
		forward = false;
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	 
	public void onHitWall(HitWallEvent e) {
		if (forward) { 	//if moving forward bounce off the wall
			back(75);
			turnRight(30);
			back(15);
			turnRight(60);
			forward = false;
		} else{
			ahead(75); //if moving backward bounch off the wall
			turnRight(30);
			ahead(15);
			turnRight(60);
			forward = true;
		}
	}	
	
	public void onWin(WinEvent e) { // Victory dance
		for (int i = 0; i < 50; i++) {
			turnRight(40);
			turnLeft(40);
			turnRight(20);
			turnLeft(20);
		}
	}

}

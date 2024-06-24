package IA1S2024;

import robocode.*;
import java.awt.*;
import java.awt.Color; // Esta línea está comentada en tu código, pero puede ser necesaria si el color no funciona correctamente.
import static robocode.util.Utils.normalRelativeAngleDegrees; // Para usar normalRelativeAngleDegrees


//import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Robot_g16 - a robot by (your name here)
 */
public class Robot_g16 extends AdvancedRobot {
    private boolean inEvasiveMode = false;
    int turnDirection = 1; // Clockwise or counterclockwise
    int turnCounter;

    public void run() {
	    setColors(Color.black, Color.black, Color.orange, Color.cyan, Color.cyan);
	
	    while (true) {
	        switchMode();
	        if (inEvasiveMode) {
	            performEvasiveManeuvers();
                turnGunRight(10);
	        } else {
	            turnGunRight(10); // Scans automatically
	        }
	    }
	}


    private void switchMode() {
        // Ejemplo simple de cambio de modo basado en la energía del robot
        if (getEnergy() < 25) {
            inEvasiveMode = true;
        } else {
            inEvasiveMode = false;
        }
    }

    private void performEvasiveManeuvers() {
        if (turnCounter % 64 == 0) {
            // Enderezar el giro, si hemos sido golpeados y estamos girando
            // Avanzar con una velocidad simple
            setAhead(100);
        }
        if (turnCounter % 64 == 32) {
            // Ir hacia atrás más rápido
            setBack(150);
        }
        turnCounter++;
        execute();
    }
    

    public void onScannedRobot(ScannedRobotEvent e) {
	        double absoluteBearing = getHeading() + e.getBearing();
	        double bearingFromGun = normalRelativeAngleDegrees(absoluteBearing - getGunHeading());
	
	        // Gira el arma y dispara si el enemigo está casi en línea recta con el arma
	        if (Math.abs(bearingFromGun) <= 3) {
	            turnGunRight(bearingFromGun);
	            if (getGunHeat() == 0) {
	                fire(Math.min(3 - Math.abs(bearingFromGun), getEnergy() - .1));
	            }
	        } else {
	            turnGunRight(bearingFromGun);
	        }
	        // Asegurarse de llamar a scan si el arma y el radar están alineados
	        if (bearingFromGun == 0) {
	            scan();
	        }
	}

    public void onHitByBullet(HitByBulletEvent e) {
            
            double bearing = e.getBearing();  // Obtén el ángulo de la bala
            if (bearing > 0) {
                setTurnLeft(90);
            } else {
                setTurnRight(90);
            }
            setBack(150);
    }

    public void onHitRobot(HitRobotEvent e) {
		if (e.getBearing() >= 0) {
			turnDirection = 1;
		} else {
			turnDirection = -1;
		}
		turnRight(e.getBearing());

		// Determine a shot that won't kill the robot...
		// We want to ram him instead for bonus points
		if (e.getEnergy() > 16) {
			fire(3);
		} else if (e.getEnergy() > 10) {
			fire(2);
		} else if (e.getEnergy() > 4) {
			fire(1);
		} else if (e.getEnergy() > 2) {
			fire(.5);
		} else if (e.getEnergy() > .4) {
			fire(.1);
		}
		ahead(40); // Ram him again!
	}

    public void onHitWall(HitWallEvent e) {
    // Retrocede si el ángulo de impacto es frontal, avanza si es trasero
    	if (Math.abs(e.getBearing()) < 90) {
	        back(100);  // Retrocede 100 unidades si golpeas la pared de frente
	    } else {
	        ahead(100);  // Avanza 100 unidades si golpeas la pared desde atrás
	    }
	}


    public void onWin(WinEvent e) {
        // Celebrar o realizar alguna acción al ganar
        turnRight(36000);  // Giro de celebración
    }

    public void onDeath(DeathEvent e) {
        // Realizar alguna acción al morir, como ajustar parámetros para la próxima ronda
        // Por ejemplo, podría registrar información para ajustar la estrategia
    }
}
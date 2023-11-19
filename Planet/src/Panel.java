import Entites.Earth;
import Entites.Planet;
import Entites.Player;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable{

    int FPS = 100;
    long TPF = 1000000000 / FPS;
    long last = System.nanoTime();
    long now = System.nanoTime();
    double GRAVITY_CONSTANT = 6.67 * Math.pow(10, -7);

    Earth earth;
    Planet[] planets;
    Player player;
    Earth earth2;

    Thread loop;

    Panel() {
        earth = new Earth(600, 500);
        earth2 = new Earth(600, 200);
        player = new Player();
        planets = new Planet[]{earth, earth2};

        loop = new Thread(this);
        loop.start();
    }

    @Override
    public void run() {
        while (true) {
            if (now - last >= TPF) {
                repaint();
                last = System.nanoTime();
            }
            now = System.nanoTime();
        }
    }

    public void paintComponent(Graphics g) {
        g.clearRect(player.x, player.y, player.w, player.h);

        getForce();
        player.update();
        for (Planet planet : planets) {
            g.fillArc(planet.x, planet.y, planet.radius, planet.radius, 0, 360);
        }
        g.fillRect(player.x, player.y, player.w, player.h);



    }

    public void getForce() {
        player.ForceX = 0;
        player.ForceY = 0;


        for (Planet planet : planets) {
            double angle = getAngle(getDirectionVector(planet, player));
            double distance = getDistance(planet, player);
            double FORCE = (GRAVITY_CONSTANT) * (planet.mass) * (player.mass) / (distance * distance);

            player.ForceX += (FORCE * Math.cos(angle));
            player.ForceY += (FORCE * Math.sin(angle));


        }
    }

    public  double getDistance(Planet planet, Player player) {
        double distance = Math.sqrt(Math.pow(planet.x - player.x, 2) + Math.pow(planet.y - player.y, 2));
        return Math.abs(distance);
    }

    public static double[] getDirectionVector(Planet planet, Player player) {
        double deltaX = planet.x - player.x;
        double deltaY = planet.y - player.y;

        // Normalize the direction vector (convert it to a unit vector)
        double magnitude = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        double[] directionVector = { deltaX / magnitude, deltaY / magnitude };

        return directionVector;
    }

    public static double getAngle(double[] directionVector) {
        return Math.atan2(directionVector[1], directionVector[0]);
    }

}

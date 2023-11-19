package Entites;

public class Player {
    public int x, y;
    public double ForceX;
    public double ForceY;
    public int mass;
    public int w;
    public int h;
    public double velX;
    public double velY;
    double AcclerationX;
    double AcclerationY;

    public Player() {
        x = 0; y = 0;
        mass = 100;
        ForceX = 0;
        ForceY = 0;
        w = 32; h = 32;
        velX = 0;
        velY = 0;
        AcclerationX = 0;
        AcclerationY = 0;
    }

    public void update() {
        AcclerationX += (ForceX / mass);
        AcclerationY += (ForceY / mass);

        velX += AcclerationX;
        velY += AcclerationY;

        x += velX;
        y += velY;
    }
}

package sample;

import javafx.scene.paint.Color;

public class Unit
{
    private int x;
    private int y;
    private Color color;

    Unit(int xaccess, int yaccess, Color c)
    {
        x = xaccess;
        y = yaccess;
        color = c;
    }

    int getX() { return x; }

    int getY() { return y; }

    Color getColor() { return color; }

    void setColor(Color co)
    {
        color = co;
    }

}
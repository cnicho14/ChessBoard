package edu.wvup.acottri9.chessboard;

import android.support.annotation.NonNull;

/**
 * A class to represent an absolute X and a Y position.
 * Created by aaron on 1/28/2018.
 */
public class Coordinate implements Comparable<Coordinate>
{
    private int x;
    private int y;

    /**
     * Instantiates a new Coordinate.
     */
    public Coordinate()
    {
        x = 0;
        y = 0;
    }

    /**
     * Instantiates a new Coordinate.
     *
     * @param x the x
     * @param y the y
     */
    public Coordinate(int x, int y)
    {
        setX(x);
        setY(y);
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public int getX()
    {
        return x;
    }

    /**
     * Sets x.
     *
     * @param x the x
     */
    public void setX(int x)
    {
        this.x = x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public int getY()
    {
        return y;
    }

    /**
     * Sets y.
     *
     * @param y the y
     */
    public void setY(int y)
    {
        this.y = y;
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof Coordinate))
        {
            return false;
        }
        else
        {
            Coordinate objCord = (Coordinate)obj;
            if(objCord.getX() == this.getX() && objCord.getY() == this.getY())
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }


    @Override
    public int compareTo(Coordinate o)
    {
        int differenceX = Math.abs(this.getX() - o.getX());
        int differenceY = Math.abs(this.getY() - o.getY());
        int trueDistance = (int)Math.sqrt(Math.pow(differenceX,2) + Math.pow(differenceY,2));
        return trueDistance;
    }
}

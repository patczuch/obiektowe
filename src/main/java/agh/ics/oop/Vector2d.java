package agh.ics.oop;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public String toString()
    {
        return "("+x+","+y+")";
    }

    public boolean precedes(Vector2d other)
    {
        return this.x <= other.x && this.y <= other.y;
    }

    public boolean follows(Vector2d other)
    {
        return this.x >= other.x && this.y >= other.y;
    }

    public Vector2d upperRight(Vector2d other)
    {
        return new Vector2d(Math.max(this.x,other.x),Math.max(this.y,other.y));
    }

    public Vector2d lowerLeft(Vector2d other)
    {
        return new Vector2d(Math.min(this.x,other.x),Math.min(this.y,other.y));
    }

    public Vector2d add(Vector2d other)
    {
        return new Vector2d(this.x+other.x,this.y+other.y);
    }

    public Vector2d subtract(Vector2d other)
    {
        return new Vector2d(this.x-other.x,this.y-other.y);
    }

    public boolean equals(Object other)
    {
        if (other == null || other.getClass() != Vector2d.class)
            return false;
        Vector2d otherV = (Vector2d) other;
        return this.x == otherV.x && this.y == otherV.y;
    }

    public Vector2d opposite()
    {
        return new Vector2d(-this.x,-this.y);
    }
}

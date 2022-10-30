package agh.ics.oop;

import java.util.Objects;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;
    public final IWorldMap map;
    public Animal(IWorldMap map)
    {
        this(map,new Vector2d(0,0));
    }

    public Animal(IWorldMap map, Vector2d initialPosition)
    {
        orientation = MapDirection.NORTH;
        position = initialPosition;
        this.map = map;
        if (!map.place(this))
            System.exit(1);
    }

    /*private static boolean isSafePosition(Vector2d position, int mapSize)
    {
        return position.follows(new Vector2d(0,0)) && position.precedes(new Vector2d(mapSize-1,mapSize-1));
    }*/

    public String toString()
    {
        return switch (orientation)
        {
            case EAST -> ">";
            case WEST -> "<";
            case NORTH -> "^";
            case SOUTH -> "v";
        };
    }

    public boolean move(MoveDirection direction)
    {
        switch (direction)
        {
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD -> {
                Vector2d newPosition = position.add(orientation.toUnitVector());
                if (!map.canMoveTo(newPosition))
                    return false;
                position = newPosition;
                map.place(this);
            }
            case BACKWARD -> {
                Vector2d newPosition = position.subtract(orientation.toUnitVector());
                if (!map.canMoveTo(newPosition))
                    return false;
                position = newPosition;
                map.place(this);
            }
        }
        return true;
    }

    /*public boolean equals(Object other)
    {
        if (other == null || other.getClass() != this.getClass())
            return false;
        Animal otherA = (Animal) other;
        return this.orientation.equals(otherA.orientation) && this.position.equals(otherA.position);
    }*/

    public int hashCode() {
        return Objects.hash(orientation, position);
    }

    public boolean isFacing(MapDirection orientation)
    {
        return this.orientation.equals(orientation);
    }
    public boolean isAt(Vector2d position)
    {
        return this.position.equals(position);
    }

    public Vector2d getPosition()
    {
        return position;
    }
}

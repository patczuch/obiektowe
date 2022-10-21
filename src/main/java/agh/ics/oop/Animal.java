package agh.ics.oop;

import java.util.Objects;


//Aby stworzyc mechanizm uniemożliwiający przebywanie dwóch zwierząt w jednym miejscu należałoby stworzyć klasę mapy która przechowuje informacje o wszystkich zwierzętach
//Należałoby podać tą mapę do konstruktora zwierzęcia
public class Animal {
    public MapDirection orientation;
    public Vector2d position;

    public Animal()
    {
        orientation = MapDirection.NORTH;
        position = new Vector2d(2,2);
    }

    public static boolean isSafePosition(Vector2d position, int mapSize)
    {
        return position.x >= 0 && position.y >= 0 && position.x < mapSize && position.y < mapSize;
    }

    public String toString()
    {
        return position.toString() + " " + orientation.toString();
    }

    public void move(MoveDirection direction)
    {
        switch (direction)
        {
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD -> {
                Vector2d newPosition = position.add(orientation.toUnitVector());
                if (isSafePosition(newPosition,5))
                    position = newPosition;
            }
            case BACKWARD -> {
                Vector2d newPosition = position.subtract(orientation.toUnitVector());
                if (isSafePosition(newPosition,5))
                    position = newPosition;
            }
        }
    }

    public boolean equals(Object other)
    {
        if (other == null || other.getClass() != this.getClass())
            return false;
        Animal otherA = (Animal) other;
        return this.orientation.equals(otherA.orientation) && this.position.equals(otherA.position);
    }

    public int hashCode() {
        return Objects.hash(orientation, position);
    }
}

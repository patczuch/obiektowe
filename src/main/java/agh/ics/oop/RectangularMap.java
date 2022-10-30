package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashMap;

public class RectangularMap implements IWorldMap{

    private final ArrayList<Animal> animals;
    private final Vector2d mapSize;

    public RectangularMap(int width, int height){
        animals = new ArrayList<Animal>();
        mapSize = new Vector2d(width,height);
    }

    public String toString()
    {
        return new MapVisualizer(this).draw(getLowerLeft(),getUpperRight());
    }

    public Vector2d getLowerLeft()
    {
        return new Vector2d(0,0);
    }

    public Vector2d getUpperRight()
    {
        return mapSize.subtract(new Vector2d(1,1));
    }

    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) && position.follows(getLowerLeft()) && position.precedes(getUpperRight());
    }

    public boolean place(Animal animal) {
        if (!canMoveTo(animal.getPosition()))
            return false;
        animals.add(animal);
        return true;
    }

    public boolean isOccupied(Vector2d position)
    {
        for (Animal a : animals)
            if (a.isAt(position))
                return true;
        return false;
    }

    public Object objectAt(Vector2d position) {
        for (Animal a : animals)
            if (a.isAt(position))
                return a;
        return null;
    }
}

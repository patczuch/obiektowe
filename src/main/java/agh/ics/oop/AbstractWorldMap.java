package agh.ics.oop;

import java.util.HashMap;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{

    protected final HashMap<Vector2d, Animal> animals;
    protected final MapVisualizer mapVisualizer;

    protected final MapBoundary boundary;
    protected AbstractWorldMap() {
        animals = new HashMap<>();
        mapVisualizer = new MapVisualizer(this);
        boundary = new MapBoundary();
    }

    @Override
    public boolean place(Animal animal) {
        if (!canMoveTo(animal.getPosition()))
            throw new IllegalArgumentException("Can't place animal at "+animal.getPosition());
        animals.put(animal.getPosition(),animal);
        boundary.place(animal.getPosition(),Animal.class);
        animal.addObserver(this);
        animal.addObserver(boundary);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition)
    {
        Animal a = animals.get(oldPosition);
        animals.remove(oldPosition);
        animals.put(newPosition,a);
    }

    public abstract Vector2d getLowerLeft();
    public abstract Vector2d getUpperRight();
    public String toString() {
        return mapVisualizer.draw(getLowerLeft(),getUpperRight());
    }
}

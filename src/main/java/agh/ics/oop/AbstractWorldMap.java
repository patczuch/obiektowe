package agh.ics.oop;

import java.util.ArrayList;

public abstract class AbstractWorldMap implements IWorldMap{

    protected final ArrayList<IMapElement> mapElements;
    protected final MapVisualizer mapVisualizer;

    protected AbstractWorldMap() {
        mapElements = new ArrayList<IMapElement>();
        mapVisualizer = new MapVisualizer(this);
    }

    @Override
    public boolean place(Animal animal) {
        if (!canMoveTo(animal.getPosition()))
            return false;
        mapElements.add(animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (IMapElement el : mapElements)
            if (el.getPosition().equals(position))
                return el;
        return null;
    }

    public abstract Vector2d getLowerLeft();
    public abstract Vector2d getUpperRight();
    public String toString() {
        return mapVisualizer.draw(getLowerLeft(),getUpperRight());
    }
}

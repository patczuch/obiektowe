package agh.ics.oop;

import java.util.Comparator;
import java.util.TreeSet;
import javafx.util.Pair;

public class MapBoundary implements IPositionChangeObserver{
    protected final TreeSet<Pair<Vector2d,Class<?>>> elementsSortedByX = new TreeSet<>(new Comparator<>() {
        @Override
        public int compare(Pair<Vector2d,Class<?>> p1, Pair<Vector2d,Class<?>> p2) {
            Vector2d v1 = p1.getKey();
            Vector2d v2 = p2.getKey();

            Class<?> c1 = p1.getValue();
            Class<?> c2 = p2.getValue();

            if (v1.x == v2.x && v1.y == v2.y)
                return c1.getName().compareTo(c2.getName());
            if (v1.x == v2.x)
                return v1.y - v2.y;
            return v1.x - v2.x;
        }
    });
    protected final TreeSet<Pair<Vector2d,Class<?>>> elementsSortedByY = new TreeSet<>(new Comparator<>() {
        @Override
        public int compare(Pair<Vector2d,Class<?>> p1, Pair<Vector2d,Class<?>> p2) {
            Vector2d v1 = p1.getKey();
            Vector2d v2 = p2.getKey();

            Class<?> c1 = p1.getValue();
            Class<?> c2 = p2.getValue();

            if (v1.x == v2.x && v1.y == v2.y)
                return c1.getName().compareTo(c2.getName());
            if (v1.y == v2.y)
                return v1.x - v2.x;
            return v1.y - v2.y;
        }
    });

    public void place(Vector2d v, Class<?> c)
    {
        elementsSortedByX.add(new Pair<>(v,c));
        elementsSortedByY.add(new Pair<>(v,c));
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        elementsSortedByX.remove(new Pair<>(oldPosition,Animal.class));
        elementsSortedByX.add(new Pair<>(newPosition,Animal.class));
        elementsSortedByY.remove(new Pair<>(oldPosition,Animal.class));
        elementsSortedByY.add(new Pair<>(newPosition,Animal.class));
    }

    @Override
    public String toString()
    {
        return elementsSortedByX + " " + elementsSortedByY;
    }
}

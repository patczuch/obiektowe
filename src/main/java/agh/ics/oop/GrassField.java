package agh.ics.oop;

import java.util.HashMap;
import java.util.Random;

public class GrassField extends AbstractWorldMap{

    Random rand;
    int grassAmount;
    protected final HashMap<Vector2d, Grass> grass;

    public GrassField(int grassAmount)
    {
        this(grassAmount,0);
    }

    public GrassField(int grassAmount, int seed)
    {
        this.grassAmount = grassAmount;
        this.rand = new Random(seed);

        grass = new HashMap<>();

        for (int i = 0; i<grassAmount; i++)
            createRandomGrass();
    }

    private void createRandomGrass()
    {
        int maxRand = (int) Math.sqrt(grassAmount * 10);
        Vector2d newPosition = new Vector2d(rand.nextInt(maxRand),rand.nextInt(maxRand));
        while (isOccupied(newPosition))
            newPosition = new Vector2d(rand.nextInt(maxRand),rand.nextInt(maxRand));
        Grass newGrass = new Grass(newPosition);
        grass.put(newPosition,newGrass);
        boundary.place(newPosition,Grass.class);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return objectAt(position) == null || objectAt(position).getClass() == Grass.class;
    }

    @Override
    public Vector2d getLowerLeft() {
        return  new Vector2d(
                boundary.elementsSortedByX.first().getKey().x,
                boundary.elementsSortedByY.first().getKey().y
        );
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (animals.containsKey(position))
            return animals.get(position);
        return grass.get(position);
    }

    @Override
    public Vector2d getUpperRight() {
        return  new Vector2d(
                boundary.elementsSortedByX.last().getKey().x,
                boundary.elementsSortedByY.last().getKey().y
        );
    }
}

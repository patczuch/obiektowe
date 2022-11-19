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
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return objectAt(position) == null || objectAt(position).getClass() == Grass.class;
    }

    @Override
    public Vector2d getLowerLeft() {
        if (animals.size() == 0 && grass.size() == 0)
            return new Vector2d(0,0);
        Vector2d lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (Vector2d pos : animals.keySet())
            lowerLeft = lowerLeft.lowerLeft(pos);
        for (Vector2d pos : grass.keySet())
            lowerLeft = lowerLeft.lowerLeft(pos);
        return lowerLeft;
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (animals.containsKey(position))
            return animals.get(position);
        return grass.get(position);
    }

    @Override
    public Vector2d getUpperRight() {
        if (animals.size() == 0 && grass.size() == 0)
            return new Vector2d(0,0);
        Vector2d upperRight = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);
        for (Vector2d pos : animals.keySet())
            upperRight = upperRight.upperRight(pos);
        for (Vector2d pos : grass.keySet())
            upperRight = upperRight.upperRight(pos);
        return upperRight;
    }
}

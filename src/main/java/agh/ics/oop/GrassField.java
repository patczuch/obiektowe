package agh.ics.oop;

import java.util.ArrayList;
import java.util.Random;

public class GrassField extends AbstractWorldMap{

    Random rand;
    int grassAmount;

    public GrassField(int grassAmount)
    {
        this(grassAmount,0);
    }

    public GrassField(int grassAmount, int seed)
    {
        this.grassAmount = grassAmount;
        this.rand = new Random(seed);

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
        mapElements.add(newGrass);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return objectAt(position) == null || objectAt(position).getClass() == Grass.class;
    }

    @Override
    public Vector2d getLowerLeft() {
        if (mapElements.size() == 0)
            return new Vector2d(0,0);
        Vector2d lowerLeft = mapElements.get(0).getPosition();
        for (IMapElement el : mapElements)
            lowerLeft = lowerLeft.lowerLeft(el.getPosition());
        return lowerLeft;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (int i = 0; i < mapElements.size(); i++)
            if (mapElements.get(i).getPosition().equals(position))
                if (mapElements.get(i).getClass() == Animal.class)
                    return mapElements.get(i);
                else
                {
                    for (int j = i+1; j < mapElements.size(); j++)
                        if (mapElements.get(j).getPosition().equals(position) && mapElements.get(j).getClass() == Animal.class)
                            return mapElements.get(j);
                    return mapElements.get(i);
                }
        return null;
    }

    @Override
    public Vector2d getUpperRight() {
        if (mapElements.size() == 0)
            return new Vector2d(0,0);
        Vector2d upperRight = mapElements.get(0).getPosition();
        for (IMapElement el : mapElements)
            upperRight = upperRight.upperRight(el.getPosition());
        return upperRight;
    }

}

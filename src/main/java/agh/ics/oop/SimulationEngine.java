package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine{
    private final MoveDirection[] moves;
    private final IWorldMap map;
    private final ArrayList<Animal> animals;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] initialPositions)
    {
        this.moves = moves;
        this.map = map;
        animals = new ArrayList<Animal>();
        for (Vector2d pos : initialPositions) {
            Animal a = new Animal(map, pos);
            animals.add(a);
        }
    }
    @Override
    public void run() {
        int i = 0;
        System.out.println(map);
        for (MoveDirection moveDir : moves)
        {
            animals.get(i).move(moveDir);
            i++;
            if (i >= animals.size())
                i = 0;
            System.out.println(map);
        }
    }
}

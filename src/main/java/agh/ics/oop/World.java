package agh.ics.oop;

public class World {
    public static void main(String[] args)
    {
        System.out.println("system wystartował");
        /*convertTab(args);

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));*/

        /*RectangularMap map = new RectangularMap(5,7);

        Animal animal = new Animal(map);
        MoveDirection[] moves = OptionsParser.parse(args);
        for (MoveDirection move: moves)
        {
            System.out.println(map.toString());
            animal.move(move);
        }*/

        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        IWorldMap map2 = new GrassField(10,1);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map2, positions);
        engine.run();

        System.out.println("system zakończył działanie");
    }

    public static void convertTab(String[] args)
    {
        Direction[] arr = new Direction[args.length];
        for (int i = 0; i < args.length; i++)
            arr[i] = convert(args[i]);
        run(arr);
    }

    public static Direction convert(String s)
    {
        return switch (s) {
            case "f" -> Direction.FORWARD;
            case "b" -> Direction.BACKWARDS;
            case "r" -> Direction.RIGHT;
            case "l" -> Direction.LEFT;
            default -> null;
        };
    }
    public static void run(Direction[] tab)
    {
        for (Direction d : tab)
            if (d != null)
                switch (d) {
                    case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                    case BACKWARDS -> System.out.println("Zwierzak idzie do tyłu");
                    case RIGHT -> System.out.println("Zwierzak skręca w prawo");
                    case LEFT -> System.out.println("Zwierzak skręca w lewo");
                }
    }
}

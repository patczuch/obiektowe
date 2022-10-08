package agh.ics.oop;

public class World {
    public static void main(String[] args)
    {
        System.out.println("system wystartował");
        Direction[] arr = new Direction[args.length];
        for (int i = 0; i < args.length; i++)
            arr[i] = convert(args[i]);
        run(arr);
        System.out.println("system zakończył działanie");
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

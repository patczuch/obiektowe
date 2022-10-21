import agh.ics.oop.MoveDirection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import agh.ics.oop.MapDirection;
import agh.ics.oop.Vector2d;
import agh.ics.oop.Animal;

public class AnimalTest {
    @Test
    public void toStringTest()
    {
        Animal a = new Animal();
        Assertions.assertEquals(a.toString(),"(2,2) Północ");
        a.move(MoveDirection.FORWARD);
        a.move(MoveDirection.RIGHT);
        Assertions.assertEquals(a.toString(),"(2,3) Wschód");
    }
    @Test
    public void moveTest()
    {
        Animal a = new Animal();
        a.move(MoveDirection.FORWARD);
        Assertions.assertEquals(a.position,new Vector2d(2,3));
        a.move(MoveDirection.LEFT);
        Assertions.assertEquals(a.position,new Vector2d(2,3));
        Assertions.assertEquals(a.orientation,MapDirection.WEST);
        a.move(MoveDirection.LEFT);
        Assertions.assertEquals(a.orientation,MapDirection.SOUTH);
        a.move(MoveDirection.LEFT);
        Assertions.assertEquals(a.orientation,MapDirection.EAST);
        a.move(MoveDirection.RIGHT);
        Assertions.assertEquals(a.orientation,MapDirection.SOUTH);
        a.move(MoveDirection.BACKWARD);
        Assertions.assertEquals(a.position,new Vector2d(2,4));
        a.move(MoveDirection.BACKWARD);
        Assertions.assertEquals(a.position,new Vector2d(2,4));
        a.move(MoveDirection.FORWARD);
        Assertions.assertEquals(a.position,new Vector2d(2,3));
        a.move(MoveDirection.FORWARD);
        Assertions.assertEquals(a.position,new Vector2d(2,2));
        a.move(MoveDirection.FORWARD);
        Assertions.assertEquals(a.position,new Vector2d(2,1));
        a.move(MoveDirection.FORWARD);
        Assertions.assertEquals(a.position,new Vector2d(2,0));
        a.move(MoveDirection.FORWARD);
        Assertions.assertEquals(a.position,new Vector2d(2,0));
        a.move(MoveDirection.RIGHT);
        Assertions.assertEquals(a.orientation,MapDirection.WEST);
        a.move(MoveDirection.FORWARD);
        Assertions.assertEquals(a.position,new Vector2d(1,0));
        a.move(MoveDirection.FORWARD);
        Assertions.assertEquals(a.position,new Vector2d(0,0));
        a.move(MoveDirection.FORWARD);
        Assertions.assertEquals(a.position,new Vector2d(0,0));
        a.move(MoveDirection.BACKWARD);
        Assertions.assertEquals(a.position,new Vector2d(1,0));
        a.move(MoveDirection.BACKWARD);
        Assertions.assertEquals(a.position,new Vector2d(2,0));
        a.move(MoveDirection.BACKWARD);
        Assertions.assertEquals(a.position,new Vector2d(3,0));
        a.move(MoveDirection.BACKWARD);
        Assertions.assertEquals(a.position,new Vector2d(4,0));
        a.move(MoveDirection.BACKWARD);
        Assertions.assertEquals(a.position,new Vector2d(4,0));
        a.move(MoveDirection.RIGHT);
        Assertions.assertEquals(a.orientation,MapDirection.NORTH);
        a.move(MoveDirection.RIGHT);
        Assertions.assertEquals(a.orientation,MapDirection.EAST);
        a.move(MoveDirection.RIGHT);
        Assertions.assertEquals(a.orientation,MapDirection.SOUTH);
    }
    @Test
    public void equalsTest()
    {
        Animal a = new Animal();
        Animal b = new Animal();
        Assertions.assertEquals(a,b);
        Assertions.assertNotEquals(a,null);
        a.move(MoveDirection.FORWARD);
        Assertions.assertNotEquals(a,b);
        a.move(MoveDirection.BACKWARD);
        a.move(MoveDirection.LEFT);
        Assertions.assertNotEquals(a,b);
    }
    @Test
    public void hashCodeTest()
    {
        Animal a = new Animal();
        Animal b = new Animal();
        Assertions.assertEquals(a.hashCode(),b.hashCode());
    }
}

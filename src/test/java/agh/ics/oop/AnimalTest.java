package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AnimalTest {
    IWorldMap map = new RectangularMap(5,5);
    Animal animal  = new Animal(map);
    @Test
    public void test(){
        String[] args={"f","f","b","l","l"};
        String[] args1={"fdsa","f","b","l","l"};

        assertThrows(IllegalArgumentException.class,
                () -> OptionsParser.parse(args1));

        MoveDirection[] directions= OptionsParser.parse(args);
        MoveDirection[] correct_directions={
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.LEFT,
                MoveDirection.LEFT};

        //pozycja i orientacja poczatkowa
        assertEquals(MapDirection.NORTH,animal.getOrientation());
        assertEquals(new Vector2d(2,2),animal.getPosition());

        //czy dane w tablicy lancuchow sa poprawnie interpretowane
        assertArrayEquals(correct_directions,directions);

        //czy przemieszca sie wlasciwie
        animal.move(MoveDirection.FORWARD);
        assertEquals(MapDirection.NORTH,animal.getOrientation());
        assertEquals(new Vector2d(2,3),animal.getPosition());
        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST,animal.getOrientation());
        assertEquals(new Vector2d(2,3),animal.getPosition());
        animal.move(MoveDirection.BACKWARD);
        assertEquals(MapDirection.EAST,animal.getOrientation());
        assertEquals(new Vector2d(1,3),animal.getPosition());
        animal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.NORTH,animal.getOrientation());
        assertEquals(new Vector2d(1,3),animal.getPosition());

        //czy nie wychodzi poza mape
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(1,4),animal.getPosition());
        for(int i=0;i<6;i++){animal.move(MoveDirection.BACKWARD);}
        assertEquals(new Vector2d(1,0),animal.getPosition());
        animal.move(MoveDirection.LEFT);
        for(int i=0;i<6;i++){animal.move(MoveDirection.BACKWARD);}
        assertEquals(new Vector2d(4,0),animal.getPosition());
        for(int i=0;i<6;i++){animal.move(MoveDirection.FORWARD);}
        assertEquals(new Vector2d(0,0),animal.getPosition());
    }
}

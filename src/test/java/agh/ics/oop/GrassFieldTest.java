package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    @Test
    void canMoveTo() {
        IWorldMap map = new GrassField(10);
        map.place(new Animal(map,new Vector2d(3,3)));
        assertFalse(map.canMoveTo(new Vector2d(3,3)));
        assertTrue(map.canMoveTo(new Vector2d(7,3)));
        assertTrue(map.canMoveTo(new Vector2d(3,-1)));
        assertTrue(map.canMoveTo(new Vector2d(11,11)));
    }

    @Test
    void place() {
        IWorldMap map = new GrassField(10);
        Animal animal1 = new Animal(map,new Vector2d(3,3));
        Animal animal2 = new Animal(map, new Vector2d(3,3));
        assertTrue(map.place(animal1));
        assertThrows(IllegalArgumentException.class,
                () -> map.place(animal2));
    }

    @Test
    void isOccupied() {
        IWorldMap map = new GrassField(10);
        map.place(new Animal(map,new Vector2d(3,3)));
        assertTrue(map.isOccupied(new Vector2d(3,3)));
        assertFalse(map.isOccupied(new Vector2d(1,1)));
    }

    @Test
    void objectAt() {
        IWorldMap map = new GrassField(10);
        Animal animal1 = new Animal(map,new Vector2d(3,3));
        Animal animal2 = new Animal(map, new Vector2d(2,4));
        map.place(animal1);
        map.place(animal2);
        assertEquals(animal1, map.objectAt(new Vector2d(3,3)));
        assertEquals(animal2, map.objectAt(new Vector2d(2,4)));
        assertNull(map.objectAt(new Vector2d(1, 1)));
    }

}
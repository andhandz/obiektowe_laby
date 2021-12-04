package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void canMoveTo() {
        RectangularMap map = new RectangularMap(5,5);
        map.place(new Animal(map,new Vector2d(3,3)));
        assertFalse(map.canMoveTo(new Vector2d(3,3)));
        assertFalse(map.canMoveTo(new Vector2d(7,3)));
        assertFalse(map.canMoveTo(new Vector2d(3,-1)));
        assertTrue(map.canMoveTo(new Vector2d(1,1)));
    }

    @Test
    void place() {
        RectangularMap map = new RectangularMap(5,5);
        Animal animal1 = new Animal(map,new Vector2d(3,3));
        Animal animal2 = new Animal(map, new Vector2d(3,3));
        assertTrue(map.place(animal1));
        assertThrows(IllegalArgumentException.class,
                () -> map.place(animal2));
    }

    @Test
    void isOccupied() {
        RectangularMap map = new RectangularMap(5,5);
        map.place(new Animal(map,new Vector2d(3,3)));
        assertTrue(map.isOccupied(new Vector2d(3,3)));
        assertFalse(map.isOccupied(new Vector2d(1,1)));
    }

    @Test
    void objectAt() {
        RectangularMap map = new RectangularMap(5,5);
        Animal animal1 = new Animal(map,new Vector2d(3,3));
        Animal animal2 = new Animal(map, new Vector2d(2,4));
        map.place(animal1);
        map.place(animal2);
        assertEquals(animal1, map.objectAt(new Vector2d(3,3)));
        assertEquals(animal2, map.objectAt(new Vector2d(2,4)));
        assertNull(map.objectAt(new Vector2d(1, 1)));
    }
}
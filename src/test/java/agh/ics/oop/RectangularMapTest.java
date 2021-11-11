package agh.ics.oop;

import org.junit.jupiter.api.Test;

import javax.lang.model.type.NullType;
import java.util.List;

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
        List<Animal> animals = map.getAnimals();
        assertEquals(0,animals.size());
        Animal animal1 = new Animal(map,new Vector2d(3,3));
        Animal animal2 = new Animal(map, new Vector2d(6,4));
        map.place(animal1);
        map.place(animal2);
        assertEquals(1,animals.size());
        map.place(animal1);
        assertEquals(1,animals.size());
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
        assertEquals(null, map.objectAt(new Vector2d(1,1)));
    }
}
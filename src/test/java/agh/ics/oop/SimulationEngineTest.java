package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationEngineTest {

    @Test
    void run() {
        MoveDirection[] directions = new OptionsParser().parse("r l f f f f r b f f f f f f".split(" "));
        IWorldMap map = new RectangularMap(20,15);
        Vector2d[] positions = {new Vector2d(3,10),new Vector2d(8,6)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        List<Animal> animals = ((RectangularMap) map).getAnimals();
        assertEquals(MapDirection.SOUTH,animals.get(0).getOrientation());
        assertEquals(MapDirection.WEST,animals.get(1).getOrientation());
        assertEquals(new Vector2d(5,7),animals.get(0).getPosition());
        assertEquals(new Vector2d(4,6),animals.get(1).getPosition());
    }
}
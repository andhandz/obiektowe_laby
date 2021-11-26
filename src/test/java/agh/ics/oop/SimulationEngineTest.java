package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SimulationEngineTest {

    @Test
    void run() {
        MoveDirection[] directions = new OptionsParser().parse("r l f f f f r b f f f f f f".split(" "));
        IWorldMap map = new RectangularMap(20,15);
        Vector2d[] positions = {new Vector2d(3,10),new Vector2d(8,6)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.objectAt(new Vector2d(3,10)) instanceof Animal);
        assertTrue(map.objectAt(new Vector2d(8,6)) instanceof Animal);
    }
}
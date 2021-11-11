package agh.ics.oop;
import java.util.List;

public class SimulationEngine implements IEngine{
    private final MoveDirection[] directions;
    private final IWorldMap map;
    private Vector2d[] positions;
    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions){
        this.directions=directions;
        this.map=map;
        this.positions=positions;
        for (Vector2d position: positions) {
            map.place(new Animal(map, position));
        }

    }

    @Override
    public void run() {
        RectangularMap map = (RectangularMap) this.map;
        List<Animal> animals = map.getAnimals();
        int length = animals.size();
        int i = 0;
        for(MoveDirection direction: directions){
            animals.get(i%length).move(direction);
            i++;
        }
    }
}

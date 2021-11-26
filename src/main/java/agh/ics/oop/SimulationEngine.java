package agh.ics.oop;
import java.util.ArrayList;

public class SimulationEngine implements IEngine{
    private final MoveDirection[] directions;
    private final ArrayList<Animal> animals;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions){
        this.directions=directions;
        this.animals = new ArrayList<>();
        for (Vector2d position: positions) {
            Animal animal = new Animal(map, position);
            map.place(animal);
            animals.add(animal);
        }
    }

    @Override
    public void run() {
        int length = animals.size();
        int i = 0;
        // jak to moge przerobic zeby dzialalo dla linkedhashmap animals?
        // mam na mysli przede wszystkim przejscie miedzy ostatnim zwierzakiem znow od pierwszego
        for(MoveDirection direction: directions){
            animals.get(i%length).move(direction);
            i++;
        }
    }
}

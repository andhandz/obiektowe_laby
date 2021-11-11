package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private int height;
    private int width;
    private Vector2d mini;
    private Vector2d maxi;
    private List<Animal> animals = new ArrayList<>();
    public RectangularMap(int height, int width){
        this.height=height;
        this.width=width;
        this.mini = new Vector2d(0,0);
        this.maxi = new Vector2d(width-1,height-1);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(position.follows(mini)
                && position.precedes(maxi)
        && !isOccupied(position)){
            return true;
        }
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        if(this.canMoveTo(animal.getPosition())){
        this.animals.add(animal);
            return true;}
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal animal: animals){
            if(animal.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal: animals){
            if(animal.getPosition().equals(position)){
                return animal;
            }
        }
        return null;
    }
    @Override
    public String toString(){
    MapVisualiser map= new MapVisualiser(this);
    return map.draw(mini,maxi);
    }

    public List<Animal> getAnimals() {
        return this.animals;
    }
}

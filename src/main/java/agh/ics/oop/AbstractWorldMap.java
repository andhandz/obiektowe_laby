package agh.ics.oop;

import java.util.ArrayList;


abstract class AbstractWorldMap implements IWorldMap {
    ArrayList<Animal> animals= new ArrayList<>();
    MapVisualiser map= new MapVisualiser(this);
    public boolean canMoveTo(Vector2d position) {
        return (!isOccupied(position));
    }

    public boolean place(Animal animal) {
        if(this.canMoveTo(animal.getPosition())){
            this.animals.add(animal);
            return true;}
        return false;
    }

    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.getPosition().equals(position)) {
                return animal;
            }
        }
        return null;
    }

    public ArrayList<Animal> getAnimals() {
        return this.animals;
    }
    public abstract Vector2d getMini();
    public abstract Vector2d getMaxi();

    public String toString(){
    return map.draw(getMini(),getMaxi());
    }
}

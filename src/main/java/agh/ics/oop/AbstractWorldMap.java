package agh.ics.oop;

import java.util.LinkedHashMap;


abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver{
    LinkedHashMap <Vector2d, Animal> animals = new LinkedHashMap<>();
    protected MapVisualiser map= new MapVisualiser(this);
    protected MapBoundary map_boundary = new MapBoundary(this);

    public boolean canMoveTo(Vector2d position) {
        return (!isOccupied(position));
    }

    public boolean place(Animal animal) {
        if(this.canMoveTo(animal.getPosition())){
           animals.put(animal.getPosition(),animal);
           animal.addObserver(this);
           animal.addObserver(map_boundary);
           map_boundary.add(animal);
            return true;}
        throw new IllegalArgumentException("cannot place object at " + animal.getPosition().toString());
    }

    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }


    public abstract Vector2d getLowerLeft();
    public abstract Vector2d getUpperRight();

    public String toString(){
    return map.draw(getLowerLeft(), getUpperRight());
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = animals.get(oldPosition);
        animals.remove(oldPosition,animal);
        animals.put(newPosition,animal);
    }
}

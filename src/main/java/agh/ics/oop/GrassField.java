package agh.ics.oop;
import java.lang.Math;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Random;


public class GrassField extends AbstractWorldMap {
    private final int count;
    private final int size;
    private final Vector2d lowerLeft;
    private final Vector2d upperRight;
    public final LinkedHashMap<Vector2d, Grass> grasses;

    public GrassField(int count) {
        this.grasses = new LinkedHashMap<>();
        this.count = count;
        this.size = (int) Math.sqrt(count * 10);
        this.lowerLeft = new Vector2d(0, 0);
        this.upperRight = new Vector2d(size, size);
        placeGrass();
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return super.canMoveTo(position) || objectAt(position) instanceof Grass;
    }

    public boolean canPlace(Vector2d position) {
        return position.follows(lowerLeft)
                && position.precedes(upperRight)
                && (!isOccupied(position) || objectAt(position) instanceof Animal);
    }

    public void placeGrass() {
        Random draw = new Random();
        for (int i = 0; i < count; i++) {
            Vector2d newPlace = new Vector2d((draw.nextInt(size)), (draw.nextInt(size)));
            if (canPlace(newPlace)) {
                this.grasses.put(newPlace, new Grass(newPlace));
            } else {
                i--;
            }
        }
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (super.objectAt(position) != null) {
            return super.objectAt(position);
        }
        else{
            return grasses.get(position);
            }
        }

    public Vector2d getLowerLeft() {
        Iterator<Vector2d> grassIterator = grasses.keySet().iterator();
        Iterator<Vector2d> animalIterator = animals.keySet().iterator();
        Vector2d start = grassIterator.next();
        Vector2d next = grassIterator.next();
        Vector2d currentLowerLeft = start.lowerLeft(next);

        while (grassIterator.hasNext()) {
            currentLowerLeft = currentLowerLeft.lowerLeft(grassIterator.next());
        }
        while (animalIterator.hasNext()) {
            currentLowerLeft = currentLowerLeft.lowerLeft(animalIterator.next());
        }
        return currentLowerLeft;
    }

    public Vector2d getUpperRight() {
        Iterator<Vector2d> grassIterator = grasses.keySet().iterator();
        Iterator<Vector2d> animalIterator = animals.keySet().iterator();
        Vector2d start = grassIterator.next();
        Vector2d next = grassIterator.next();
        Vector2d currentUpperRight = start.upperRight(next);

        while (grassIterator.hasNext()) {
            currentUpperRight = currentUpperRight.upperRight(grassIterator.next());
        }
        while (animalIterator.hasNext()) {
            currentUpperRight = currentUpperRight.upperRight(animalIterator.next());
        }
        return currentUpperRight;

    }
}

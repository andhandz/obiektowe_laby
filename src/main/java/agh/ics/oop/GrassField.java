package agh.ics.oop;
import java.lang.Math;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;


public class GrassField extends AbstractWorldMap {
    private final int count;
    private final Vector2d lowerLeft;
    private final Vector2d upperRight;
    public final LinkedHashMap<Vector2d, Grass> grasses;

    public GrassField(int count) {
        this.grasses = new LinkedHashMap<>();
        this.count = count;
        int size = (int) Math.sqrt(count * 10);
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

    private void openSpots(ArrayList <Vector2d> openSpots){
        for (int i= lowerLeft.x;i< upperRight.x;i++){
            for(int j = lowerLeft.y;j< upperRight.y;j++){
                Vector2d spot = new Vector2d(i,j);
                if(canPlace(spot)){
                    openSpots.add(spot);
                }
            }
        }
    }

    public void placeGrass() {
        ArrayList <Vector2d> openSpots = new ArrayList<>();
        openSpots(openSpots);
        Random draw = new Random();
        for (int i = 0; i < count; i++) {
            if(openSpots.size()==0) {
                throw new IllegalArgumentException("Map is too small!");
            }
            int rnd = draw.nextInt(openSpots.size());
            Vector2d newPlace = openSpots.get(rnd);
            openSpots.remove(rnd);
            this.grasses.put(newPlace, new Grass(newPlace));
            map_boundary.add(new Grass(newPlace));
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
        //i po co ja sie ostatnio tyle meczylem z tymi iteratorami oO
        return map_boundary.getLowerLeft();
    }

    public Vector2d getUpperRight() {
    return map_boundary.getUpperRight();

    }
}

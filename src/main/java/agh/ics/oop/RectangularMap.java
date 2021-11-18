package agh.ics.oop;


public class RectangularMap extends AbstractWorldMap {

    public Vector2d getLowerLeft() {
        return lowerLeft;
    }

    public Vector2d getUpperRight() {
        return upperRight;
    }

    private final Vector2d lowerLeft;
    private final Vector2d upperRight;

    public RectangularMap(int height, int width){
        this.lowerLeft = new Vector2d(0,0);
        this.upperRight = new Vector2d(width-1,height-1);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerLeft)
                && position.precedes(upperRight)
        && super.canMoveTo(position);
    }
}

package agh.ics.oop;


public class RectangularMap extends AbstractWorldMap {
    private int height;
    private int width;

    public Vector2d getMini() {
        return mini;
    }

    public Vector2d getMaxi() {
        return maxi;
    }

    private Vector2d mini;
    private Vector2d maxi;
    public RectangularMap(int height, int width){
        this.height=height;
        this.width=width;
        this.mini = new Vector2d(0,0);
        this.maxi = new Vector2d(width-1,height-1);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(mini)
                && position.precedes(maxi)
        && super.canMoveTo(position);
    }
}

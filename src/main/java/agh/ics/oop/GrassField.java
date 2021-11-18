package agh.ics.oop;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Random;

public class GrassField extends AbstractWorldMap{
    private final int count;
    private final int size;
    private final Vector2d lowerLeft;
    private final Vector2d upperRight;
    private final ArrayList<Grass> grasses = new ArrayList<>();

    public GrassField(int count){
        this.count=count;
        this.size=(int) Math.sqrt(count*10);
        this.lowerLeft=new Vector2d(0,0);
        this.upperRight =new Vector2d(size,size);
        placeGrass();
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return super.canMoveTo(position) || objectAt(position) instanceof Grass;
    }

    public boolean canPlace(Vector2d position){
        return position.follows(lowerLeft)
                && position.precedes(upperRight)
                && (!isOccupied(position) || objectAt(position) instanceof Animal);
    }

    public void placeGrass(){
        Random draw= new Random();
        for(int i=0; i<count;i++){
            Vector2d newPlace = new Vector2d((draw.nextInt(size)),(draw.nextInt(size)));
            if (canPlace(newPlace)){
                this.grasses.add(new Grass(newPlace));
            }
            else{
                i--;
            }
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Grass grass: grasses){
            if(grass.getPosition().equals(position)){
                return true;
            }
        }
        return super.isOccupied(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        if(super.objectAt(position)!=null){
            return super.objectAt(position);
        }
        for (Grass grass: grasses) {
            if (grass.getPosition().equals(position)) {
                return grass;
            }
        }
    return null;
    }

    public Vector2d getLowerLeft(){
        int x1=lowerLeft.x;
        int y1=lowerLeft.y;
        for(Animal animal: animals){
            x1=Math.min(x1,animal.getPosition().x);
            y1=Math.min(y1,animal.getPosition().y);
        }
        return new Vector2d(x1,y1);
    }

    public Vector2d getUpperRight(){
        int x1= upperRight.x;
        int y1= upperRight.y;
        for(Animal animal: animals){
            x1=Math.max(x1,animal.getPosition().x);
            y1=Math.max(y1,animal.getPosition().y);
        }
        return new Vector2d(x1,y1);
    }

    public void run(MoveDirection[] directions) {
        int length = animals.size();
        int i = 0;
        for(MoveDirection direction: directions){
            animals.get(i%length).move(direction);
            i++;
        }
    }
}

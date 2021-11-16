package agh.ics.oop;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Random;

public class GrassField extends AbstractWorldMap{
    private int count;
    private int size;
    private Vector2d mini;
    private Vector2d maxi;
    private ArrayList<Grass> grasses = new ArrayList<>();
    public GrassField(int count){
        this.count=count;
        this.size=(int) Math.sqrt(count*10);
        this.mini=new Vector2d(0,0);
        this.maxi=new Vector2d(size,size);
        placeGrass();
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return super.canMoveTo(position) || objectAt(position) instanceof Grass;
    }
    public boolean canPlace(Vector2d position){
        if(position.follows(mini)
                && position.precedes(maxi)
                && (!isOccupied(position) || objectAt(position) instanceof Animal)){
            return true;
        }
        return false;
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
    public Vector2d getMini(){
        int x1=mini.x;
        int y1=mini.y;
        for(Animal animal: animals){
            x1=Math.min(x1,animal.getPosition().x);
            y1=Math.min(y1,animal.getPosition().y);
        }
        return new Vector2d(x1,y1);
    }
    public Vector2d getMaxi(){
        int x1=maxi.x;
        int y1=maxi.y;
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

package agh.ics.oop;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {
    private final IWorldMap map;
    private final SortedSet<IMapElement> collection_x = new TreeSet<>(new Comparator_x());
    private final SortedSet<IMapElement> collection_y = new TreeSet<>(new Comparator_y());

    public MapBoundary(IWorldMap map){
    this.map=map;
    }

    public Vector2d getUpperRight(){
        return collection_x.last().getPosition().upperRight(collection_y.last().getPosition());
    }
    public Vector2d getLowerLeft(){
        return collection_x.first().getPosition().lowerLeft(collection_y.first().getPosition());
    }

    public void add(IMapElement element){
        collection_x.add(element);
        collection_y.add(element);
    }

    public void remove(IMapElement element){
        collection_x.remove(element);
        collection_y.remove(element);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        IMapElement element = (IMapElement) map.objectAt(newPosition);
        remove(element);
        add(element);
    }

}

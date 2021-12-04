package agh.ics.oop;

import java.util.Comparator;

public class Comparator_x implements Comparator<IMapElement> {

    @Override
    public int compare(IMapElement lhs, IMapElement rhs) {
        if(lhs.getPosition().x != rhs.getPosition().x){
            return lhs.getPosition().x - rhs.getPosition().x;
        }
        else if(lhs.getPosition().y != rhs.getPosition().y){
            return lhs.getPosition().y - rhs.getPosition().y;
        }
        return 0;
    }
}


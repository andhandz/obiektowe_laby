package agh.ics.oop;

public class Animal {
    private MapDirection orientation=MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    public MapDirection getOrientation() {
        return orientation;
    }

    public void setOrientation(MapDirection orientation) {
        this.orientation = orientation;
    }

    public Vector2d getPosition() {
        return position;
    }

    public void setPosition(Vector2d position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "orientation=" + orientation +
                ", position=" + position +
                '}';
    }
    public void move(MoveDirection direction){
        Vector2d v1= new Vector2d(1,0);
        Vector2d v2= new Vector2d(0,1);
        switch(direction){
            case RIGHT -> orientation=orientation.next();
            case LEFT -> orientation=orientation.previous();
            case FORWARD -> {
                switch (orientation) {
                    case NORTH -> {if(position.y<4){ position = position.add(v2);}}
                    case EAST -> {if(position.x<4){ position = position.add(v1);}}
                    case WEST -> {if(position.x>0){ position = position.subtract(v1);}}
                    case SOUTH -> {if(position.y>0){ position = position.subtract(v2);}}
                }
            }
            case BACKWARD ->  {
                switch(orientation){
                    case NORTH -> {if(position.y>0){ position = position.subtract(v2);}}
                    case EAST -> {if(position.x>0){ position = position.subtract(v1);}}
                    case WEST -> {if(position.x<4){ position = position.add(v1);}}
                    case SOUTH -> {if(position.y<4){ position = position.add(v2);}}
                }
            }
        }
    }
}

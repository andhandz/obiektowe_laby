package agh.ics.oop;

public interface IMapElement {
    /**
     *
     * @return current position of the object
     */
    Vector2d getPosition();
    /**
     *
     * @return symbol of Animal/Grass on the map
     */
    String toString();
    /**
     *
     * @return true when object on spot can stay with this object
     */
    Boolean noCollision();
}

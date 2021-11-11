package agh.ics.oop;

    public class Animal {
        private MapDirection orientation;
        private Vector2d position;
        private IWorldMap map;
        public Animal(){
            orientation = MapDirection.NORTH;
            position = new Vector2d(2, 2);
        }
        public MapDirection getOrientation() {
            return orientation;
        }

        public Vector2d getPosition() {
            return position;
        }

        @Override
        public String toString() {
            return switch (orientation) {
                case NORTH -> "^";
                case EAST -> ">";
                case SOUTH -> "v";
                case WEST -> "<";
            };
        }

        public Animal(IWorldMap map) {
            this.map = map;
            this.orientation = MapDirection.NORTH;
            this.position = new Vector2d(2, 2);
        }

        public Animal(IWorldMap map, Vector2d initialPosition) {
            this(map);
            this.position = initialPosition;
            this.orientation = MapDirection.NORTH;
        }

        public void move(MoveDirection direction) {
            switch (direction) {
                case RIGHT -> orientation = orientation.next();
                case LEFT -> orientation = orientation.previous();
                case FORWARD -> {
                    Vector2d new1 = this.position.add(this.orientation.toUnitVector());
                    if (map.canMoveTo(new1)) {
                        position = new1;
                    }
                }
                case BACKWARD -> {
                    Vector2d new1 = this.position.subtract(this.orientation.toUnitVector());
                    if (map.canMoveTo(new1)) {
                        position = new1;
                    }
                }
            }
        }
    }


package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        MoveDirection[] directions = new OptionsParser().parse(args);
        GrassField testGrass= new GrassField(10);
        testGrass.place(new Animal(testGrass,new Vector2d(2,2)));
        testGrass.place(new Animal(testGrass,new Vector2d(3,4)));
        testGrass.run(directions);
        System.out.println(testGrass);
    }

}

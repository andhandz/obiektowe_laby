package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println(animal);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        System.out.println(animal);
        OptionsParser instruction = new OptionsParser();
        for (int i = 0; i < instruction.parse(args).length; i++) {
            animal.move(instruction.parse(args)[i]);
        }
        System.out.println(animal);
    }

}

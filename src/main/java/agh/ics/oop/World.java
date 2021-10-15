package agh.ics.oop;

public class World {
    public static void main(String[] args){
        System.out.println("Starting...");
        Direction[] dir = new Direction[args.length];
        for(int i=0;i<args.length;i++){
            if (args[i].equals("f")){dir[i]=Direction.FORWARD;}
            else if (args[i].equals("b")){dir[i]=Direction.BACKWARD;}
            else if (args[i].equals("r")){dir[i]=Direction.RIGHT;}
            else if (args[i].equals("l")){dir[i]=Direction.LEFT;}
        }
        run(dir);
        System.out.println("Finishing...");
    }
    public static void run(Direction[] args){
        for(Direction arg: args){
            switch(arg){
                case FORWARD: System.out.println("Animal goes forward");break;
                case BACKWARD: System.out.println("Animal goes backward");break;
                case RIGHT: System.out.println("Animal turns right");break;
                case LEFT: System.out.println("Animal turns left");break;
            }
        }
    }
}

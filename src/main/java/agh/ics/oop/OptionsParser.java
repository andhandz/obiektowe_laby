package agh.ics.oop;

public class OptionsParser {
    public static MoveDirection[] parse(String[] arr){
        MoveDirection[] result= new MoveDirection[arr.length];
        int j=0;
        for (String s : arr) {
            switch (s) {
                case "f", "forward" -> {
                    result[j] = MoveDirection.FORWARD;
                    j++;
                }
                case "b", "backward" -> {
                    result[j] = MoveDirection.BACKWARD;
                    j++;
                }
                case "l", "left" -> {
                    result[j] = MoveDirection.LEFT;
                    j++;
                }
                case "r", "right" -> {
                    result[j] = MoveDirection.RIGHT;
                    j++;
                }
                default -> throw new IllegalArgumentException(s + " is not legal move specification");
            }

        }
        MoveDirection[] final_result=new MoveDirection[j];
        System.arraycopy(result, 0, final_result, 0, j);
        return final_result;
    }
}

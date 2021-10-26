package agh.ics.oop;

public class OptionsParser {
    public MoveDirection[] parse(String[] arr){
        MoveDirection[] result= new MoveDirection[arr.length];
        int j=0;
        for(int i=0;i< arr.length;i++){
            if(arr[i].equals("f") || arr[i].equals("forward")){
                result[j]=MoveDirection.FORWARD;
                j++;
            }
            else if(arr[i].equals("b") || arr[i].equals("backward")){
                result[j]=MoveDirection.BACKWARD;
                j++;
            }
            else if(arr[i].equals("l") || arr[i].equals("left")){
                result[j]=MoveDirection.LEFT;
                j++;
            }
            else if(arr[i].equals("r") || arr[i].equals("right")){
                result[j]=MoveDirection.RIGHT;
                j++;
            }

        }
        MoveDirection[] final_result=new MoveDirection[j];
        for(int i=0;i<j;i++){
            final_result[i]=result[i];
        }
        return final_result;
    }
}

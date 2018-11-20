package TM;

import java.util.List;
import java.util.ArrayList;

public class Tape {

    private int headPosition;
    List<Character> tape = new ArrayList<Character>();

    public Tape(String str){

        for(char c : str.toCharArray()){
            tape.add(c);
        }

        headPosition = 0;
    }

    public void write(Character cha){
        tape.set(headPosition, cha);
    }

    public Character read(){
        return tape.get(headPosition);
    }

    public void move(Character direction){

        switch (direction){
            case 'R':
                headPosition ++;
                break;

            case 'L':
                if(headPosition == 0){
                    break;
                } else {
                    headPosition--;
                    break;
                }

            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString(){
        return tape.toString();
    }
}

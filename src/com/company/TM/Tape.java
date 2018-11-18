package com.company.TM;

import java.util.ArrayList;

public class Tape {

    private ArrayList<Character> tape = new ArrayList<>();
    private int headPosition;

    public Tape(ArrayList<Character> tape){
        this.tape = tape;
        this.headPosition = 0;
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
                if(headPosition >= 0){
                    break;
                } else {
                    headPosition--;
                    break;
                }

            default:
                throw new IllegalArgumentException();
        }
    }
}

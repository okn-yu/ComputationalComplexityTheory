package com.company.state;

import java.util.HashMap;

public class State {

    private String name;
    public HashMap<Character, State>  delta = new HashMap<Character, State>();
    private boolean isAcceptState;
    public boolean isInitState;
    public State(String name, boolean isInitState, boolean isAcceptState) {

        if (name.charAt(0) == 'q') {
            this.name = name;
            this.isInitState = isInitState;
            this.isAcceptState = isAcceptState;
        } else {
            throw new NullPointerException("stateName[0] is not q!");
        }
    }

    public boolean transitState(String currentString){

        if(currentString.isEmpty()){
            return isAcceptState;
        }else {
            Character c = currentString.charAt(0);
            String nextString = currentString.substring(1);
            return delta.get(c).transitState(nextString);
        }
    }

    public void show() {
        System.out.print(name);
    }

}

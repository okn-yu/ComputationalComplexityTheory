package com.company.state;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

import com.company.alphabet.Alphabet;

public class State implements Cloneable{

    public String name;
    public boolean isAcceptState;
    public boolean isInitState;
    public String currentString;

    public HashMap<Character, State> delta = new HashMap<Character, State>();
    public HashMap<Character, StateSet> deltas = new HashMap<Character, StateSet>();

    public State(String name, boolean isInitState, boolean isAcceptState) {

        if (name.charAt(0) == 'q') {
            this.name = name;
            this.isInitState = isInitState;
            this.isAcceptState = isAcceptState;
        } else {
            throw new NameException(name);
        }
    }

    public State clone(String currentString){

        State clonedState = null;

        try {
            clonedState = (State) super.clone();
            clonedState.name = name;
            clonedState.isAcceptState = isAcceptState;
            clonedState.isInitState = isInitState;
            clonedState.currentString = currentString;
            clonedState.deltas = deltas;

        }catch(Exception e){
            e.printStackTrace();
        }
        return clonedState;

    }

    public boolean transitState(String currentString) throws NextStateException {

        if (currentString.isEmpty()) {
            return isAcceptState;
        }

        Character c = currentString.charAt(0);
        String nextString = currentString.substring(1);

        if (Objects.isNull(delta.get(c))) {
            throw new NextStateException("Current State is " + name + ". " + "Next Character is " + c.toString() + ". ");
        } else {
            return delta.get(c).transitState(nextString);
        }
    }

    public StateSet nextStateSet() {

        StateSet nextStateSet = deltas.get(currentString.charAt(0));
        StateSet clonedStateSet = new StateSet();

        if(Objects.nonNull(nextStateSet)) {
            for (State s : nextStateSet) {
                State clonedState = s.clone(currentString.substring(1));
                clonedStateSet.add(clonedState);
            }
        }
        return clonedStateSet;
    }

}

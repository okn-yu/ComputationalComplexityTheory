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

    private State clone(String currentString) {

        State clonedState = null;

        try {
            clonedState = (State) super.clone();
            clonedState.name = name;
            clonedState.isAcceptState = isAcceptState;
            clonedState.isInitState = isInitState;
            clonedState.currentString = currentString;
            clonedState.deltas = deltas;

        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return clonedState;

    }

    public boolean transitState() throws NextStateException {

        if (currentString.isEmpty()) {
            return isAcceptState;
        }

        State nextState = delta.get(currentString.charAt(0));

        if (Objects.isNull(nextState)) {
            throw new NextStateException("Current State is " + name + ". " + "Next Character is " + currentString.substring(1) + ". ");
        } else {
            nextState.currentString = currentString.substring(1);
            return nextState.transitState();
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

    @Override
    public String toString(){
        return name;
    }

}

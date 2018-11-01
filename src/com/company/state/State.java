package com.company.state;

import java.util.HashMap;
import java.util.Objects;

import com.company.alphabet.Alphabet;

public class State {

    private String name;
    public HashMap<Character, State> delta = new HashMap<Character, State>();
    private boolean isAcceptState;
    public boolean isInitState;
    public static Alphabet shigma;

    public State(String name, boolean isInitState, boolean isAcceptState) {

        if (name.charAt(0) == 'q') {
            this.name = name;
            this.isInitState = isInitState;
            this.isAcceptState = isAcceptState;
        } else {
            throw new NameException(name);
        }
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

}

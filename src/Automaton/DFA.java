package Automaton;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

import Utill.*;

public class DFA extends Automaton <Pair, String>{

    public DFA(String name, HashSet<String> Q, HashSet<Character> Shigma, HashMap<Pair, String> delta, String q0, HashSet<String> F) {
        super(name, Q, Shigma, delta, q0, F);
    }

    @Override
    public boolean isAccept(String inputString) {

        checkInputString(inputString);

        String currentState = q0;

        while (!inputString.isEmpty()) {
            System.out.println("currentState:" + currentState + "," + " inputString: " + inputString);
            currentState = getNextState(new Pair<String, Character>(currentState, inputString.charAt(0)));
            inputString = inputString.substring(1);
        }

        return F.contains(currentState);
    }

    protected String getNextState(Pair input) {
        String dstState = delta.get(input);

        if (Objects.isNull(dstState)) {
            throw new NullPointerException();
        }
        return dstState;
    }

    @Override
    public String convert2Tape() {
        return "test";
    }

    @Override
    public String toString() {
        return "test";
    }

}

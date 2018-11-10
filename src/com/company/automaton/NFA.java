package com.company.automaton;


import com.company.util.Pair;

import java.util.*;

public class NFA extends Automaton<Pair, HashSet<String>> {

    public NFA(String name, HashSet<String> Q, HashSet<Character> Shigma, HashMap<Pair, HashSet<String>> delta, String q0, HashSet<String> F) {
        super(name, Q, Shigma, delta, q0, F);
    }

    @Override
    public boolean isAccept(String inputString) {

        String currentString = inputString;
        HashSet<String> currentStateSet = new HashSet<String>() {{
            add(q0);
        }};

        while (!currentString.isEmpty()) {

            System.out.println("currentString: " + currentString);
            System.out.println("currentStateSet:" + currentStateSet);

            HashSet<String> nextStateSet = new HashSet<String>();
            Character currentChar = currentString.charAt(0);

            for (String state : currentStateSet) {
                nextStateSet.addAll(getNextState(new Pair<String, Character>(state, currentChar)));
                nextStateSet.addAll(getNextState(new Pair<String, Character>(state, 'e')));
            }
            currentStateSet = nextStateSet;
            currentString = currentString.substring(1);
            System.out.println();
        }

        System.out.println("lastStateSet: " + currentStateSet);

        return isAcceptLastStateSet(currentStateSet);
    }

    protected HashSet<String> getNextState(Pair input) {
        HashSet<String> nextStateSet = delta.get(input);

        if(Objects.nonNull(nextStateSet)) {
            return nextStateSet;
        } else {
            return new HashSet<String>();
        }
    }

    private boolean isAcceptLastStateSet(HashSet<String> stateSet){

        for (String s : stateSet) {
            if (F.contains(s))
                return true;
        }
        return false;
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

package com.company.automaton;


import com.company.util.Pair;
import com.company.util.Triple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Deque;

public class PDA extends Automaton<Triple, HashSet<Pair>> {

    private final HashSet<Character> Gamma;

    public PDA(String name, HashSet<String> Q, HashSet<Character> Shigma, HashSet<Character> Gamma, HashMap<Triple, HashSet<Pair>> delta, String q0, HashSet<String> F) {
        super(name, Q, Shigma, delta, q0, F);
        this.Gamma = Gamma;
    }

    @Override
    public boolean isAccept(String input) {
        String currentString = input;
        HashSet<PDAState> currentStateSet = new HashSet<PDAState>() {{
            add(new PDAState(q0));
        }};

        while (!currentString.isEmpty()) {
            Character currentChar = currentString.charAt(0);
            currentStateSet.addAll(getNextState(currentStateSet, 'e'));

            HashSet<PDAState> nextStateSet = new HashSet<>();
            nextStateSet = getNextState(currentStateSet, currentChar);

            if (nextStateSet.isEmpty())
                return false;

            currentStateSet = nextStateSet;
            currentString = currentString.substring(1);
        }

        return isAcceptLastStateSet(currentStateSet);
    }

    private HashSet<PDAState> getNextState(HashSet<PDAState> currentStateSet, Character c) {
        HashSet<PDAState> nextStateSet = new HashSet<>();

        for (PDAState pdaState : currentStateSet) {
            nextStateSet.addAll(pdaState.nextStateSet(c, delta));
        }
        return nextStateSet;
    }

    private boolean isAcceptLastStateSet(HashSet<PDAState> stateSet) {

        stateSet.addAll(getNextState(stateSet, 'e'));

        for (PDAState s : stateSet) {
            if (F.contains((String) s.getStateName()))
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

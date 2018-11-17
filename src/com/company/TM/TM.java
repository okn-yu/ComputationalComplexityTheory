package com.company.TM;

import com.company.automaton.PDAState;
import com.company.util.Pair;
import com.company.util.Triple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

public class TM {

    protected final String name;
    protected final HashSet<String> Q;
    protected final HashSet<Character> Shigma;
    protected final HashSet<Character> Gamma;
    protected final HashMap<Pair, HashSet<Triple>> delta;
    protected final String q0;
    protected final String qAccept;
    protected final String qReject;

    public TM(String name, HashSet<String> Q, HashSet<Character> Shigma, HashSet<Character> Gamma, HashMap<Pair, HashSet<Triple>> delta, String q0, String qAccept, String qReject) {
        this.name = name;
        this.Q = Q;
        this.Shigma = Shigma;
        this.Gamma = Gamma;
        this.delta = delta;
        this.q0 = q0;
        this.qAccept = qAccept;
        this.qReject = qReject;

        if(qAccept.equals(qReject))
            throw new IllegalArgumentException();

        if(!Gamma.contains('_'))
            throw new IllegalArgumentException();

        if(!Gamma.containsAll(Shigma))
            throw new IllegalArgumentException();
    }

    public boolean isAccept(ArrayList<Character> tape) {
        int headPosition = 0;

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
        //for (PDAState pdaState : currentStateSet) {
        //    nextStateSet.addAll(pdaState.nextStateSet(c, delta));
        //}
        return nextStateSet;
    }

    private boolean isAcceptLastStateSet(HashSet<PDAState> stateSet) {
        return false;
    }

    public String convert2Tape() {
        return "test";
    }

    @Override
    public String toString() {
        return "test";
    }
}

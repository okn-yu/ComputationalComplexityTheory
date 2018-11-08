package com.company.automaton;

import java.rmi.NoSuchObjectException;
import java.util.Collections;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Objects;

abstract public class Automaton<S, D> {

    protected String name;
    protected HashSet<String> Q;
    protected HashSet<Character> inputAlphabet;
    protected HashMap<S, D> delta;
    protected String q0;
    protected HashSet<String> F;

    public Automaton(String name, HashSet<String> Q, HashSet<Character> inputAlphabet, HashMap<S, D> delta, String q0, HashSet<String> F) {
        this.name = name;
        this.Q = Q;
        this.inputAlphabet = inputAlphabet;
        this.delta = delta;
        this.q0 = q0;
        this.F = F;
    }

    protected void checkInputString(String inputString) {
        if (inputString.isEmpty()) {
            throw new IllegalArgumentException();
        }

        for (int n = 0; n < inputString.length(); n++) {
            if (!inputAlphabet.contains(inputString.charAt(n))) {
                throw new IllegalArgumentException();
            }
        }
    }

    protected D getNextState(S input) {
        D dstState = delta.get(input);

        if (Objects.isNull(dstState)) {
            throw new NullPointerException();
        }

        return dstState;
    }

    abstract public boolean isAccept(String inputString);
    abstract public String convert2Tape();
    abstract public String toString();
}

package com.company.automaton;


import com.company.util.Pair;

import java.util.HashMap;
import java.util.HashSet;

public class NFA extends Automaton<Pair, HashSet<String>> {

    public NFA(String name, HashSet<String> Q, HashSet<Character> inputAlphabet, HashMap<Pair, HashSet<String>> delta, String q0, HashSet<String> F) {
        super(name, Q, inputAlphabet, delta, q0, F);
    }

    @Override
    public boolean isAccept(String inputAlphabet) {
        return true;
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

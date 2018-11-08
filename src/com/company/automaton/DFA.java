package com.company.automaton;


import java.util.HashMap;
import java.util.HashSet;

import com.company.util.*;

public class DFA extends Automaton <Pair, String>{

    public DFA(String name, HashSet<String> Q, HashSet<Character> inputAlphabet, HashMap<Pair, String> delta, String q0, HashSet<String> F) {
        super(name, Q, inputAlphabet, delta, q0, F);
    }

    @Override
    public boolean isAccept(String inputAlphabet) {

        checkInputString(inputAlphabet);

        String currentState = q0;

        while (!inputAlphabet.isEmpty()) {
            currentState = getNextState(new Pair<String, Character>(currentState, inputAlphabet.charAt(0)));
            inputAlphabet = inputAlphabet.substring(1);
        }

        return F.contains(currentState);
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

package com.company.automaton;


import com.company.util.Pair;

import java.util.*;

public class NFA extends Automaton<Pair, HashSet<String>> {

    public NFA(String name, HashSet<String> Q, HashSet<Character> inputAlphabet, HashMap<Pair, HashSet<String>> delta, String q0, HashSet<String> F) {
        super(name, Q, inputAlphabet, delta, q0, F);
    }

    @Override
    public boolean isAccept(String inputString) {

        String currentString = inputString;
        Deque<String> queue = new ArrayDeque<String>();
        queue.offer(q0);

        while(!queue.isEmpty()) {
            String currentState = queue.poll();
            System.out.println("currentState is " + currentState + ".");
            System.out.println("currentString is " + currentString);
            if (currentString.isEmpty()) {
                if(F.contains(currentState))
                    return true;
            }else{
                Character currentChar = currentString.charAt(0);
                HashSet<String> nextState = getNextState(new Pair<String, Character>(currentState, currentChar));
                System.out.println("NextState: " + nextState);
                System.out.println("NextCharacter: " + currentChar);
                for (String s : nextState) {
                    System.out.println("Set queue: " + s);
                    queue.offer(s);
                    currentString = currentString.substring(1);
                }
            }
            System.out.println();
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

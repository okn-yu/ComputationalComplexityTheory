package com.company;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import com.company.automaton.*;
import com.company.util.*;


public class Main {

    public static void main(String[] args) {

        String name = "test";
        HashSet<String> Q = new HashSet<>();
        Collections.addAll(Q, "q0", "q1", "q2");

        HashSet<Character> inputAlphabet = new HashSet<>();
        Collections.addAll(inputAlphabet, '0', '1');

        HashMap<Pair, String> delta = new HashMap<>();
        delta.put(new Pair<>("q0", '0'), "q1");
        delta.put(new Pair<>("q0", '1'), "q0");
        delta.put(new Pair<>("q1", '0'), "q1");
        delta.put(new Pair<>("q1", '1'), "q0");

        String q0 = "q0";

        HashSet<String> F = new HashSet<String>();
        Collections.addAll(F, "q0");

        Automaton dfa = new DFA(name, Q, inputAlphabet, delta, q0, F);
        System.out.println(dfa.isAccept("00"));

    }
}

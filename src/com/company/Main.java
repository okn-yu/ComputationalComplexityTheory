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
        Collections.addAll(Q, "q1", "q2", "q3", "q4");

        HashSet<Character> inputAlphabet = new HashSet<>();
        Collections.addAll(inputAlphabet, '0', '1');

        HashMap<Pair, HashSet<String>> delta = new HashMap<>();
        delta.put(new Pair<>("q1", '0'), new HashSet<String>(){{add("q1");}});
        delta.put(new Pair<>("q1", '1'), new HashSet<String>(){{add("q1"); add("q2");}});
        delta.put(new Pair<>("q2", '0'), new HashSet<String>(){{add("q3");}});
        delta.put(new Pair<>("q3", '1'), new HashSet<String>(){{add("q4");}});
        delta.put(new Pair<>("q4", '0'), new HashSet<String>(){{add("q4");}});
        delta.put(new Pair<>("q4", '1'), new HashSet<String>(){{add("q4");}});

        String q0 = "q1";

        HashSet<String> F = new HashSet<String>();
        Collections.addAll(F, "q4");

        Automaton nfa = new NFA(name, Q, inputAlphabet, delta, q0, F);
        System.out.println(nfa.isAccept("0101"));

    }
}

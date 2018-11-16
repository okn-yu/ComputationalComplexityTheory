package com.company;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import com.company.automaton.*;
import com.company.util.*;

public class Main {

    public static void main(String[] args) {

        Automaton nfa = NFATest.NFATest();
        System.out.println(nfa.isAccept("0101"));


        /*
        String name = "test";
        HashSet<String> Q = new HashSet<>();
        Collections.addAll(Q, "q1", "q2", "q3", "q4");

        HashSet<Character> Shigma = new HashSet<>();
        Collections.addAll(Shigma, '0', '1');

        HashSet<Character> Gamma = new HashSet<>();
        Collections.addAll(Gamma, '0', '$');
        */

        /*
         Triple: stateName, inputCharacter, stackTopValue.
         Pair: stateName, stackTopValue.
         delta a, b, c -> d, e
          a: startState
          b: inputCharacter
          c: stackTopValue
          d: endState
          e: stackTopValue
          if b == 'e': transfers unconditionally.
          if c == 'e': No Pop. Push only.
          if e == 'e': No Push. Pop only.
          if c != 'e' and d != 'e': change StackValue from 'c' to 'e'.
         */

/*        HashMap<Triple, HashSet<Pair>> delta = new HashMap<>();
        delta.put(new Triple<>("q1", 'e', 'e'), new HashSet<Pair>() {{
            add(new Pair<>("q2", '$'));
        }});
        delta.put(new Triple<>("q2", '0', 'e'), new HashSet<Pair>() {{
            add(new Pair<>("q2" ,'0'));
        }});
        delta.put(new Triple<>("q2", '1', '0'), new HashSet<Pair>(){{
            add(new Pair<>("q3", 'e'));
        }});
        delta.put(new Triple<>("q3", '1', '0'), new HashSet<Pair>(){{
            add(new Pair<>("q3", 'e'));
        }});
        delta.put(new Triple<>("q3", 'e', '$'), new HashSet<Pair>(){{
            add(new Pair<>("q4", 'e'));
        }});

        String q0 = "q1";

        HashSet<String> F = new HashSet<String>();
        Collections.addAll(F, "q1", "q4");

        Automaton pda = new PDA(name, Q, Shigma, Gamma, delta, q0, F);
        System.out.println(pda.isAccept("000000000000011111"));*/
    }
}

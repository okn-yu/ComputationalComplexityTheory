package com.company;

import com.company.automaton.DeterministicFiniteAutomaton;
import com.company.component.Alphabet;
import com.company.component.State;
import com.company.component.StateSet;
import com.company.component.TransitionFunction;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        // DFATest
//        State q1 = new State("q1");
//        State q2 = new State("q2");
//        State q3 = new State("q3");
//
//        StateSet Q = new StateSet(q1, q2, q3);
//        Q.show();
//        Alphabet Sigma = new Alphabet('1', '2');
//        StateSet F = new StateSet(q2);
//
//        TransitionFunction delta = new TransitionFunction(Q, Sigma);
//        delta.setArrow(q1,'0',q1);
//        delta.setArrow(q1,'1',q2);
//        delta.setArrow(q2,'0',q1);
//        delta.setArrow(q2,'1',q2);
//
//        DeterministicFiniteAutomaton DFA = new DeterministicFiniteAutomaton(Q, Sigma, delta, q1, F);
//        System.out.println(DFA.isAccept("011"));

        // NFATest
        State q1 = new State("q1");
        State q2 = new State("q2");
        State q3 = new State("q3");
        State q4 = new State("q4");

        StateSet Q = new StateSet(q1, q2, q3, q4);
        Q.show();

        Alphabet Sigma = new Alphabet('0', '1', 'e');

        StateSet F = new StateSet(q4);

        TransitionFunction delta = new TransitionFunction(Q, Sigma);

        delta.setArrows(q1,'0', new StateSet(q1));
        delta.setArrows(q1,'1', new StateSet(q1, q2));
        delta.setArrows(q1,'e', new StateSet());




    }
}

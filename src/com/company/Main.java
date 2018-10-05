package com.company;

import com.company.automaton.DeterministicFiniteAutomaton;
import com.company.component.AcceptStateSet;
import com.company.component.Alphabet;
import com.company.component.State;
import com.company.component.StateSet;
import com.company.component.TransitionFunction;

public class Main {

    public static void main(String[] args) {

        State q1 = new State("q1");
        State q2 = new State("q2");

        StateSet Q = new StateSet(q1, q2);
        Alphabet Sigma = new Alphabet('1', '2');
        AcceptStateSet F = new AcceptStateSet(q2);
        TransitionFunction delta = new TransitionFunction(Q, Sigma);

        delta.setArrow(q1, '0', q1);
        delta.setArrow(q1, '1', q2);
        delta.setArrow(q2, '0', q1);
        delta.setArrow(q2, '1', q2);

        DeterministicFiniteAutomaton DFA = new DeterministicFiniteAutomaton(Q, Sigma, delta, q1, F);

        System.out.println(DFA.isAccept("010"));
    }
}

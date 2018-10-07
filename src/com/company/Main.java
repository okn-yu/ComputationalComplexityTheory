package com.company;

import com.company.automaton.DeterministicFiniteAutomaton;
import com.company.component.AcceptStateSet;
import com.company.component.Alphabet;
import com.company.component.State;
import com.company.component.StatePowerSet;
import com.company.component.StateSet;
import com.company.component.TransitionFunction;

public class Main {

    public static void main(String[] args) {
        State q1 = new State("q1");
        State q2 = new State("q2");
        State q3 = new State("q3");


        StateSet Q = new StateSet(q1, q2, q3);
        //Q.show();
        StatePowerSet Q2 = new StatePowerSet(Q);
        //Q2.show();
        //Alphabet Sigma = new Alphabet('1', '2');
        //AcceptStateSet F = new AcceptStateSet(q2);
        //TransitionFunction delta = new TransitionFunction(Q, Sigma);

        //delta.setArrow(q1,'0',q1);
        //delta.setArrow(q1,'1',q2);
        //delta.setArrow(q2,'0',q1);
        //delta.setArrow(q2,'1',q2);

        //DeterministicFiniteAutomaton DFA = new DeterministicFiniteAutomaton(Q, Sigma, delta, q1, F);
        //System.out.println(DFA.isAccept("010"));

    }
}

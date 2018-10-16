package com.company;

import com.company.automaton.*;
import com.company.alphabet.Alphabet;
import com.company.automaton.*;
import com.company.state.*;
import com.company.transitionfunction.DFATransitionFunction;

public class DFATest {

    private StateSet Q, F;
    private State initState;
    private Alphabet Sigma;
    private DFATransitionFunction delta;

    public DFATest() {

        State q1 = new State("q1");
        State q2 = new State("q2");
        State q3 = new State("q3");

        Q = new StateSet(q1, q2, q3);
        Q.show();
        Sigma = new Alphabet('1', '2');
        initState = q1;
        F = new StateSet(q2);
        this.delta = new DFATransitionFunction(Q, Sigma);

        delta.setArrow(q1, '0', q1);
        delta.setArrow(q1, '1', q2);
        delta.setArrow(q2, '0', q1);
        delta.setArrow(q2, '1', q2);
    }

    public void run(String str) {
        Automaton DFA = new DeterministicFiniteAutomaton(Q, Sigma, delta, initState, F);
        System.out.println(DFA.isAccept(str));
    }
}

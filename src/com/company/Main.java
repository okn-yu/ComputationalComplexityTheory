package com.company;

import com.company.automaton.*;
import com.company.state.*;

public class Main {

    public static void main(String[] args) {

        /* DFATest */
        State q1 = new State("q1", true, false);
        State q2 = new State("q2", false, true);
        State q3 = new State("q3", false, true);

        q1.delta.put('0', q1);
        q1.delta.put('1', q2);
        q2.delta.put('0', q1);
        q2.delta.put('1', q2);

        StateSet Q1 = new StateSet(q1, q2, q3);
        Automaton dfa = new DFA(Q1);
        dfa.isAccept("01");

        /* NFATest */
        State q4 = new State("q4", true, false);
        State q5 = new State("q5", false, false);
        State q6 = new State("q6", false, true);
        State q7 = new State("q7", false, true);

        StateSet Q2 = new StateSet(q4, q5, q6, q7);

        q4.deltas.put('0', new StateSet(q4, q6));
        q5.deltas.put('0', new StateSet(q6));
        q6.deltas.put('0', new StateSet(q5, q6));

        Automaton nfa = new NFA(Q2);
        nfa.isAccept("00");

    }
}

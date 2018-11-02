package com.company;

import com.company.automaton.*;
import com.company.state.*;

public class Main {

    public static void main(String[] args) {

        //DFATest dfaTest = new DFATest();
        //dfaTest.run("011");

        //DFATest
//        State q1 = new State("q1", true, false);
//        State q2 = new State("q2", false, true);
//        State q3 = new State("q3", false, true);
//
//        q1.delta.put('0', q1);
//        q1.delta.put('1', q2);
//        q2.delta.put('0', q1);
//        q2.delta.put('1', q2);
//
//        StateSet Q = new StateSet(q1, q2, q3);
//        Automaton dfa = new Automaton(Q);
//        dfa.isAccept("01");

        // NFATest
        State q4 = new NFAState("q4", true, false);
        State q5 = new NFAState("q5", false, false);
        State q6 = new NFAState("q6", false, true);
        State q7 = new NFAState("q7", false, true);

        StateSet Q = new StateSet(q4, q5, q6, q7);

        q4.deltas.put('0',new StateSet(q4, q6));
        q5.deltas.put('0',new StateSet(q6));
        //q6.deltas.put('0',new StateSet(q5, q6));

        Automaton nfa = new NFA(Q);
        nfa.isAccept("00");

//        Q.show();
//
//        Alphabet Sigma = new Alphabet('0', '1', 'e');
//
//        StateSet F = new StateSet(q4);
//
//        TransitionFunction delta = new TransitionFunction(Q, Sigma);
//
//        delta.setArrows(q1,'0', new StateSet(q1));
//        delta.setArrows(q1,'1', new StateSet(q1, q2));
//        delta.setArrows(q1,'e', new StateSet());




    }
}

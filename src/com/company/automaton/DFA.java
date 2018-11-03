package com.company.automaton;

import com.company.state.NextStateException;
import com.company.state.StateSet;

public class DFA extends Automaton{

    public DFA(StateSet Q) {
        super(Q);
    }

    public void isAccept(String inputString) {

        q0.currentString = inputString;

        try {
            System.out.println(q0.transitState());
        } catch (NextStateException e) {
            e.printStackTrace();
        }
    }

}

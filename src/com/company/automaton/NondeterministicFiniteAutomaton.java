package com.company.automaton;

import com.company.component.*;

public class NondeterministicFiniteAutomaton extends Automaton{

    public NondeterministicFiniteAutomaton(StateSet Q, Alphabet Sigma, TransitionFunction delta, State q0, StateSet F) {
        super(Q, Sigma, delta, q0, F);
    }

    @Override
    public boolean isAccept(String str){

        State currentState = q0;

        for(int i = 0; i < str.length(); i++){
            currentState = delta.getDstState(currentState, str.charAt(i));
            System.out.println(currentState);
        }

        return F.contain(currentState);
    }

}

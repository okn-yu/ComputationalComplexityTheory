package com.company.automaton;

import com.company.component.*;

public class DeterministicFiniteAutomaton extends Automaton{

    public DeterministicFiniteAutomaton(StateSet Q, Alphabet Sigma, TransitionFunction delta, State q0, AcceptStateSet F){
        super(Q, Sigma, delta, q0, F);
    }

    @Override
    public boolean input(String str){

        State currentState = q0;

        for(int i = 0; i < str.length(); i++){
            currentState = delta.getArrow(currentState, str.charAt(i));
            System.out.println(currentState);
        }

        return F.contain(currentState);
    }

}

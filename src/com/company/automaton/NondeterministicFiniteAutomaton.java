package com.company.automaton;

import com.company.alphabet.Alphabet;
import com.company.state.*;
import com.company.transitionfunction.*;

public class NondeterministicFiniteAutomaton extends Automaton<NFATransitionFunction>{

    public NondeterministicFiniteAutomaton(StateSet Q, Alphabet Sigma, NFATransitionFunction delta, State q0, StateSet F) {
        super(Q, Sigma, delta, q0, F);
    }

    @Override
    public boolean isAccept(String str){

        State currentState = q0;
        StateSet currentStateSet;

        for(int i = 0; i < str.length(); i++){
            currentStateSet = delta.getDstState(currentState, str.charAt(i));
            for(State s: currentStateSet.getSet()){


            }
            System.out.println(currentState);
        }

        return F.contain(currentState);
    }

}

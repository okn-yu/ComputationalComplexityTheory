package com.company.automaton;

import com.company.alphabet.Alphabet;
import com.company.state.*;
import com.company.transitionfunction.*;

public class DeterministicFiniteAutomaton extends Automaton<DFATransitionFunction>{

    public DeterministicFiniteAutomaton(StateSet Q, Alphabet Sigma, DFATransitionFunction delta, State q0, StateSet F){
        super(Q, Sigma, delta, q0, F);
        //RcheckDelta();
        //System.out.println(delta);
    }

    private void checkDelta(){
        if( ! Q.getSet().containsAll(F.getSet())){
            throw new IllegalArgumentException ("F is not subset.");
        }
    }

    @Override
    public boolean isAccept(String str){

        State currentState = q0;

        for(int i = 0; i < str.length(); i++){
            currentState = delta.getDstState(currentState, str.charAt(i));
            System.out.println(currentState);
        }

        return this.F.contain(currentState);
    }

}

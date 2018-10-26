package com.company.automaton;

import com.company.alphabet.Alphabet;
import com.company.state.*;
import com.company.transitionfunction.*;

public class NondeterministicFiniteAutomaton extends Automaton<NFATransitionFunction> {

    private StateSet currentStateSet;

    public NondeterministicFiniteAutomaton(StateSet Q, Alphabet Sigma, NFATransitionFunction delta, State q0, StateSet F) {
        super(Q, Sigma, delta, q0, F);
        currentStateSet = new StateSet(q0);
    }

    @Override
    public boolean isAccept(String str){

        StateSet initStateSet = new StateSet(q0);
        return test(initStateSet, str);
    }

    private boolean test(StateSet ss, String str){

        if(str.isEmpty()){
            return false;
        }

        StateSet nextStateSet = new StateSet();

        for(State s: ss.getSet()){
            nextStateSet.add(delta.getDstState(s, str.charAt(0)));
        }

        if(F.contain(nextStateSet)){
            return true;
        }

        return this.test(nextStateSet, str.substring(2));

    }

}

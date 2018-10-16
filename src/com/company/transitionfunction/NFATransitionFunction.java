package com.company.transitionfunction;

import com.company.alphabet.Alphabet;
import com.company.state.State;
import com.company.state.StateSet;

import java.util.HashMap;

public class NFATransitionFunction extends TransitionFunction<StateSet>{

    private StateSet Q;
    private Alphabet Sigma;
    private HashMap<HashMap<State, Character>, StateSet> Arrow = new HashMap<HashMap<State, Character>, StateSet>();

    public NFATransitionFunction(StateSet Q, Alphabet Sigma){
        super(Q, Sigma);
    }

    public void setArrow(State src, Character c, StateSet dst) {
        HashMap<State, Character> innerArrow = new HashMap<State, Character>();
        innerArrow.put(src, c);
        Arrow.put(innerArrow, dst);
    }

    public HashMap<HashMap<State, Character>, StateSet> getArrow(State src, Character c){
        return Arrow;
    }

    public StateSet getDstState(State src, Character c){
        HashMap<State, Character> innerArrow = new HashMap<State, Character>();
        innerArrow.put(src, c);
        return Arrow.get(innerArrow);
    }
}

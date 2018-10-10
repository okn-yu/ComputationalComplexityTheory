package com.company.component;

import java.util.HashMap;

public class DFATransitionFunction extends TransitionFunction<State>{

    private StateSet Q;
    private Alphabet Sigma;
    private HashMap<HashMap<State, Character>, State> Arrow = new HashMap<HashMap<State, Character>, State>();

    public DFATransitionFunction(StateSet Q, Alphabet Sigma){
        super(Q, Sigma);
    }

    public void setArrow(State src, Character c, State dst) {
        HashMap<State, Character> innerArrow = new HashMap<State, Character>();
        innerArrow.put(src, c);
        Arrow.put(innerArrow, dst);
    }

    public HashMap<HashMap<State, Character>, State> getAllow(){
        return Arrow;
    }

    public State getDstState(State src, Character c){
        HashMap<State, Character> innerArrow = new HashMap<State, Character>();
        innerArrow.put(src, c);
        return Arrow.get(innerArrow);
    }
}

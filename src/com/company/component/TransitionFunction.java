package com.company.component;

import java.util.HashMap;

public class TransitionFunction {

    private StateSet Q;
    private Alphabet Sigma;
    private HashMap<HashMap<State, Character>, State> Arrow = new HashMap<HashMap<State, Character>, State>();

    public TransitionFunction(StateSet Q, Alphabet Sigma){
        this.Q = Q;
        this.Sigma = Sigma;
    }

    public void setArrow(State src, Character c, State dst) {
        HashMap<State, Character> innerArrow = new HashMap<State, Character>();
        innerArrow.put(src, c);
        Arrow.put(innerArrow, dst);
    }

    public State getArrow(State src, Character c){
        HashMap<State, Character> innerArrow = new HashMap<State, Character>();
        innerArrow.put(src, c);
        return Arrow.get(innerArrow);
    }
}

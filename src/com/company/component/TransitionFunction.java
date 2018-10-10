package com.company.component;

import java.util.HashMap;

abstract public class TransitionFunction<T> {

    private StateSet Q;
    private Alphabet Sigma;
    private HashMap<HashMap<State, Character>, T> Arrow;

    public TransitionFunction(StateSet Q, Alphabet Sigma){
        this.Q = Q;
        this.Sigma = Sigma;
    }

    abstract public void setArrow(State src, Character c, T t);
    abstract public State getDstState(State src, Character c);

}

package com.company.transitionfunction;

import java.util.HashMap;
import com.company.state.*;
import com.company.alphabet.*;

abstract public class TransitionFunction<T> {

    private StateSet Q;
    private Alphabet Sigma;
    private HashMap<HashMap<State, Character>, T> Arrow;

    public TransitionFunction(StateSet Q, Alphabet Sigma){
        this.Q = Q;
        this.Sigma = Sigma;
    }

    abstract public void setArrow(State src, Character c, T t);
    abstract public HashMap<HashMap<State, Character>, T> getArrow(State src, Character c);
    abstract public T getDstState(State src, Character c);

}

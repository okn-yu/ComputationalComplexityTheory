package com.company.automaton;

import com.company.alphabet.Alphabet;
import com.company.state.*;
import com.company.transitionfunction.*;

abstract class Automaton<T> {

    protected StateSet Q;
    protected Alphabet Sigma;
    protected T delta;
    protected State q0;
    protected StateSet F;

    public Automaton(StateSet Q, Alphabet Sigma, T delta, State q0, StateSet F){
        this.Q = Q;
        this.Sigma = Sigma;
        this.delta = delta;
        this.q0 = q0;
        this.F = F;
    }

    public boolean isValidString(String str){
        return true;
    };

    abstract boolean isAccept(String str);

}

package com.company.automaton;

import com.company.component.*;

abstract class Automaton {

    protected StateSet Q;
    protected Alphabet Sigma;
    protected TransitionFunction delta;
    protected State q0;
    protected AcceptStateSet F;

    public Automaton(StateSet Q, Alphabet Sigma, TransitionFunction delta, State q0, AcceptStateSet F){
        this.Q = Q;
        this.Sigma = Sigma;
        this.delta = delta;
        this.q0 = q0;
        this.F = F;
    }

    abstract boolean input(String str);

}

package com.company.automaton;

import com.company.state.*;

abstract public class Automaton {

    protected StateSet Q;
    protected State q0;

    public Automaton(StateSet Q)
    {
        this.Q = Q;
        for(State s: Q){
            if(s.isInitState){
                this.q0 =s;
                break;
            }
        }

        System.out.println(Q);
        System.out.println("q0 is " + q0 + ".");
    }

    abstract public void isAccept(String inputString);

}

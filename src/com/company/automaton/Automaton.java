package com.company.automaton;

import com.company.state.*;

public class Automaton {

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
    }

    public void isAccept(String inputString) {
        try {
            System.out.println(q0.transitState(inputString));
        } catch (NextStateException e) {
            e.printStackTrace();
        }
    }

}

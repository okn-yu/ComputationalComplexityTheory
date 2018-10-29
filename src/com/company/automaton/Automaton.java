package com.company.automaton;

import com.company.alphabet.Alphabet;
import com.company.state.*;
import com.company.transitionfunction.*;

public class Automaton {

    protected StateSet Q;
    private State q0;

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


    public void isAccept(String inputString){
        System.out.println(q0.transitState(inputString));
    }

}

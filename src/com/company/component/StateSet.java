package com.company.component;

import java.util.HashSet;

public class StateSet {

    protected HashSet<State> set;

    public StateSet(State... state) {
        set = new HashSet<State>();

        for (State s : state) {
            set.add(s);
        }
    }

    public boolean contain(State s){
        return set.contains(s);
    }

}

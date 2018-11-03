package com.company.state;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class StateSet extends HashSet<State> {

    public StateSet(State... states) {

        List<State> list = Arrays.asList(states);
        this.addAll(list);
    }

    public StateSet(){}

    @Override
    public String toString(){

        String str = "State set components: { ";

        for(State s : this){
            str += s + " ";
        }

        str += "}";

        return str;
    }

}

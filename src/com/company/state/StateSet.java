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

    public void show(){
        System.out.print("StateSet: { ");
        for(State s : this){
            System.out.print(" ");
        }
        System.out.println("}");
    }

}

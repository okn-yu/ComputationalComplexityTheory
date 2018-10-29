package com.company.state;

import java.util.Arrays;
import java.util.List;
import java.util.HashSet;

public class StateSet extends HashSet<State> {

    public StateSet(State... states) {

        List<State> list = Arrays.asList(states);
        this.addAll(list);
    }

    public void show(){
        System.out.print("StateSet: { ");
        for(State s : this){
            s.show();
            System.out.print(" ");
        }
        System.out.println("}");
    }

}

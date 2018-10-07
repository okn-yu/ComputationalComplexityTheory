package com.company.component;

import java.util.HashSet;
import java.util.Iterator;

public class StateSet {

    protected HashSet<State> set;

    public StateSet(State... state) {
        set = new HashSet<State>();

        for (State s : state) {
            set.add(s);
        }
    }

    public StateSet(HashSet<State> state){
        set = new HashSet<State>();

        for (State s : state) {
            set.add(s);
        }
    }

    protected void add(State s){
        set.add(s);
    }

    public boolean contain(State s){
        return set.contains(s);
    }

    public void show(){
        System.out.print("StateSet: { ");
        for(State s : set){
            s.show();
            System.out.print(" ");
        }
        System.out.println("}");
    }

}

package com.company.component;

import java.util.HashSet;
import java.util.Iterator;

public class StateSet {

    private HashSet<State> set;

    public StateSet(){
        set = new HashSet<State>();
    }

    public void addState(State q){
        set.add(q);
    }


    @Override
    public String toString(){
        return "sample";
    }

    public void list(){
        Iterator it = set.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

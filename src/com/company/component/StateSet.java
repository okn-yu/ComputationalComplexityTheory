package com.company.component;

import java.util.HashSet;
import java.util.Iterator;

public class State {

    private HashSet<String> set;

    public State(){
        set = new HashSet<String>();
    }

    public void addState(String element){
        set.add(element);
    }

    public void list(){
        Iterator it = set.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

package com.company.state;

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

    public HashSet<State> getSet(){
        return set;
    }

    public StateSet(HashSet<State> ss){
        set = new HashSet<State>();

        for (State s : ss) {
            set.add(s);
        }
    }

    public void add(State s){
        set.add(s);
    }

    public void add(StateSet ss){
        for(State s :ss.set){
            this.add(s);
        }
    }

    public boolean contain(State s){
        return set.contains(s);
    }

    public boolean contain(StateSet ss){
        for(State s:ss.set){
            if(contain(s)){
                return true;
            }
        }
        return false;
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

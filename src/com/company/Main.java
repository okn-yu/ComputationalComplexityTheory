package com.company;

import com.company.component.State;
import com.company.component.StateSet;


public class Main {

    public static void main(String[] args) {

        State<String> q = new State<String>();
        q.setValue("test");

        StateSet Q = new StateSet();
        Q.addState(q);
        //state.addState("b");
        Q.list();
        System.out.println(Q.toString());
    }
}

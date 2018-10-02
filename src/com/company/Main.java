package com.company;

import java.util.Iterator;
import com.company.component.State;

public class Main {

    public static void main(String[] args) {

        State state = new State();
        state.addState("a");
        state.addState("b");

        state.list();
    }
}

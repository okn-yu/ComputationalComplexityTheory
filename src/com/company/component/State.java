package com.company.component;

import java.util.HashMap;

public class State {

    private String stateName;

    public State(String name) {

        if (name.charAt(0) == 'q') {
            stateName = name;
        } else {
            throw new NullPointerException("stateName[0] is not q!");
        }
    }

    public void show() {
        System.out.print(stateName);
    }

}

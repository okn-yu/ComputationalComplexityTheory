package com.company.component;

/*
状態qは"q+整数値"で表記されるString型とする
例: q0, q1, q2....
 */


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

    @Override
    public String toString() {
        return stateName;
    }
}

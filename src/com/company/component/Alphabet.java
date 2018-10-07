package com.company.component;

import java.util.Collections;
import java.util.HashSet;

public class Alphabet {

    private HashSet<Character> set;

    public Alphabet(Character... characters) {
        set = new HashSet<Character>();
        Collections.addAll(set, characters);
    }

}

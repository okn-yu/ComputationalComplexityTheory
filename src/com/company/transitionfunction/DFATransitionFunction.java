package com.company.transitionfunction;

import java.util.HashMap;
import com.company.alphabet.*;
import com.company.state.*;

public class DFATransitionFunction{

    private HashMap<HashMap<String, Character>, String> Arrow = new HashMap<HashMap<String, Character>, String>();

//    public DFATransitionFunction(StateSet Q, Alphabet Sigma){
//        super(Q, Sigma);
//    }

    public void setArrow(String src, Character c, String dst) {
        HashMap<String, Character> innerArrow = new HashMap<String, Character>();
        innerArrow.put(src, c);
        Arrow.put(innerArrow, dst);
    }

    public HashMap<HashMap<String, Character>, String> getArrow(String src, Character c){
        return Arrow;
    }

    public String getDstState(String src, Character c){
        HashMap<String, Character> innerArrow = new HashMap<String, Character>();
        innerArrow.put(src, c);
        return Arrow.get(innerArrow);
    }
}

package com.company.automaton;

import com.company.util.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.HashMap;

public class PDAState {

    private String stateName;
    private Deque<Character> stack = new ArrayDeque<>();

    public PDAState(String stateName){
        this.stateName = stateName;
    }

    public String getStateName(){
        return stateName;
    }

    public HashSet<PDAState> nextStateSet(Character input, HashMap<Triple, HashSet<Pair>> delta){

        HashSet<PDAState> nextStateSet = new HashSet<>();

        for(HashMap.Entry<Triple, HashSet<Pair>> entry: delta.entrySet()) {
            Triple triple = entry.getKey();
            Character c = (Character) triple.getSecElm();
            Character s = (Character) triple.getThridElm();

            if (checkInput(input, c) && checkStack(s)) {
                HashSet<Pair> pairs = delta.get(new Triple<>(stateName, c, s));

                for(Pair pair : pairs){
                    String nextStateName = (String)pair.getFirstElm();
                    if(s != 'e')
                        stack.push(s);

                }
            }

        }

        return nextStateSet;
    }

    private boolean checkInput(Character input, Character c){
        return c == 'e' || c == input;
    }

    private boolean checkStack(Character s){
        if(s == 'e')
            return true;

        if(s == stack.getFirst()){
            stack.pop();
            return true;
        }else {
            return false;
        }
    }

    private PDAState nextState(Pair pair){
    }


}

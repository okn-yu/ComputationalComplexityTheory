package com.company.automaton;

import com.company.util.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.HashMap;

public class PDAState{

    private String stateName;
    private Deque<Character> stack;

    public PDAState(String stateName){
        this.stateName = stateName;
        this.stack = new ArrayDeque<>();
    }


    public String getStateName(){
        return stateName;
    }

    public HashSet<PDAState> nextStateSet(Character input, HashMap<Triple, HashSet<Pair>> delta){
        HashSet<PDAState> nextStateSet = new HashSet<>();
        for(HashMap.Entry<Triple, HashSet<Pair>> entry: delta.entrySet()) {
            Triple triple = entry.getKey();
            Character cha = (Character) triple.getSecElm();
            Character s = (Character) triple.getThridElm();

            System.out.println("nextStateSet cha=" + cha + ", s=" + s +  ", input=" + input);
            if (checkInput(input, cha) && checkStack(s)) {
                HashSet<Pair> pairs = delta.get(new Triple<>(stateName, cha, s));

                for (Pair pair : pairs) {
                    nextStateSet.add(this);
                    // need try & catch!
                    //PDAState s1 = this.clone();
                }
            }else{
                System.out.println("delta not found. SKIP!");
            }
        }
        System.out.println(nextStateSet);
        return nextStateSet;
    }

    private boolean checkInput(Character input, Character c){
        return c == 'e' || c == input;
    }

    private boolean checkStack(Character s){
        if(s == 'e') {
            return true;
        }else if(s == stack.getFirst()){
            stack.pop();
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String toString(){
        return "StateName: " + this.stateName + ", " + "stackValue: " + stack;
    }
}

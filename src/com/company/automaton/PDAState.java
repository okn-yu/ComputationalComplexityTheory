package com.company.automaton;

import com.company.util.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.HashMap;

public class PDAState implements Cloneable{

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

        System.out.println("handle: " + this);

        for(HashMap.Entry<Triple, HashSet<Pair>> entry: delta.entrySet()) {
            Triple triple = entry.getKey();
            Character cha = (Character) triple.getSecElm();
            Character s = (Character) triple.getThridElm();

            System.out.println("currentState: " + this);
            System.out.println("nextStateSet cha=" + cha + ", s=" + s +  ", input=" + input);

            if (checkInput(input, cha) && checkStack(s)) {
                System.out.println("delta found.");
                HashSet<Pair> pairs = delta.get(new Triple<>(stateName, cha, s));

                for (Pair pair : pairs) {
                    try {
                        nextStateSet.add(copyState(pair, s));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }else{
                System.out.println("delta not found. SKIP!");
            }
        }
        System.out.println("returns:: " + nextStateSet);
        return nextStateSet;
    }

    // return c == 'e' || c == input
    private boolean checkInput(Character input, Character c){
        return c == input;
    }


    private boolean checkStack(Character s){
        return s == 'e' || s == stack.getFirst();
    }

    private PDAState copyState(Pair pair, Character s) throws CloneNotSupportedException {

        String nextStateName = (String)pair.getFirstElm();
        Character c = (Character)pair.getSecElm();
        PDAState copiedState =  new PDAState(nextStateName);
        copiedState.stack.addAll(stack);

        if (s != 'e' && s == copiedState.stack.getFirst()){
            copiedState.stack.pop();
        }

        if (c != 'e') {
            copiedState.stack.push(c);
        }

        System.out.println(copiedState.stack);
        System.out.println(stack);

        return copiedState;
    }

    @Override
    public String toString(){
        return "StateName: " + this.stateName + ", " + "stackValue: " + this.stack;
    }
}

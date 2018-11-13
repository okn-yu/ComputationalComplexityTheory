package com.company.automaton;


import com.company.util.Pair;
import com.company.util.Triple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Deque;

public class PDA extends Automaton<Triple, HashSet<Pair>>{

    private final HashSet<Character> Gamma;

        public PDA(String name, HashSet<String> Q, HashSet<Character> Shigma, HashSet<Character> Gamma, HashMap<Triple, HashSet<Pair>> delta, String q0, HashSet<String> F) {
        super(name, Q, Shigma, delta, q0, F);
        this.Gamma = Gamma;
    }

    @Override
    public boolean isAccept(String input) {

        String currentString = input;
        HashSet<PDAState> currentStateSet = new HashSet<PDAState>(){{
            add(new PDAState(q0));
        }};

        while (!currentString.isEmpty()) {

            System.out.println("currentString: " + currentString);
            System.out.println("currentStateSet:" + currentStateSet);

            HashSet<PDAState> nextStateSet = new HashSet<>();
            Character currentChar = currentString.charAt(0);

            //currentStateSet.addAll(acceptEpsilonCharacter(currentStateSet));

            for (PDAState state : currentStateSet) {
                //Triple triple = new Triple<String, Character, Character>((String) state.getFirstElm(), currentChar, (Character) state.getSecElm());
                //if (Objects.nonNull(getNextState(triple)))
                //    nextStateSet.addAll(getNextState(triple));
            }

            if (nextStateSet.isEmpty()) {
                return false;
            } else {
                currentStateSet = nextStateSet;
            }

            currentString = currentString.substring(1);
            System.out.println();
        }

        System.out.println("lastStateSet: " + currentStateSet);
        //return isAcceptLastStateSet(currentStateSet);
        return true;
    }

/*    private HashSet<Pair> acceptEpsilonCharacter(HashSet<PDAState> currentStateSet){

        HashSet<Pair> additionalStateSet = new HashSet<>();

        for(PDAState state : currentStateSet){
            Deque<Character> stack = (Deque<Character>)state.getSecElm();
            Character currentStack = stack.getFirst();
            System.out.println(currentStack);
            String currentState = (String)state.getFirstElm();
            Triple triple = new Triple<>(currentState, 'e', currentStack);
            if(delta.containsKey(triple)) {
                pair = getNextState(triple);
                stackValue = (Character) pair.getSecElm();
                Pair newPair = new Pair();
            }
        }
        return additionalStateSet;
    }*/

    private HashSet<PDAState> getNextState(HashSet<PDAState> currentStateSet, Character c) {

        HashSet<PDAState> nextStateSet = new HashSet<>();

        for(PDAState pdaState : currentStateSet){
            HashMap<Triple, HashSet<Pair >> filteredDelta = filterDelta(pdaState.getStateName());
            nextStateSet.addAll(pdaState.nextStateSet(c, filteredDelta));
        }

        return nextStateSet;
    }

    private HashMap<Triple, HashSet<Pair>> filterDelta(String stateName) {

        HashMap<Triple, HashSet<Pair>> filteredDelta = new HashMap<>();

        for(HashMap.Entry<Triple, HashSet<Pair>> entry: delta.entrySet()){
            if (stateName.equals((String)entry.getKey().getFirstElm()))
                filteredDelta.put(entry.getKey(), entry.getValue());
        }
        return filteredDelta;
    }

    private boolean isAcceptLastStateSet(HashSet<PDAState> stateSet){
        for (PDAState s : stateSet) {
            if (F.contains((String)s.getStateName()))
                return true;
        }
        return false;
    }

    @Override
    public String convert2Tape() {
        return "test";
    }

    @Override
    public String toString() {
        return "test";
    }

}

package com.company.TM;

import com.company.automaton.PDAState;
import com.company.util.Pair;
import com.company.util.Triple;

import java.util.HashMap;
import java.util.HashSet;

public class DTM extends TuringMashcine <Triple>{

    public DTM(String name, HashSet<String> Q, HashSet<Character> Shigma, HashSet<Character> Gamma, HashMap<Pair, Triple> delta, String q0, String qAccept, String qReject) {
        super(name, Q, Shigma, Gamma, delta, q0, qAccept,qReject);
    }

    public boolean isAccept(Tape tape){

        String currentState = q0;

        while(currentState != qReject){

            Character currentCharacter = tape.read();
            HashSet<Triple> triple = delta.get(new Pair(currentState, currentCharacter));

        }

    };

    public HashSet<PDAState> getNextState(HashSet<PDAState> currentStateSet, Character c){

    };

    @Override
    public String toString() {
        return "test";
    }
}

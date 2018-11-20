package automaton;

import util.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.HashMap;

public class PDAState implements Cloneable {

    private String stateName;
    private Deque<Character> stack;

    public PDAState(String stateName) {
        this.stateName = stateName;
        this.stack = new ArrayDeque<>();
    }

    public String getStateName() {
        return stateName;
    }

    public HashSet<PDAState> nextStateSet(Character receivedInput, HashMap<Triple, HashSet<Pair>> delta) {
        HashSet<PDAState> nextStateSet = new HashSet<>();

        for (HashMap.Entry<Triple, HashSet<Pair>> entry : delta.entrySet()) {
            Triple<String, Character, Character> triple = entry.getKey();

            if (!checkTriple(triple, receivedInput))
                continue;

            HashSet<Pair> pairs = delta.get(triple);
            for (Pair pair : pairs) {
                nextStateSet.add(nextState(pair, triple.getThridElm()));
            }
        }
        return nextStateSet;
    }

    private boolean checkTriple(Triple triple, Character receivedInput){
        String srcStateName = (String) triple.getFirstElm();
        Character srcInput = (Character) triple.getSecElm();
        Character srcStackVal = (Character) triple.getThridElm();

        return checkStateName(srcStateName) && checkInput(receivedInput, srcInput) && checkStackVal(srcStackVal);
    }

    private boolean checkStateName(String srcStateName){
        return srcStateName.equals(stateName);
    }

    private boolean checkInput(Character receivedInput, Character srcInput) {
        return receivedInput == srcInput;
    }

    private boolean checkStackVal(Character srcStackVal) {
        return srcStackVal == 'e' || srcStackVal == stack.getFirst();
    }

    private PDAState nextState(Pair pair, Character srcStackVal) {
        String nextStateName = (String) pair.getFirstElm();
        Character nextStackVal = (Character) pair.getSecElm();
        PDAState copiedState = new PDAState(nextStateName);
        copiedState.stack.addAll(stack);

        if (srcStackVal != 'e') {
            copiedState.stack.pop();
        }

        if (nextStackVal != 'e') {
            copiedState.stack.push(nextStackVal);
        }
        return copiedState;
    }

    @Override
    public String toString() {
        return "StateName: " + this.stateName + ", " + "stackValue: " + this.stack;
    }
}

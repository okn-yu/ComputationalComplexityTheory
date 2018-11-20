package Automaton;

import Utill.Pair;
import java.util.*;

public class NFA extends Automaton<Pair, HashSet<String>> {

    public NFA(String name, HashSet<String> Q, HashSet<Character> Shigma, HashMap<Pair, HashSet<String>> delta, String q0, HashSet<String> F) {
        super(name, Q, Shigma, delta, q0, F);
    }

    @Override
    public boolean isAccept(String inputString) {
        String currentString = inputString;
        HashSet<String> currentStateSet = new HashSet<String>() {{
            add(q0);
        }};

        while (!currentString.isEmpty()) {
            System.out.println("currentString: " + currentString);
            System.out.println("currentStateSet:" + currentStateSet);

            Character currentChar = currentString.charAt(0);
            currentStateSet.addAll(getNextStateSet(currentStateSet, 'e'));

            HashSet<String> nextStateSet = new HashSet<String>();
            nextStateSet = (getNextStateSet(currentStateSet, currentChar));

            currentStateSet = nextStateSet;
            currentString = currentString.substring(1);
            System.out.println();
        }

        return isAcceptLastStateSet(currentStateSet);
    }

    private HashSet<String> getNextStateSet(HashSet<String> stateSet, Character input){
        HashSet<String> returnStateSet = new HashSet<String>();

        for(String state : stateSet){
            HashSet<String> nextStateSet = delta.get(new Pair<String, Character>(state, input));

            if(Objects.nonNull(nextStateSet))
                returnStateSet.addAll(nextStateSet);
        }
        return returnStateSet;
    }

    private boolean isAcceptLastStateSet(HashSet<String> stateSet){
        stateSet.addAll(getNextStateSet(stateSet, 'e'));
        System.out.println("lastStateSet: " + stateSet);

        for (String s : stateSet) {
            if (F.contains(s))
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

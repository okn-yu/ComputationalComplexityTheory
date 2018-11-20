package TM;

import Utill.Pair;
import Utill.Triple;

import java.util.HashMap;
import java.util.HashSet;

public class DTM extends TuringMachine<Triple> {

    public DTM(String name, HashSet<String> Q, HashSet<Character> Shigma, HashSet<Character> Gamma, HashMap<Pair, Triple> delta, String q0, String qAccept, String qReject) {
        super(name, Q, Shigma, Gamma, delta, q0, qAccept,qReject);
    }

    public boolean isAccept(Tape tape){

        String currentState = q0;

        while(currentState != qReject){

            Character currentCharacter = tape.read();
            System.out.println("[" + currentState +", " + currentCharacter + "]");
            System.out.println(tape);
            Triple<String, Character, Character> triple = getNextState(currentState, currentCharacter);

            System.out.println(triple);

            currentState = triple.getFirstElm();
            if(currentState == qAccept)
                return true;

            Character cha = triple.getSecElm();
            Character direction = triple.getThridElm();

            tape.write(cha);
            tape.move(direction);

            System.out.println();
        }
        return false;
    }

    public Triple getNextState(String currentState, Character currentCharacter){
        return delta.get(new Pair(currentState, currentCharacter));
    }

    @Override
    public String toString() {
        return "test";
    }
}

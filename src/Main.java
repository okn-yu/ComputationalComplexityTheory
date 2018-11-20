import TM.TuringMashcine;
import TM.Tape;
import Test.DTMTest;

public class Main {

    public static void main(String[] args) {

        /*
        Automaton nfa = Test.NFATest.Test.NFATest();
        System.out.println(nfa.isAccept("0101"));
        */

        /*
        Automaton pda = Test.PDATest.Test.PDATest();
        System.out.println(pda.isAccept("0000111111"));
        */

        TuringMashcine dtm = DTMTest.DTMTest();
        System.out.println(dtm.isAccept(new Tape("0000_")));

    }
}

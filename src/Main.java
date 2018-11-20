import TM.TuringMashcine;
import TM.Tape;

public class Main {

    public static void main(String[] args) {

        /*
        Automaton nfa = NFATest.NFATest();
        System.out.println(nfa.isAccept("0101"));
        */

        /*
        Automaton pda = PDATest.PDATest();
        System.out.println(pda.isAccept("0000111111"));
        */

        TuringMashcine dtm = DTMTest.DTMTest();
        System.out.println(dtm.isAccept(new Tape("0000_")));

    }
}

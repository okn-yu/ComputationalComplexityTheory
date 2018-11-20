import automaton.Automaton;
import automaton.NFA;
import util.Pair;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;


public class NFATest {

    public static Automaton NFATest() {

        String name = "test";
        HashSet<String> Q = new HashSet<>();
        Collections.addAll(Q, "q1", "q2", "q3", "q4");

        HashSet<Character> Shigma = new HashSet<>();
        Collections.addAll(Shigma, '0', '1');

        HashMap<Pair, HashSet<String>> delta = new HashMap<>();
        delta.put(new Pair<>("q1", '0'), new HashSet<String>() {{
            add("q1");
        }});
        delta.put(new Pair<>("q1", '1'), new HashSet<String>() {{
            add("q1");
            add("q2");
        }});
        delta.put(new Pair<>("q2", '0'), new HashSet<String>() {{
            add("q3");
        }});
        delta.put(new Pair<>("q2", 'e'), new HashSet<String>() {{
            add("q3");
        }});
        delta.put(new Pair<>("q3", '1'), new HashSet<String>() {{
            add("q4");
        }});
        delta.put(new Pair<>("q4", '0'), new HashSet<String>() {{
            add("q4");
        }});
        delta.put(new Pair<>("q4", '1'), new HashSet<String>() {{
            add("q4");
        }});

        String q0 = "q1";

        HashSet<String> F = new HashSet<String>();
        Collections.addAll(F, "q4");

        return new NFA(name, Q, Shigma, delta, q0, F);

    }
}

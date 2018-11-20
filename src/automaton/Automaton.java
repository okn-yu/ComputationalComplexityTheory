package automaton;

import java.util.HashSet;
import java.util.HashMap;

abstract public class Automaton<S, D> {

    protected final String name;
    protected final HashSet<String> Q;
    protected final HashSet<Character> Shigma;
    protected final HashMap<S, D> delta;
    protected final String q0;
    protected final HashSet<String> F;

    public Automaton(String name, HashSet<String> Q, HashSet<Character> Shigma, HashMap<S, D> delta, String q0, HashSet<String> F) {
        this.name = name;
        this.Q = Q;
        this.Shigma = Shigma;
        this.delta = delta;
        this.q0 = q0;
        this.F = F;
    }

    protected void checkInputString(String inputString) {
        if (inputString.isEmpty()) {
            throw new IllegalArgumentException();
        }

        for (int n = 0; n < inputString.length(); n++) {
            if (!Shigma.contains(inputString.charAt(n))) {
                throw new IllegalArgumentException();
            }
        }
    }

    abstract public boolean isAccept(String inputString);
    abstract public String convert2Tape();
    abstract public String toString();
}

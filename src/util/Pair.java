package util;

import java.util.Objects;

public final class Pair<S, T> {

    private final S firstElm;
    private final T secElm;

    public Pair(S firstElm, T secElm) {
        this.firstElm = firstElm;
        this.secElm = secElm;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            return this.firstElm == pair.firstElm && this.secElm == pair.secElm;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstElm, secElm);
    }

    public S getFirstElm(){
        return firstElm;
    }

    public T getSecElm(){
        return secElm;
    }

    @Override
    public String toString(){
        return "FirstElm: " + getFirstElm() + ", " + "SecElm: " + getSecElm();
    }
}

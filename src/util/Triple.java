package util;

import java.util.Objects;

public class Triple<S, T, U> {

    private final S firstElm;
    private final T secElm;
    private final U thridElm;

    public Triple(S firstElm, T secElm, U thirdElm) {
        this.firstElm = firstElm;
        this.secElm = secElm;
        this.thridElm = thirdElm;
    }

    public S getFirstElm(){
        return firstElm;
    }

    public T getSecElm(){
        return secElm;
    }

    public U getThridElm(){
        return thridElm;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Triple) {
            Triple triple = (Triple)obj;
            return this.firstElm == triple.firstElm && this.secElm == triple.secElm && this.thridElm == triple.thridElm;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstElm, secElm, thridElm);
    }

    public String toString(){
        return "FirstElm: " + getFirstElm() + ", " + "SecElm: " + getSecElm() + ", " + "thirdElm: " + getThridElm();
    }


}

package vacation;

public enum PlusMinus {

    PLUS(1), MINUS(-1), NEUTRAL(0);

    final int term;

    PlusMinus(int term) {
        this.term = term;
    }

}

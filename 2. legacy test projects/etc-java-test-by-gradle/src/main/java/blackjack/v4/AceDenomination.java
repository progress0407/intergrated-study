package blackjack.v4;

class AceDenomination extends Denomination {

    public AceDenomination() {
        super("A", 0);
    }

    public void chooseAceScoreAs1() {
        System.out.println("1로 변경");
        super.score = 1;
    }

    public void chooseAceValueAs11() {
        System.out.println("11로 변경");
        this.score = 11;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return String.format("AceDenomination{%s %s}", super.name, super.score);
    }
}

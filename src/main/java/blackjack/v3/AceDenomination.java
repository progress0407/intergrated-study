package blackjack.v3;

import java.util.Objects;

class AceDenomination implements DenominationInterface {

    private Denomination denominationImpl;

    private final String name = "A";
    private int score = 0;

    public AceDenomination() {
    }

    @Override
    public void chooseAceScoreAs1() {
        System.out.println("1로 변경");
        this.score = 1;
    }

    @Override
    public void chooseAceValueAs11() {
        System.out.println("11로 변경");
        this.score = 11;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AceDenomination that = (AceDenomination) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "AceDenomination{" +
                "name='" + name + '\'' +
                ", value=" + score +
                '}';
    }
}

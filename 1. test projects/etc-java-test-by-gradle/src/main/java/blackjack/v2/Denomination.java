package blackjack.v2;

enum Denomination {
    TWO("2", 2),
    NINE("9", 9),
    JACK("10", 10),
    QUEEN("10", 10),
    KING("10", 10);

    public class ACE {
        private final String name = "A";
        private int value = 0;

        public void choiceValueOne() {
            System.out.println("1로 변경");
            this.value = 1;
        }

        public void choiceValueEleven() {
            System.out.println("11로 변경");
            this.value = 11;
        }
    }

    private final String name;
    int value;

    Denomination(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void choiceValueOne() {
        System.out.println("Denomination.choiceValueOne");
    }

    @Override
    public String toString() {
        return String.format("%s : %s", this.name(), value);
    }
}

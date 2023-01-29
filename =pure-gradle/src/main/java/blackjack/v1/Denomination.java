package blackjack.v1;

enum Denomination {
    ACE("A", 0) {
        public void chooseAceScoreAs1() {
            System.out.println("1로 변경");
            this.value = 1;
        }

        public void chooseAceValueAs11() {
            System.out.println("11로 변경");
            this.value = 11;
        }
    },
    TWO("2", 2),
    NINE("9", 9),
    JACK("10", 10),
    QUEEN("10", 10),
    KING("10", 10);

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

    public void chooseAceScoreAs1() {
        System.out.println("Denomination.chooseAceScoreAs1");
    }

    public void chooseAceValueAs11() {
        System.out.println("Denomination.chooseAceValueAs11");
    }

    @Override
    public String toString() {
        return String.format("%s : %s", this.name() ,value);
    }
}

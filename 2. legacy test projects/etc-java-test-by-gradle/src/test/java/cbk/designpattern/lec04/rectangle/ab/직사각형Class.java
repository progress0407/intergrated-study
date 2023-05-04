package cbk.designpattern.lec04.rectangle.ab;

@SuppressWarnings("NonAsciiCharacters")
class 직사각형Class {

    private int 가로;
    private int 세로;

    public 직사각형Class(int 가로, int 세로) {
        this.가로 = 가로;
        this.세로 = 세로;
    }

    public void set가로(int 가로) {
        this.가로 = 가로;
    }

    public void set세로(int 세로) {
        this.세로 = 세로;
    }

    public int get세로() {
        return 세로;
    }

    public int get가로() {
        return 가로;
    }

    @Override
    public String toString() {
        return "직사각형Class{" +
                "가로=" + 가로 +
                ", 세로=" + 세로 +
                '}';
    }
}

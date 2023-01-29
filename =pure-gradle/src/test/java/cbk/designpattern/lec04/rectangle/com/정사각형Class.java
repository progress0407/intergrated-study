package cbk.designpattern.lec04.rectangle.com;

@SuppressWarnings("NonAsciiCharacters")
public class 정사각형Class {

    private 직사각형Class 직사각형;

    public 정사각형Class(int 가로, int 세로) {
        직사각형.가로 = 가로;
        직사각형.세로 = 세로;
    }

    public void set가로(int 가로) {
        직사각형.set가로(가로);
        직사각형.set세로(가로);
    }

    public void set세로(int 세로) {
        직사각형.set가로(세로);
        직사각형.set세로(세로);
    }

    public int get가로() {
        return 직사각형.가로;
    }

    public int get세로() {
        return 직사각형.가로;
    }
}

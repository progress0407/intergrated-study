package cbk.designpattern.lec04.rectangle.ab;

@SuppressWarnings("NonAsciiCharacters")
public class 정사각형Class extends 직사각형Class {

    public 정사각형Class(int 가로, int 세로) {
        super(가로, 세로);
    }

    @Override
    public void set가로(int 가로) {
        super.set가로(가로);
        super.set세로(가로);
    }

    @Override
    public void set세로(int 세로) {
        super.set가로(세로);
        super.set세로(세로);
    }

    @Override
    public int get세로() {
        return super.get세로();
    }

    @Override
    public int get가로() {
        return super.get가로();
    }
}

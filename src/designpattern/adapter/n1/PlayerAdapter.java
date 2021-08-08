package designpattern.adapter.n1;

public class PlayerAdapter {

    private Object something;

    public PlayerAdapter(Object something) {
        this.something = something;
    }

    public void play() {
        if(something instanceof Music) {
            ((Music) something).playMusic();
        } else if (something instanceof Video) {
            ((Video)something).playMovie();
        } else {
            throw new IllegalArgumentException("지원하지 않는 포맷입니다");
        }
    }

}

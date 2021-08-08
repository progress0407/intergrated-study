package designpattern.adapter.n1;

public class MyMain {

    public static void main(String[] args) {
        Music something = new Music("너말고 니언니", "mp3", "320");
//        Video something = new Video("센치의 행방불명", "mkv", 1080, 29.7F);
        PlayerAdapter playerAdapter = new PlayerAdapter(something);
        playerAdapter.play();
    }
}

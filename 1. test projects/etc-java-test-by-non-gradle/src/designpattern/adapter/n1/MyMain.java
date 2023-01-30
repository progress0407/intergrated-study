package designpattern.adapter.n1;

public class MyMain {
    public static void main(String[] args) {
        Music music = new Music("너말고 니언니", "mp3", "320");
        PlayerAdapter player = new PlayerAdapterImpl(music);
        player.play();

        System.out.println("_________________________________________________");

        Video video = new Video("센치의 행방불명", "mkv", 1080, 29.7F);
        PlayerAdapter player2 = new PlayerAdapterImpl(video);
        player2.play();

        System.out.println("_________________________________________________");
        PlayerAdapter player3 = new PlayerAdapterImpl(new Object());
        player3.play();
    }
}

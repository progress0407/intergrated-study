package designpattern.adapter.n1;

public class Music {

    private String albumName;
    private String audioFormat;
    private String soundQuality;

    public Music(String albumName, String audioFormat, String soundQuality) {
        this.albumName = albumName;
        this.audioFormat = audioFormat;
        this.soundQuality = soundQuality + "kbps";
    }

    public void playMusic() {
        System.out.printf("[음악 재생] %s :: %s, %s \n", albumName, audioFormat, soundQuality);
    }
}

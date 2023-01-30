package designpattern.adapter.n1;

public class Video {

    private String movieName;
    private String videoFormat;
    private int videoResolution;
    private Float videoFrame;

    public Video(String movieName, String videoFormat, int videoResolution, Float videoFrame) {
        this.movieName = movieName;
        this.videoFormat = videoFormat;
        this.videoResolution = videoResolution;
        this.videoFrame = videoFrame;
    }

    public void playMovie() {
        System.out.printf("[영상 재생] %s ::\n", movieName);
        System.out.println("영상 포맷 :  " + videoFormat);
        System.out.printf("해상도 :  %dP\n",  videoResolution);
        System.out.printf("프레임 :  %.1f\n", videoFrame);
    }
}

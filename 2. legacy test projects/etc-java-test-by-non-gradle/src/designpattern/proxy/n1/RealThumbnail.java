package designpattern.proxy.n1;

public class RealThumbnail implements Thumbnail {

    private String movieUrl;
    private String title;

    public RealThumbnail(String movieUrl, String title) {
        this.movieUrl = movieUrl;
        this.title = title;
    }

    @Override
    public void showTitle() {
        System.out.println("\"" + this.movieUrl + "\" 의 제목은 \"" + this.title + "\" 입니다");
    }

    @Override
    public void showPreview() {
        System.out.println("기다리는 중입니다 ...");
        System.out.println(this.movieUrl + "로 부터 " + this.title + "를 다운 받습니다");
    }
}

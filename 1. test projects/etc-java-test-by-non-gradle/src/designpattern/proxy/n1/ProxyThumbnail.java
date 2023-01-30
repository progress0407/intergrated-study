package designpattern.proxy.n1;

public class ProxyThumbnail implements Thumbnail {

    private String movieUrl;
    private String title;

    public ProxyThumbnail(String movieUrl, String title) {
        this.movieUrl = movieUrl;
        this.title = title;
    }

    @Override
    public void showTitle() {
        System.out.println("제목은"  + this.title + "\" 입니다");
    }

    @Override
    public void showPreview() {
        ((Thumbnail) new RealThumbnail(this.movieUrl, this.title)).showPreview();
    }
}

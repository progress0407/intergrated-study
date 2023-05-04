package designpattern.proxy.n1;

import java.util.ArrayList;
import java.util.List;

public class MyProgram {
    public static void main(String[] args) {
        List<Thumbnail> proxyThumbnails = new ArrayList<>();

        proxyThumbnails.add(new ProxyThumbnail("/movie?name=darknight", "배트맨 다크나이트"));
        proxyThumbnails.add(new ProxyThumbnail("/movie?name=sen-chihiro", "센과 치히로의 행방불명"));
        proxyThumbnails.add(new ProxyThumbnail("/movie?name=home-alone", "나 홀로 집에"));
        proxyThumbnails.add(new ProxyThumbnail("/movie?name=new-world", "신세계"));
        proxyThumbnails.add(new ProxyThumbnail("/movie?name=gurren-lagann", "천원돌파 그렌라간"));

        proxyThumbnails.stream().iterator().forEachRemaining(thumbnail -> thumbnail.showTitle());

        System.out.println("___________________________________________________");

        proxyThumbnails.stream().iterator().forEachRemaining(thumbnail -> thumbnail.showPreview());
    }
}

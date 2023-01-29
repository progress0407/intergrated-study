package crawling.practice;

import lombok.SneakyThrows;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import static java.lang.System.out;

public class CrawlingPractice {

    @SneakyThrows
    public static void main(final String... args) {
        crawl_inflearn();
        crawl_book_naver();
    }

    private static void crawl_inflearn() throws IOException {
        final String url = "https://www.inflearn.com/courses/it-programming";
        Connection conn = Jsoup.connect(url);

        Document document = conn.get();
        Elements imageUrlElements = document.getElementsByClass("swiper-lazy");
        for (Element element : imageUrlElements) {
            out.println("element = " + element);
        }
    }

    @SneakyThrows
    private static void crawl_book_naver() {
        String url = "https://book.naver.com/search/search.naver?sm=sta_hty.book&sug=&where=nexearch&query=%EB%A6%AC%EC%B2%98%EB%93%9C+%ED%8C%8C%EC%9D%B8%EB%A7%8C";

        Connection conn = Jsoup.connect(url);
        Document document = conn.get();

        Elements elements = document.select("img[src*=\"https://book\"]");
        for (Element element : elements) {
            out.println("element = " + element);
        }

        out.println();
        out.println();

        Elements elements2 = document.select("li > dl > dt");
        for (Element element : elements2) {
            out.println("element = " + element);
        }
    }
}

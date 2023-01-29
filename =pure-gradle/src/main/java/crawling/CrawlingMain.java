package crawling;

import static java.lang.System.out;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@Slf4j
public class CrawlingMain {

    public static final String STACKOVERFLOW_URL = "https://stackoverflow.com";

    @SneakyThrows
    public static void main(final String... args) {
        crawl_stackOverFlow();
    }

    @SneakyThrows
    private static void crawl_stackOverFlow() {
        final String url = STACKOVERFLOW_URL + "/questions";
        Connection conn = Jsoup.connect(url);
        Document document = conn.get();

        Elements elements = document.select(".s-post-summary--content  .s-link");

        for (Element element : elements) {
            String href = element.attr("href");
            String contentUrl = STACKOVERFLOW_URL + href;

            log.info("#1 contentUrl = {}", contentUrl);
            crawl_stackOverFlow_inner(contentUrl);
        }
    }

    @SneakyThrows
    private static void crawl_stackOverFlow_inner(String url) {
        Connection conn = Jsoup.connect(url);

        Document document = conn.get();

        String questionSubject = document.getElementsByClass("question-hyperlink").text();
        log.info("##1 questionSubject = {}", questionSubject);

        String count = document.getElementsByClass("js-vote-count").text();
        log.info("##2 count = {}", count);

        String questionContent = document.getElementsByClass("js-post-body").text();
        log.info("##3 questionContent = {}", questionContent);

        Elements answerContents = document.select("js-post-body");

        for (Element answerContent : answerContents) {
            log.info("##4 answerContent = {}", answerContent);
        }
    }
}

package org.ivanovx.crawlers;

import org.ivanovx.DefaultHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.format.DateTimeFormatter;
import java.util.stream.IntStream;

public class BtvCrawler implements Crawler {
    private final static Logger logger = LoggerFactory.getLogger(BtvCrawler.class);

    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm, dd.MM.yyyy");

    private final static String url = "https://btvnovinite.bg/bulgaria?page=";

    @Override
    public String call() throws Exception {
        IntStream
                .range(1, 100)
                .forEach(page -> {
                    String htmlContent = DefaultHttpClient.GET(url + page);

                    Document document = Jsoup.parse(htmlContent);

                    document
                            .body()
                            .select(".news-articles-inline .news-article-inline > a")
                            .stream()
                            .forEach(element -> {
                                String title = element
                                        .select(".info-article > .title")
                                        .text();

                                logger.info(title);

                                //LocalDateTime fd = LocalDateTime.parse(date, formatter);

                               /* CrawlerOutputModel model = new CrawlerOutputModel(
                                        element.attr("href"),
                                        fd,
                                        "BNT News",
                                        element.attr("title"),
                                        this.getContent(element.attr("href"))
                                );

                                System.out.println(model);*/
                            });
                });

        return "Ok";
    }
}

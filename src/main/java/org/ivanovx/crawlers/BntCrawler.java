package org.ivanovx.crawlers;

import org.ivanovx.DefaultHttpClient;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Callable;
import java.util.stream.IntStream;

public class BntCrawler implements Crawler {
    private final static Logger logger = LoggerFactory.getLogger(BntCrawler.class);

    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm, dd.MM.yyyy");

    private final static String url = "https://bntnews.bg/bg/c/bulgaria?page=";

    private LocalDateTime parseDate(String date) {
        return LocalDateTime.parse(date, formatter);
    }

    private String getContent(String url) {
        String htmlContent = DefaultHttpClient.GET(url);

        Document document = Jsoup.parse(htmlContent);

        return document.body().select(".txt-news").text();
    }

    @Override
    public String call() throws Exception {
        IntStream
                .range(1, 100)
                .forEach(page -> {
                    String htmlContent = DefaultHttpClient.GET(url + page);

                    Document document = Jsoup.parse(htmlContent);

                    document
                            .body()
                            .select(".news-wrap-view > a")
                            .stream()
                            .forEach(element -> {
                                String date = element
                                        .select(".news-time")
                                        .text()
                                        .replace("(обновена)", "")
                                        .trim();

                                logger.info(element.attr("title"));

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
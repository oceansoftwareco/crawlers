package org.ivanovx.crawlers;

import org.ivanovx.DefaultHttpClient;
import org.ivanovx.crawlers.model.CrawlerOutputModel;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.annotation.Documented;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.IntStream;

public class BntCrawler implements Runnable {
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm, dd.MM.yyyy");

    private final static String url = "https://bntnews.bg/bg/c/bulgaria?page=";

    @Override
    public void run() {
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

                                LocalDateTime fd = LocalDateTime.parse(date, formatter);

                                CrawlerOutputModel model = new CrawlerOutputModel(
                                        element.attr("href"),
                                        fd,
                                        "BNT News",
                                        element.attr("title"),
                                        this.getContent(element.attr("href"))
                                );

                                System.out.println(model);
                            });
                });
    }

    private String getContent(String url) {
        String htmlContent = DefaultHttpClient.GET(url);

        Document document = Jsoup.parse(htmlContent);

        return document.body().select(".txt-news").text();
    }
}

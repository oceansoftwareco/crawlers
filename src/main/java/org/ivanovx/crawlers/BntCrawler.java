package org.ivanovx.crawlers;

import org.ivanovx.DefaultHttpClient;

import org.ivanovx.models.News;
import org.ivanovx.models.Source;
import org.ivanovx.respositories.NewsRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.IntStream;

public class BntCrawler extends BaseCrawler {
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm, dd.MM.yyyy");

    public BntCrawler() {
        this.setUrl("https://bntnews.bg/bg/c/bulgaria?page=");
    }

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
                    String htmlContent = DefaultHttpClient.GET(this.getUrl() + page);

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

                                News news = new News();

                                news.setUrl(element.attr("href"));
                                news.setTitle(element.attr("title"));
                                news.setContent(this.getContent(element.attr("href")));
                                news.setDate(this.parseDate(date));
                                news.setSource(Source.BNT);

                                System.out.println(news);

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
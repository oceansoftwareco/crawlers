package org.ivanovx.crawlers;

import org.ivanovx.DefaultHttpClient;

import org.ivanovx.models.News;
import org.ivanovx.models.Source;
import org.ivanovx.respositories.NewsRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.IntStream;

public class BntCrawler extends BaseCrawler {
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm, dd.MM.yyyy");

    public BntCrawler() {
        super("https://bntnews.bg/bg/c/bulgaria?page=");
    }

    private LocalDateTime parseDate(String date) {
        return LocalDateTime.parse(date, formatter);
    }

    private String getContent(String url) {
        Document document = DefaultHttpClient.GET(url);

        String content = document
                .body()
                .select(".txt-news")
                .text();

        return content;
    }

    @Override
    public List<News> call() throws Exception {
        List<News> collectedNews = IntStream.range(1, 10).mapToObj(page -> {
            Document document = DefaultHttpClient.GET(this.getUrl() + page);

            List<News> newsList = document
                    .body()
                    .select(".news-wrap-view > a")
                    .stream()
                    .map(element -> {
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

                        this.logger.info(String.valueOf(news));

                        return  news;
                    }).toList();

            return newsList;
        }).flatMap(List::stream).toList();

        this.logger.info("Collected %s news".formatted(collectedNews.size()));

        return collectedNews;
    }
}
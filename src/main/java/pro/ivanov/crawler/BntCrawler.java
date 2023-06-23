package pro.ivanov.crawler;

import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pro.ivanov.util.DefaultHttpClient;
import pro.ivanov.entity.News;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.IntStream;

public class BntCrawler {
    //private final Logger logger = LoggerFactory.getLogger(BntCrawler.class);

    private LocalDateTime parseDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm, dd.MM.yyyy");

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

    public List<News> call() {
        List<News> collectedNews = IntStream.range(1, 50).mapToObj(page -> {
            Document document = DefaultHttpClient.GET("https://bntnews.bg/bg/c/bulgaria?page=" + page);

            List<News> newsList = document
                    .body()
                    .select(".news-wrap-view > a")
                    .stream()
                    .map(element -> {
                        String rawDate = element
                                .select(".news-time")
                                .text()
                                .replace("(обновена)", "")
                                .trim();

                        String url = element.attr("href");
                        String title = element.attr("title");

                        News news = new News();

                        LocalDateTime dateTime = this.parseDate(rawDate);
                        LocalDate date = dateTime.toLocalDate();

                        news.setUrl(url);
                        news.setTitle(title);
                        news.setContent(this.getContent(url));
                        news.setDate(date);
                        news.setTimestamp(dateTime);
                        //news.setSource(Source.BNT);

                        //this.logger.info(String.valueOf(news));

                        return news;
                    }).toList();

            return newsList;
        }).flatMap(List::stream).toList();

        //this.logger.info("Collected %s news".formatted(collectedNews.size()));

        return collectedNews;
    }
}
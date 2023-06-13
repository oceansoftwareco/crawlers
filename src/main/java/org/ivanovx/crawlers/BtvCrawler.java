package org.ivanovx.crawlers;

import org.ivanovx.DefaultHttpClient;
import org.ivanovx.models.News;
import org.ivanovx.models.Source;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BtvCrawler implements Crawler {
    private final String url = "https://btvnovinite.bg/bulgaria?page=";

    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm, dd.MM.yyyy");

    private String getContent(String url) {
        Document document = DefaultHttpClient.GET(url);

        String content = document
                .body()
                .select(".article-body")
                .text();

        return content;
    }

    @Override
    public List<News> call() throws Exception {
        List<News> collectedNews = IntStream.range(1, 10).mapToObj(page -> {
            Document document = DefaultHttpClient.GET(this.url + page);

            List<News> newsList = document
                    .body()
                    .select(".news-articles-inline .news-article-inline > a")
                    .stream()
                    .map(element -> {
                        String title = element
                                .select(".info-article > .title")
                                .text();

                        String date = element
                                .select(".info-article > .date")
                                .text();

                        String url = "https://btvnovinite.bg/bulgaria" + element.attr("href");

                        String content = this.getContent(url);

                        News news = new News();

                        news.setTitle(title);
                        news.setContent(content);
                        news.setSource(Source.BTV);
                        news.setUrl(url);

                        //this.logger.info(String.valueOf(news));

                        return news;
                    }).toList();

            return newsList;
        }).flatMap(List::stream).toList();

        //this.logger.info("Collected %s news".formatted(collectedNews.size()));

        return collectedNews;
    }
}

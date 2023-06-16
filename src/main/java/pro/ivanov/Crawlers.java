package pro.ivanov;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pro.ivanov.crawler.BntCrawler;
import pro.ivanov.repository.NewsRepository;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Crawlers {
    private final NewsRepository newsRepository;

    private final Logger logger = LoggerFactory.getLogger(Crawlers.class);

    public Crawlers(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

   // @PostConstruct
    public void execute() throws ExecutionException, InterruptedException {
        try (ExecutorService service = Executors.newSingleThreadExecutor()) {
             var bnt = service.submit(new BntCrawler());

             //while (!bnt.isDone()) {}

             var savedNews = this.newsRepository.saveAll(bnt.get());

             this.logger.info("Saved %d news".formatted(savedNews.size()));
        }
    }
}

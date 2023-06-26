package pro.ivanov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pro.ivanov.crawler.BntCrawler;
import pro.ivanov.crawler.CrawlerResult;
import pro.ivanov.entity.News;
import pro.ivanov.repository.NewsRepository;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Component
public class ApplicationInit implements ApplicationRunner {
    private final NewsRepository newsRepository;

    public ApplicationInit(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //this.newsRepository.save(new News());
        ExecutorService service = Executors.newSingleThreadExecutor();
        //try (ExecutorService service = Executors.newSingleThreadExecutor()) {
            Future<CrawlerResult> bntTask = service.submit(new BntCrawler());

            List<News> needToSaveNews = bntTask.get().news();

            newsRepository.saveAll(needToSaveNews);
       // }
        // this.newsRepository.saveAll(task.get());
    }
}

package pro.ivanov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pro.ivanov.crawler.BntCrawler;
import pro.ivanov.crawler.CrawlerResult;
import pro.ivanov.entity.News;
import pro.ivanov.repository.NewsRepository;

import java.util.List;
import java.util.concurrent.ExecutionException;
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
        //ExecutorService service = Executors.newSingleThreadExecutor();
        //try (ExecutorService service = Executors.newSingleThreadExecutor()) {
          //  Future<CrawlerResult> bntTask = service.submit(new BntCrawler());

         //   List<News> needToSaveNews = bntTask.get().news();

         //   newsRepository.saveAll(needToSaveNews);
       // }
        // this.newsRepository.saveAll(task.get());

        if (this.newsRepository.count() == 0) {
            this.getAllNews();
        }
    }

   private void getAllNews() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<CrawlerResult> bntTask = service.submit(new BntCrawler(25));
        List<News> needToSaveNews = bntTask.get().news();

        this.newsRepository.saveAll(needToSaveNews);
    }

    @Scheduled(cron = "0 * * * * *")
    public void getDailyNews() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<CrawlerResult> bntTask = service.submit(new BntCrawler(5));

        List<News> needToSaveNews = bntTask.get().news();//.stream().filter(news -> this.newsRepository.existsByTitleAndDate(news.getTitle(), news.getDate())).toList();

        this.newsRepository.saveAll(needToSaveNews);
    }
}

package pro.ivanov;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
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
public class OnStartup implements ApplicationListener<ContextRefreshedEvent> {
    //private final TaskExecutor taskExecutor;

    //private final Logger logger = LoggerFactory.getLogger(OnStartup.class);

    private final NewsRepository newsRepository;

    public OnStartup(/*TaskExecutor taskExecutor,*/ NewsRepository newsRepository) {
       // this.taskExecutor = taskExecutor;
        this.newsRepository = newsRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
       // this.runCrawlers();

        //BntCrawler bntCrawler = new BntCrawler();

       // List<News> collectedNews = bntCrawler.call();

        //this.newsRepository.saveAll(collectedNews);
    }

    @Async
    protected void runCrawlers() {
        //taskExecutor.
        /*taskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Future<CrawlerResult> task = new BntCrawler();
            }
        });*/
        /*try (ExecutorService service = Executors.newSingleThreadExecutor()) {
            Future<CrawlerResult> bntTask = service.submit(new BntCrawler());

            List<News> needToSaveNews = bntTask.get().news();

            this.newsRepository.saveAll(needToSaveNews);
            // this.newsRepository.saveAll(task.get());
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
    }
}

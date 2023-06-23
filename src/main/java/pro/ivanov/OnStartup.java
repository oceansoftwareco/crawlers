package pro.ivanov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pro.ivanov.crawler.BntCrawler;
import pro.ivanov.repository.NewsRepository;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class OnStartup implements ApplicationListener<ContextRefreshedEvent> {
    //private final Logger logger = LoggerFactory.getLogger(OnStartup.class);

    private final NewsRepository newsRepository;

    public OnStartup(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        /*try (ExecutorService service = Executors.newSingleThreadExecutor()) {
            var task = service.submit(new BntCrawler());

            this.newsRepository.saveAll(task.get());
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }*/
    }
}

package org.ivanovx;

import org.ivanovx.crawlers.BntCrawler;
import org.ivanovx.crawlers.BtvCrawler;
import org.ivanovx.crawlers.Crawler;
import org.ivanovx.respositories.NewsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class Application implements ApplicationRunner {
    public static Logger logger = LoggerFactory.getLogger(Application.class);

    private final NewsRepository newsRepository;

    @Autowired
    public Application(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

      /*  try (StructuredTaskScope<Crawler> scope = new StructuredTaskScope()) {
            scope.fork(BntCrawler::new);

            scope.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        /*List<Crawler> crawlers = List.of(
                new BntCrawler()
                //new BtvCrawler()
        );*/

       /* try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            //executor.invokeAll(crawlers);
            //var btvTask = executor.submit(new BtvCrawler());
          //  var bntTask = executor.submit(new BntCrawler());

            //this.newsRepository.saveAll(btvTask.get());
            this.newsRepository.saveAll(bntTask.get());

            logger.info(String.valueOf("Size of all collected news %s".formatted(bntTask.get().size())));
            //logger.info(String.valueOf("Size of all collected news %s".formatted(btvTask.get().size())));

            //this.newsRepository.saveAll(task.get());
        }*/
    }
}
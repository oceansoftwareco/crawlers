package org.ivanovx;

import org.ivanovx.crawlers.BaseCrawler;
import org.ivanovx.crawlers.BntCrawler;
import org.ivanovx.crawlers.BtvCrawler;
import org.ivanovx.crawlers.Crawler;
import org.ivanovx.respositories.NewsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.List;
import java.util.ServiceLoader;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class Application extends SpringBootServletInitializer implements ApplicationRunner {
    private static Logger logger = LoggerFactory.getLogger(Application.class);

    private final NewsRepository newsRepository;

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
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        /*List<Crawler> crawlers = List.of(
                new BntCrawler()
                //new BtvCrawler()
        );*/

        /*try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            //executor.invokeAll(crawlers);
            //var btvTask = executor.submit(new BtvCrawler());
            var bntTask = executor.submit(new BntCrawler());

           // this.newsRepository.saveAll(btvTask.get());
            this.newsRepository.saveAll(bntTask.get());

            logger.info(String.valueOf("Size of all collected news %s".formatted(bntTask.get().size())));
            //logger.info(String.valueOf("Size of all collected news %s".formatted(btvTask.get().size())));

            //this.newsRepository.saveAll(task.get());
        }*/
    }
}
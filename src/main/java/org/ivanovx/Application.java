package org.ivanovx;

import org.ivanovx.crawlers.BaseCrawler;
import org.ivanovx.crawlers.BntCrawler;
import org.ivanovx.crawlers.BtvCrawler;
import org.ivanovx.crawlers.Crawler;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.ServiceLoader;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class Application implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        /*Thread t = new Thread(new BntCrawler());

        t.start();*/


      /*  try (StructuredTaskScope<Crawler> scope = new StructuredTaskScope()) {
            scope.fork(BntCrawler::new);

            scope.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Crawler> crawlers = List.of(
                new BntCrawler()
                //new BtvCrawler()
        );

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.invokeAll(crawlers);
        }
    }
}
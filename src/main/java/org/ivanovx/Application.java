package org.ivanovx;

import org.ivanovx.crawlers.BntCrawler;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
        new BntCrawler().run();
    }
}
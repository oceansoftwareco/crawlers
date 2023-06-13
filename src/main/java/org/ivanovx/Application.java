package org.ivanovx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application /* implements ApplicationRunner */ {
   // private static Logger logger = LoggerFactory.getLogger(Application.class);

  //  private final NewsRepository newsRepository;

   // public Application(NewsRepository newsRepository) {
   //     this.newsRepository = newsRepository;
  //  }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

      /*  try (StructuredTaskScope<Crawler> scope = new StructuredTaskScope()) {
            scope.fork(BntCrawler::new);

            scope.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
    }

   // @Override
   // public void run(ApplicationArguments args) throws Exception {
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
   // }
}
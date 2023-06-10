package org.ivanovx;

import org.ivanovx.crawlers.BntCrawler;

public class Application {
    public static void main(String[] args) {
        Thread t = new Thread(new BntCrawler());

        t.start();


      /*  try (StructuredTaskScope<Crawler> scope = new StructuredTaskScope()) {
            scope.fork(BntCrawler::new);

            scope.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
    }
}
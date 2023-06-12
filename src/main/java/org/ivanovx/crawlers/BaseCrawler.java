package org.ivanovx.crawlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseCrawler implements Crawler {
    private String url;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public BaseCrawler(String url) {
        this.url = url;
    }

    public String getUrl(){
        return this.url;
    }
}
package org.ivanovx.crawlers;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseCrawler implements Crawler {

    @Getter
    private final String url;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public final static int PAGES = 10;

    public BaseCrawler(String url) {
        this.url = url;
    }
}
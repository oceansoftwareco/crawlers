package org.ivanovx.crawlers.model;

import java.time.LocalDateTime;

public record CrawlerOutputModel(String url, LocalDateTime date, String source, String title, String content) { }
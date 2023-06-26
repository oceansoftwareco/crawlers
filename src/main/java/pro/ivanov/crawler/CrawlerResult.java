package pro.ivanov.crawler;

import pro.ivanov.entity.News;

import java.util.List;

public record CrawlerResult(List<News> news) { }

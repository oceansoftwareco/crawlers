package org.ivanovx.crawlers;

import org.ivanovx.models.News;

import java.util.List;
import java.util.concurrent.Callable;

public interface Crawler extends Callable<List<News>> { }
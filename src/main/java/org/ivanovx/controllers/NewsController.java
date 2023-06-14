package org.ivanovx.controllers;

import org.ivanovx.models.News;
import org.ivanovx.respositories.NewsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NewsController {

    private final NewsRepository newsRepository;

    public NewsController(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @GetMapping("/")
    public String index(Pageable pageable, Model model) {
        Page<News> page = this.newsRepository.findAll(pageable);

        model.addAttribute("previousPage", page.previousOrFirstPageable());
        model.addAttribute("page", page);
        model.addAttribute("nextPage", page.nextOrLastPageable());

        return "index";
    }

    @GetMapping("/{id}")
    public String news(@PathVariable long id, Model model) {
        News news = this.newsRepository.findById(id).orElseThrow();

        model.addAttribute("news", news);

        return "news";
    }
}

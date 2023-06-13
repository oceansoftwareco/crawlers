package org.ivanovx.controllers;

import org.ivanovx.respositories.NewsRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewsController {

    private final NewsRepository newsRepository;

    public NewsController(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @GetMapping("/")
    public String index(Pageable pageable, Model model) {
        var page = this.newsRepository.findAll(pageable);

        model.addAttribute("page", page);

        return "index";
    }
}

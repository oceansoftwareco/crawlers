package org.ivanovx.controllers;

import org.ivanovx.respositories.NewsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/archive")
public class ArchiveController {
    private final NewsRepository newsRepository;

    public ArchiveController(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }


    @GetMapping("/{day}/{month}/{year}")
    public String index(
            @PathVariable int day,
            @PathVariable int month,
            @PathVariable int year,
            Model model) {
        return "archive";
    }
}

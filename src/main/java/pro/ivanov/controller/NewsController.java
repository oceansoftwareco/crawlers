package pro.ivanov.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pro.ivanov.entity.News;
import pro.ivanov.repository.NewsRepository;
import pro.ivanov.util.DefaultDateTime;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {
    private final NewsRepository newsRepository;

    public NewsController(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @GetMapping("{date}")
    public String index(@PathVariable String date, Pageable pageable, Model model) {
        LocalDate value = LocalDate.parse(date, DefaultDateTime.defaultFormatter());

        Page<News> page = this.newsRepository.findAllByDate(value, pageable);

        model.addAttribute("previousPage", page.previousOrFirstPageable());
        model.addAttribute("page", page);
        model.addAttribute("nextPage", page.nextOrLastPageable());

        return "index";
    }

   /* @GetMapping("{id}")
    public String news(@PathVariable long id, Model model) {
        News news = this.newsRepository.findById(id).orElseThrow();

        model.addAttribute("news", news);

        return "news";
    }*/
}

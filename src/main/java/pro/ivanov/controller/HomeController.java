package pro.ivanov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pro.ivanov.util.DefaultDateTime;

import java.time.LocalDate;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index() {
        LocalDate today = LocalDate.now();

        String url = "redirect:/news/%s".formatted(today.format(DefaultDateTime.defaultFormatter()));

        return url;
    }
}

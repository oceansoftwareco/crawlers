package pro.ivanov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pro.ivanov.util.DefaultDateTime;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "redirect:/news";
    }
}

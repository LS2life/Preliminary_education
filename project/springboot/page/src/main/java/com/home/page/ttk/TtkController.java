package com.home.page.ttk;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TtkController {

    @RequestMapping("/")
    @ResponseBody
    public String index(Locale locale, Model model) {
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 (E) a hh시 mm분 ss초");
        String formattedNow = now.format(formatter);

        model.addAttribute("serverTime",formattedNow);

        return "home";
    }
}

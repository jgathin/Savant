package com.test.Savant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String indexPage(Model model) {

        String welcome = "Welcome to the Savant Layout Tool Designers!";
        String title = "Savant Layout Tool";

        model.addAttribute("title", title);
        model.addAttribute("welcome", welcome);

        return "index";
    }
}

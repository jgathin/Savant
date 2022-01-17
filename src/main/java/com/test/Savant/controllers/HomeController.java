package com.test.Savant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String displayHomePage(Model model)  {

        model.addAttribute("title", "Welcome Designers!");

        return "index";
    }
}

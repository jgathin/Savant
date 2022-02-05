package com.test.Savant.controllers;

import com.test.Savant.User;
import com.test.Savant.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    private static final String userSessionKey = "user";

    public User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) {
            return null;
        }

        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            return null;

        }

        return user.get();
    }


    @GetMapping("/index")
    public String indexPage(Model model) {

        String welcome = "Welcome to the Savant Layout Tool Designers!";
        String title = "Savant Layout Tool";

        model.addAttribute("title", title);
        model.addAttribute("welcome", welcome);

        return "index";
    }

    @GetMapping("/admin")
    public String adminHomePage(Model model, HttpServletRequest request) {
        User user = (User) getUserFromSession(request.getSession());

        model.addAttribute("user", user);
        model.addAttribute("title", "Admin Home Page");

        return "admin";
    }
}

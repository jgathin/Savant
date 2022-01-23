package com.test.Savant.controllers;

import com.test.Savant.User;
import com.test.Savant.data.SavControlRepository;
import com.test.Savant.data.UserRepository;
import com.test.Savant.models.SavControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("control")
public class SavControlController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SavControlRepository savControlRepository;

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

    @GetMapping("index")
    public String displaySavControlIndex(Model model, HttpServletRequest request) {
        User user = getUserFromSession(request.getSession());

        model.addAttribute("title", "Savant Controllers");
        model.addAttribute("controllers", savControlRepository.findAll());

        return "control/index";
    }

    @GetMapping("add")
    public String displayAddSavControlPage(Model model, HttpServletRequest request) {
        User user = getUserFromSession(request.getSession());

        model.addAttribute("title", "Add Savant Controller");
        model.addAttribute(new SavControl());

        return "control/add";
    }

    @PostMapping("add")
    public String renderAddSavantControlPage(@ModelAttribute @Valid SavControl newSavControl,
                                             HttpServletRequest request, Errors errors,Model model) {
        User user = getUserFromSession(request.getSession());

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Savant Controllers");
            return "control/add";
        }

        savControlRepository.save(newSavControl);

        return "redirect:detail?savControlId=" + newSavControl.getId();
    }
}

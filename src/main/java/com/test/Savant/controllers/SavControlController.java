package com.test.Savant.controllers;

import com.test.Savant.User;
import com.test.Savant.data.SavControlRepository;
import com.test.Savant.data.UserRepository;
import com.test.Savant.models.SavControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public String displaySavControlIndex(Model model, HttpServletRequest request) {
        User user = getUserFromSession(request.getSession());

        model.addAttribute("user", user);
        model.addAttribute("title", "Savant Controllers");
        model.addAttribute("controllers", savControlRepository.findAll());

        return "control/index";
    }

    @GetMapping("add")
    public String displayAddSavControlPage(Model model, HttpServletRequest request) {
        User user = getUserFromSession(request.getSession());

        model.addAttribute("user", user);
        model.addAttribute("title", "Add Savant Controller");
        model.addAttribute("savControl", new SavControl());

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

        return "redirect:";
    }

    @GetMapping("detail")
    public String displaySavantControlDetailPage(@RequestParam Integer savControlId, Model model, HttpServletRequest request) {
        User user = getUserFromSession(request.getSession());

        Optional<SavControl> result = savControlRepository.findById(savControlId);

        if (result.isEmpty()){
            model.addAttribute("title", "Invalid Savant Controller ID " + savControlId);
        } else {
            SavControl newSavControl = result.get();
            model.addAttribute("user", user);
            model.addAttribute("title", newSavControl.getModel() + " Details");
            model.addAttribute("controller", newSavControl);
        }
            return "control/detail";
        }

    @GetMapping("edit/{savControlId}")
    public String displayEditSavantControlPage(@PathVariable Integer savControlId, Model model,
                                               HttpServletRequest request) {
        User user = getUserFromSession(request.getSession());

        Optional<SavControl> result = savControlRepository.findById(savControlId);
        SavControl editSavControl = result.get();
        model.addAttribute("user", user);
        model.addAttribute("title", "Edit " + editSavControl.getModel());
        model.addAttribute("savControl", editSavControl);

        return "control/edit";
    }

    @PostMapping("edit")
    public String processEditSavantControlPage(@ModelAttribute @Valid SavControl savControl, Integer savControlId,
                                               Errors errors, HttpServletRequest request, Model model) {
        User user = getUserFromSession(request.getSession());

        SavControl newSavControl = savControlRepository.findById(savControl.getId());
//        SavControl newSavControl = result.get();

        if (errors.hasErrors()) {
            model.addAttribute("title", "Edit " + newSavControl.getModel());
            return "control/edit";
        }

        savControlRepository.save(savControl);

        return "redirect:";
    }

}

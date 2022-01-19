package com.test.Savant.controllers;

import com.test.Savant.User;
import com.test.Savant.data.HostRepository;
import com.test.Savant.data.UserRepository;
import com.test.Savant.models.Host;
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
@RequestMapping("host")
public class HostController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    HostRepository hostRepository;

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
    public String displayIndexPage(Model model, HttpServletRequest request) {
        User user = (User) getUserFromSession(request.getSession());

        model.addAttribute("user", user);
        model.addAttribute("title", "Hosts");
        model.addAttribute("hosts", hostRepository.findAll());

        return "host/index";
    }

    @GetMapping("add")
    public String displayAddHostForm(Model model, HttpServletRequest request) {
        User user = (User) getUserFromSession(request.getSession());

        model.addAttribute("user", user);
        model.addAttribute("title", "Add Host");
        model.addAttribute(new Host());

        return "host/add";
    }

    @PostMapping("add")
    public String processAddHostForm(@ModelAttribute @Valid Host newHost, Errors errors, Model model,
                                     HttpServletRequest request) {
        User user = (User) getUserFromSession(request.getSession());

        if (errors.hasErrors()) {
            model.addAttribute("user", user);
            model.addAttribute("title", "Add Host");
            return "host/add";
        }

        hostRepository.save(newHost);

        return "redirect:host";
    }

    @GetMapping("detail")
    public String displayHostDetailPage(@RequestParam Integer hostId, Model model, HttpServletRequest request) {
        User user = (User) getUserFromSession(request.getSession());

        Optional<Host> result = hostRepository.findById(hostId);

        if (result.isEmpty()) {
            model.addAttribute("user", user);
            model.addAttribute("title", "Invalid Host ID: " + hostId);
        } else {
            Host host = result.get();
            model.addAttribute("user", user);
            model.addAttribute("title", host.getModel() + " Details");
            model.addAttribute("host", host);

        }
        return "host/detail";
    }

}

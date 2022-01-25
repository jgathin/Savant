package com.test.Savant.controllers;

import com.test.Savant.User;
import com.test.Savant.data.AudioDevRepository;
import com.test.Savant.data.UserRepository;
import com.test.Savant.models.AudioDevice;
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
@RequestMapping("audiodev")
public class AudioDeviceController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AudioDevRepository audioDevRepository;

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
    public String displayAudioDevIndex(Model model, HttpServletRequest request) {
        User user = getUserFromSession(request.getSession());

        model.addAttribute("title", "Savant Audio Devices");
        model.addAttribute("audioDevices", audioDevRepository.findAll());

        return "audiodev/index";
    }

    @GetMapping("add")
    public String displayAddAudioDevPage(Model model, HttpServletRequest request) {
        User user = getUserFromSession(request.getSession());

        model.addAttribute("title", "Add Savant Audio Device");
        model.addAttribute("audioDevice", new AudioDevice());

        return "audiodev/add";
    }

    @PostMapping("add")
    public String renderAddSavantControlPage(@ModelAttribute @Valid AudioDevice newAudioDevice,
                                             HttpServletRequest request,
                                             Errors errors, Model model) {
        User user = getUserFromSession(request.getSession());

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Savant Audio Device");
            return "audiodev/add";
        }

        audioDevRepository.save(newAudioDevice);

        return "redirect:";
    }

    @GetMapping("detail")
    public String displaySavantControlDetailPage(@RequestParam Integer audioDeviceId, Model model,
                                                 HttpServletRequest request) {
        User user = getUserFromSession(request.getSession());

        Optional<AudioDevice> result = audioDevRepository.findById(audioDeviceId);

        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid Savant Audio Device ID " + audioDeviceId);
        } else {
            AudioDevice newAudioDevice = result.get();
            model.addAttribute("title", newAudioDevice.getModel() + " Details");
            model.addAttribute("audioDevice", newAudioDevice);
        }
            return "audiodev/detail";
    }
}


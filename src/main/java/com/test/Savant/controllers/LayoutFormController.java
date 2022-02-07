package com.test.Savant.controllers;

import com.test.Savant.User;
import com.test.Savant.data.*;
import com.test.Savant.dto.LayoutFormDTO;
import com.test.Savant.dto.ZoneFormDTO;
import com.test.Savant.models.AudioDevice;
import com.test.Savant.models.Host;
import com.test.Savant.models.SavControl;
import com.test.Savant.models.zone.Zone;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("layout")
public class LayoutFormController {

    @Autowired
    LayoutRepository layoutRepository;
    @Autowired
    HostRepository hostRepository;
    @Autowired
    SavControlRepository savControlRepository;
    @Autowired
    AudioDevRepository audioDevRepository;
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

    public int videoZones;
    public int totalZones;

    @GetMapping("layout")
    public String displayLayoutForm(Model model, HttpServletRequest request) {
        User user = (User) getUserFromSession(request.getSession());

        model.addAttribute("user", user);
        model.addAttribute("title", "Layout Form");
        model.addAttribute(new LayoutFormDTO());

        return "layout/layout";
    }

    @PostMapping("layout")
    public String renderLayoutForm(@ModelAttribute @Valid LayoutFormDTO layoutFormDTO,
                                   HttpServletRequest request, Model model, Errors errors) {
        User user = (User) getUserFromSession(request.getSession());

        if (errors.hasErrors()) {
            model.addAttribute("title", "Layout Form");
            return "layout/layout";
        }

        if (layoutFormDTO.getVideoZones() > layoutFormDTO.getTotalZones()) {
            errors.rejectValue("totalZones", "zone.invalid", "Video Zones can't outnumber total zones!!");
            model.addAttribute("title", "Layout Form");
            return "layout/layout";
        }



        videoZones = layoutFormDTO.getVideoZones();
        totalZones = layoutFormDTO.getTotalZones();

        return "redirect:/layout/layoutcont";

    }

    @GetMapping("layoutcont")
    public String displayProcessedLayoutPage(Model model, HttpServletRequest request) {
        User user = getUserFromSession(request.getSession());

        ArrayList<Host> hostList = new ArrayList<>();
        ArrayList<SavControl> controllerList = new ArrayList<>();
        ArrayList<AudioDevice> audioDeviceList = new ArrayList<>();
        Iterable<Host> hosts = hostRepository.findAll();

       for (Host host : hosts) {
           if (host.hostSelection(videoZones,totalZones)) {
               hostList.add(host);
           }
       }

       model.addAttribute("user", user);
       model.addAttribute("title", "Layout Result");
       model.addAttribute("hosts", hostList);
       model.addAttribute("videoZones", videoZones);
       model.addAttribute("totalZones", totalZones);

       return "layout/layoutcont";
    }

    @GetMapping("project")
    public String displayProjectForm(Model model, HttpServletRequest request) {
        User user = getUserFromSession(request.getSession());

        ArrayList<Host> hostList = new ArrayList<>();
        Iterable<Host> hosts = hostRepository.findAll();

        for (Host host: hosts) {
            if (host.hostSelection(videoZones, totalZones)) {
                hostList.add(host);
            }
        }

        ZoneFormDTO zoneFormDTO = new ZoneFormDTO();

        Zone [] generatedZones =  zoneFormDTO.zoneGenerator(totalZones);

        List<Zone> zones = new ArrayList<>();

        for (Zone zone : generatedZones) {
            zones.add(zone);
        }

        zoneFormDTO.setZones(zones);



        model.addAttribute("user", user);
        model.addAttribute("title", " New Project");
        model.addAttribute("host", hostList);
        model.addAttribute("zones", zoneFormDTO.getZones());


        return "layout/project";
    }

}

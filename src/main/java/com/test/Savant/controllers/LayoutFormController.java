package com.test.Savant.controllers;

import com.test.Savant.User;
import com.test.Savant.data.*;
import com.test.Savant.models.AudioDevice;
import com.test.Savant.models.Host;
import com.test.Savant.models.SavControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

        int videoZonesGet = 0;
        int totalZonesGet = 0;

        model.addAttribute("title", "Layout Form");
        model.addAttribute("videoZones", videoZonesGet);
        model.addAttribute("totalZones", totalZonesGet);

        return "layout";
    }

    @PostMapping("layout")
    public String renderLayoutForm(Model model, int videoZonesGet, int totalZonesGet, HttpServletRequest request) {
        User user = (User) getUserFromSession(request.getSession());

        videoZones = videoZonesGet;
        totalZones = totalZonesGet;

        return "layoutcont";

    }

    @GetMapping("layoutcont")
    public String displayProcessedLayoutPage(Model model, int videoZones, int totalZones, HttpServletRequest request) {
        User user = getUserFromSession(request.getSession());

        ArrayList<Host> hostList = new ArrayList<>();
        ArrayList<SavControl> controllerList = new ArrayList<>();
        ArrayList<AudioDevice> audioDeviceList = new ArrayList<>();
        Iterable<Host> hosts = hostRepository.findAll();

       for (Host host : hosts) {
           if (host.hostSelection(host.getVideoZones(),host.getTotalZones())) {
               hostList.add(host);
           }
       }

       model.addAttribute("title", "Layout Result");
       model.addAttribute("hosts", hostList);

       return "layoutcont";
    }

}

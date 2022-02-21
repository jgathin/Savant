package com.test.Savant.controllers;

import com.test.Savant.dto.ProjectFormDTO;
import com.test.Savant.models.User;
import com.test.Savant.data.*;
import com.test.Savant.dto.LayoutFormDTO;
import com.test.Savant.dto.ZoneFormDTO;
import com.test.Savant.models.AudioDevice;
import com.test.Savant.models.Host;
import com.test.Savant.models.SavControl;
import com.test.Savant.models.layout.Project;
import com.test.Savant.models.zone.Zone;
import com.test.Savant.models.zone.ZoneType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.test.Savant.dto.ProjectFormDTO;

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
    @Autowired
    ZoneRepository zoneRepository;
    @Autowired
    ProjectRepository projectRepository;

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
    public Zone[] zoneGenerator(int totalZones) {
        Zone [] myZones = new Zone[totalZones];

        for (int i = 0; i < totalZones; i++) {
            myZones[i] = new Zone();
        }

        return myZones;
    }
    Zone [] generatedZones =  zoneGenerator(totalZones);

    public int count = 0;

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

    @GetMapping("addproject")
    public String displayAddProjectForm(Model model, HttpServletRequest request) {
        User user = getUserFromSession(request.getSession());

        ArrayList<Host> hostList = new ArrayList<>();
        Iterable<Host> hosts = hostRepository.findAll();

        for (Host host: hosts) {
            if (host.hostSelection(videoZones, totalZones)) {
                hostList.add(host);
            }
        }

        model.addAttribute("user", user);
        model.addAttribute("title", "New Project");
        model.addAttribute(new Project());
        model.addAttribute("host", hostList);
//        model.addAttribute("types", ZoneType.values());


        return "layout/addproject";
    }

    @PostMapping("addproject")
    public String renderAddProjectForm(@ModelAttribute @Valid Project newProject, Errors errors,
                                    HttpServletRequest request, Model model) {
        User user = getUserFromSession(request.getSession());

        if (errors.hasErrors()) {
            model.addAttribute("user", user);
            model.addAttribute("title", "New Project");
            return "layout/addproject";
        }

        projectRepository.save(newProject);

            return "layout/project";
        }


    @GetMapping("project")
    public String displayProjectsPage(Model model, HttpServletRequest request, ProjectFormDTO projectFormDTO) {
        User user = getUserFromSession(request.getSession());

        List<Project> projects = projectFormDTO.pullProjectsToLocalMemory(user);

        model.addAttribute("user", user);
        model.addAttribute("title", "Projects");
        model.addAttribute("projects", projects);

        return "layout/project";
    }

    @GetMapping("addzone/{projectId}")
    public String displayAddZonePage(Model model, HttpServletRequest request,
                                     @PathVariable Integer projectId, ProjectFormDTO projectFormDTO) {
        User user = (User) getUserFromSession(request.getSession());
        List<Project> projects = projectFormDTO.pullProjectsToLocalMemory(user);

        Project project = projectFormDTO.findProjectById(projectId, projects);
//        Project editProject = result.get();
        model.addAttribute("user", user);
        model.addAttribute("title", "Add zone to " + project.getName());
        model.addAttribute("project", project);
        model.addAttribute(new Zone());

        return "layout/addzone";
    }

    @PostMapping("addzone")
    public String processAddZonePage(@ModelAttribute @Valid Zone zone,
                                     Project project, HttpServletRequest request,
                                     Errors errors, Model model) {
        User user = (User) getUserFromSession(request.getSession());

        Optional<Project> result = projectRepository.findById(project.getId());
        Project editProject = result.get();

        if (errors.hasErrors()) {

            model.addAttribute("title", "Add zone to " + editProject.getName());
            return "layout/addzone";
        }

        List<Zone> zones = editProject.getZones();
        zones.add(zone);
        projectRepository.save(editProject);

        return "layout/projectdetail/" + editProject.getId();
    }

    @GetMapping("projectdetail")
    public String displayProjectDetailPage(Model model, @RequestParam Integer projectId,
                                           HttpServletRequest request) {
        User user = (User) getUserFromSession(request.getSession());

        Optional<Project> result = projectRepository.findById(projectId);

        if (result.isEmpty()) {
            model.addAttribute("user", user);
            model.addAttribute("title", "Invalid Project ID: " + projectId);
        } else {
            Project project = result.get();
            model.addAttribute("user", user);
            model.addAttribute("title", project.getName() + " Details");
            model.addAttribute("project", project);
        }

        return "layout/projectdetail";
    }



}




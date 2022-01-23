package com.test.Savant.controllers;

import com.test.Savant.User;
import com.test.Savant.data.SavControlRepository;
import com.test.Savant.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("control")
public class SavControlController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    cdcdSavControlRepository savControlRepository;

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


}

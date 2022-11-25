package com.epam.controller;

import com.epam.model.User;
import com.epam.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersRegisterController {
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(UsersRegisterController.class);

    @Autowired
    public UsersRegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String openRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, Model model) {
        userService.create(user);
        model.addAttribute("registerMessage", "You have successfully registered!");
        logger.info("User was created");
        return "login";
    }
}

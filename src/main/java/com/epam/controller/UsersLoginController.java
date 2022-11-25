package com.epam.controller;

import com.epam.model.User;
import com.epam.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class UsersLoginController {

    UserService userService;
    private Logger logger = LoggerFactory.getLogger(UsersLoginController.class);

    @Autowired
    public UsersLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String openLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String validDate(@RequestParam(value = "email", required = false) String email,
                            @RequestParam(value = "password", required = false) String password,
                            Model model) {

        if (!userService.existEmailAndPass(email, password)) {
            model.addAttribute("errorMassage", "Something wrong");
            logger.error("The user entered incorrect data");
            return "login";
        } else {
            User user = userService.getByEmailAndPass(email, password);
            model.addAttribute("user", user);
            logger.info("The user successfully logged in");
            return "home";
        }
    }
}


package com.epam.controller;

import com.epam.model.Poll;
import com.epam.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("user")
public class PollsController {
    PollService pollService;

    @Autowired
    public PollsController(PollService pollService) {
        this.pollService = pollService;
    }

    @GetMapping("/poll")
    public String openPollPage(Model model) {
        List<Poll> all = pollService.findAll();
        model.addAttribute("polls", all);
        return "polls";
    }
}


package com.epam.controller;

import com.epam.controller.dto.SubmitResult;
import com.epam.model.Poll;
import com.epam.model.Result;
import com.epam.model.User;
import com.epam.service.PollService;
import com.epam.service.ResultService;
import com.epam.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes(value = "user")
public class ResultsController {
    ResultService resultService;
    UserService userService;
    PollService pollService;
    long sum = 0;

    private Logger logger = LoggerFactory.getLogger(ResultsController.class);

    @Autowired
    public ResultsController(PollService pollService, ResultService resultService, UserService userService) {
        this.resultService = resultService;
        this.userService = userService;
        this.pollService = pollService;
    }

    @PostMapping("/results")
    public String results(@ModelAttribute User user, SubmitResult submitResult, HttpServletRequest req, Model model) {

        String[] questionIds = req.getParameterValues("questionId");

        for (String questionId : questionIds) {
            String parameter = req.getParameter("marked" + questionId);
            if (parameter == null) {
                model.addAttribute("error", "You have not filled in all the fields, try again");
                logger.error("The user have not filled in all the fields");
                return "error";
            } else {
                long value = Long.parseLong(parameter);
                sum += value;
            }
        }

        List<Poll> byId = pollService.findById(1);
        List<Result> result = byId.get(0).getResult();
        String explanation = null;
        Date now = Date.valueOf(LocalDate.now());

        for (Result result1 : result) {
            long minScore = result1.getMinScore();
            long maxScore = result1.getMaxScore();
            if (sum >= minScore && sum <= maxScore) {
                explanation = result1.getExplanation();

                user.setResultDate(now);
                user.setPollResult(explanation);
                userService.create(user);
                break;
            }
        }
        model.addAttribute("userResult", user.getPollResult());
        logger.info("Everything was done successfully, user's data was added to the db and displayed to the user");
        return "results";
    }
}
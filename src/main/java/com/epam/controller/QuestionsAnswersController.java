package com.epam.controller;

import com.epam.model.Answer;
import com.epam.model.Poll;
import com.epam.model.Question;
import com.epam.model.User;
import com.epam.service.AnswersService;
import com.epam.service.PollService;
import com.epam.service.QuestionsService;
import com.epam.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
@SessionAttributes("user")
public class QuestionsAnswersController {
    PollService pollService;
    QuestionsService questionsService;
    AnswersService answersService;
    UserService userService;
    Question question = new Question();
    Answer answer = new Answer();
    List<Answer> answers = new ArrayList<>();

    private Logger logger = LoggerFactory.getLogger(QuestionsAnswersController.class);

    @Autowired
    public QuestionsAnswersController(PollService pollService, QuestionsService questionsService, AnswersService answersService, UserService userService) {
        this.pollService = pollService;
        this.questionsService = questionsService;
        this.answersService = answersService;
        this.userService = userService;
    }

    @GetMapping("/questions/{pollId}")
    public String questionsAndAnswers(@ModelAttribute("user") User user, @PathVariable("pollId") int poll_id, Model model) {

        Date result_date = user.getResultDate();
        Date now = Date.valueOf(LocalDate.now());

        if (result_date == null) {
            List<Question> questions = pollService.findById(poll_id).get(0).getQuestionsList();
            model.addAttribute("questions", questions);
            logger.info("The user's preferred poll was successfully opened");
            return "question_answers";
        } else {
            long diffInDays = Math.abs(now.getTime() - result_date.getTime());
            long diff = TimeUnit.DAYS.convert(diffInDays, TimeUnit.MILLISECONDS);

            if (diff <= 7) {
                String pollResult = user.getPollResult();
                model.addAttribute("poll_error", "Вы можете снова принять участие в опросе через неделю \n Ваш результат -");
                logger.error("The user participated in the survey during the last 7 days");
                model.addAttribute("poll_result", pollResult);
                return "results";
            } else {
                List<Question> questions = pollService.findById(poll_id).get(0).getQuestionsList();
                model.addAttribute("questions", questions);
                logger.info("The user's preferred poll was successfully opened");
                return "question_answers";
            }
        }
    }

}


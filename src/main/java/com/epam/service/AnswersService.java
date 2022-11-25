package com.epam.service;

import com.epam.model.Answer;

import java.util.List;

public interface AnswersService {
    List<Answer> findByQuestionId(long questionId);
}

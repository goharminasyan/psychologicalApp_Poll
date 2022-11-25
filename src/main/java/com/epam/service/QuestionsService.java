package com.epam.service;

import com.epam.model.Question;

import java.util.List;

public interface QuestionsService {
    List<Question> findAllByPollId(long pollId);
    List<Question> findAnswersByQuestId(long questId);

}

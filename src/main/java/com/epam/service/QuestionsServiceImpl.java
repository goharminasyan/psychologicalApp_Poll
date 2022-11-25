package com.epam.service;

import com.epam.model.Question;
import com.epam.repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsServiceImpl implements QuestionsService {
    QuestionsRepository questionsRepository;

    @Autowired
    public QuestionsServiceImpl(QuestionsRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }

    @Override
    public List<Question> findAllByPollId(long pollId) {
        return /*questionsRepository.findAllByAnswersList(pollId)*/ null;
    }

    @Override
    public List<Question> findAnswersByQuestId(long questId) {
        return questionsRepository.findByQuestId(questId);
    }
}

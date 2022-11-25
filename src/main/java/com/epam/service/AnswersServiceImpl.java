package com.epam.service;

import com.epam.model.Answer;
import com.epam.repository.AnswersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class AnswersServiceImpl implements AnswersService{
    AnswersRepository answersRepository;

    @Autowired
    public AnswersServiceImpl(AnswersRepository answersRepository) {
        this.answersRepository = answersRepository;
    }

    @Override
    public List <Answer> findByQuestionId(long questionId) {
        return answersRepository.findById(questionId);
    }
}

package com.epam.service;

import com.epam.model.Poll;

import java.util.List;

public interface PollService {
    List<Poll> findAll();

    List<Poll> findById(long id);
}

package com.epam.service;

import com.epam.model.Poll;
import com.epam.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PollServiceImpl implements PollService {
    PollRepository pollRepository;

    @Autowired
    public PollServiceImpl(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    @Override
    public List<Poll> findAll() {
        return pollRepository.findAll();
    }

    @Override
    public List<Poll> findById(long id) {
        return pollRepository.findAllById(id);
    }
}

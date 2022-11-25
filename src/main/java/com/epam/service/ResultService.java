package com.epam.service;

import com.epam.model.Result;

import java.util.List;

public interface ResultService {
    List<Result> findByScore(long pollId);
}

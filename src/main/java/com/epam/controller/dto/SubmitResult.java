package com.epam.controller.dto;

import java.util.List;

public class SubmitResult {
    private Long userId;
    private List<QuestionMarks> questionIds;

    static class QuestionMarks {
        private Long questionId;

    }

}



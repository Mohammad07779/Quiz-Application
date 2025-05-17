package com.mohammadmarediya.quiz_app.Services;

import com.mohammadmarediya.quiz_app.DTOS.QuestionDTO;

import java.util.List;

public interface QuestionService {

    QuestionDTO createQuestion(QuestionDTO questionDTO);

    QuestionDTO updateQuestion(QuestionDTO questionDTO, Integer questionID);

     void deleteQuestion(Integer questionId);

    List<QuestionDTO> getAllQuestion();

    List<QuestionDTO> getQuestionBySubject(String subject);

    QuestionDTO getQuestionByID(Integer id);

}

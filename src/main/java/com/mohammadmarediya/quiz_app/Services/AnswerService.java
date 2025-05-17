package com.mohammadmarediya.quiz_app.Services;

import com.mohammadmarediya.quiz_app.DTOS.AnswerDTO;

public interface AnswerService  {

    public AnswerDTO giveAnswer(AnswerDTO answerDTO,Integer questionId);


}

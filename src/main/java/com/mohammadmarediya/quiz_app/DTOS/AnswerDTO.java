package com.mohammadmarediya.quiz_app.DTOS;

import com.mohammadmarediya.quiz_app.Entities.Questions;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public class AnswerDTO {


    private Integer answerId;

    @NotBlank(message = "Subject is required")
    @Size(max = 100, message = "answer can’t be longer than 100 characters")
    private String answer;

    private Questions questions;

    private String rightAnswer;

    public AnswerDTO(Integer answerId, String answer, Questions questions, String rightAnswer) {
        this.answerId = answerId;
        this.answer = answer;
        this.questions = questions;
        this.rightAnswer = rightAnswer;
    }

    public AnswerDTO() {
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }
}

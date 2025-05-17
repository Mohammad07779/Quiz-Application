package com.mohammadmarediya.quiz_app.Entities;

import jakarta.persistence.*;

@Entity
public class Answers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer answerId;

    private String answer;

    @OneToOne
    @JoinColumn(name = "question_id", referencedColumnName = "questionId")
    private Questions questions;

    public Answers(Integer answerId, String answer, Questions questions) {
        this.answerId = answerId;
        this.answer = answer;
        this.questions = questions;
    }

    public Answers() {
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
}


package com.mohammadmarediya.quiz_app.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Question")
//@Getter
//@Setter in my IDE Lombok are not Working  for Some Reason
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questionId;

    @Column(unique = true)
    private String questionTitle;

    private String subject;

    private String option1;

    private String option2;

    private String option3;

    private String option4;

    private String rightAnswer;

    @OneToOne(mappedBy = "questions", cascade = CascadeType.ALL)
    private Answers answer;

    public Questions(Integer questionId, String questionTitle, String subject, String option1, String option2, String option3, String option4, String rightAnswer, Answers answer) {
        this.questionId = questionId;
        this.questionTitle = questionTitle;
        this.subject = subject;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.rightAnswer = rightAnswer;
        this.answer = answer;
    }

    public Questions() {
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public Answers getAnswer() {
        return answer;
    }

    public void setAnswer(Answers answer) {
        this.answer = answer;
    }
}

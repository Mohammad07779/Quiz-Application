package com.mohammadmarediya.quiz_app.Repositories;

import com.mohammadmarediya.quiz_app.Entities.Answers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answers,Integer> {

}

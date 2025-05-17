package com.mohammadmarediya.quiz_app.Repositories;


import com.mohammadmarediya.quiz_app.Entities.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface QuestionRepository extends JpaRepository<Questions, Integer> {


    @Query(value = "SELECT * FROM question WHERE subject = :subject", nativeQuery = true)
    List<Questions> findBySubject(@Param("subject") String subject);

//    List<Questions> findBySubject(String subject);

}

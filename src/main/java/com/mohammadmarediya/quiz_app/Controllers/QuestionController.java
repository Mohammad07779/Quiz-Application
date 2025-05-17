package com.mohammadmarediya.quiz_app.Controllers;

import com.mohammadmarediya.quiz_app.DTOS.QuestionDTO;
import com.mohammadmarediya.quiz_app.Services.QuestionService;
import com.mohammadmarediya.quiz_app.Utility.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createQuestion(@RequestBody QuestionDTO questionDTO) {
        QuestionDTO question = questionService.createQuestion(questionDTO);
        return new ResponseEntity<>(new ApiResponse(question,"Question created Successfully"), HttpStatus.CREATED);
    }

    @GetMapping("/allQuestion")
    public ResponseEntity<ApiResponse> getAllQuestion() {
        List<QuestionDTO> allQuestion = questionService.getAllQuestion();
        return new ResponseEntity<>(new ApiResponse(allQuestion,"All question fetched Successfully"), HttpStatus.FOUND);
    }

    @GetMapping("/bySubject/{subject}")
    public ResponseEntity<ApiResponse> getQuestionBySubject(@PathVariable String subject) {
        List<QuestionDTO> allQuestion = questionService.getQuestionBySubject(subject);
        return new ResponseEntity<>(new ApiResponse(allQuestion,"All question fetched Successfully"), HttpStatus.FOUND);
    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<ApiResponse> getQuestionByid(@PathVariable Integer id) {
        QuestionDTO questionByID = questionService.getQuestionByID(id);
        return new ResponseEntity<>(new ApiResponse(questionByID," question fetched Successfully"), HttpStatus.FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> DeleteQuestion(@PathVariable Integer id) {
         questionService.deleteQuestion(id);
        return new ResponseEntity<>(new ApiResponse(null,"Question Deleted Successfully"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> UpdateQuestion(@PathVariable Integer id,@RequestBody QuestionDTO questionDTO) {
        QuestionDTO updatedQuestion = questionService.updateQuestion(questionDTO, id);
        return new ResponseEntity<>(new ApiResponse(updatedQuestion,"question Updated Successfully"), HttpStatus.OK);
    }



}

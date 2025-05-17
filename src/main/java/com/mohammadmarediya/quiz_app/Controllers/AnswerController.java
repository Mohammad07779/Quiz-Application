package com.mohammadmarediya.quiz_app.Controllers;

import com.mohammadmarediya.quiz_app.DTOS.AnswerDTO;
import com.mohammadmarediya.quiz_app.Services.AnswerService;
import com.mohammadmarediya.quiz_app.Utility.ApiResponse;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    private final AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping("/give/{questionID}")
    public ResponseEntity<ApiResponse> giveAnswer(@PathVariable Integer questionID, @RequestBody AnswerDTO answerDTO){
        AnswerDTO answer = answerService.giveAnswer(answerDTO, questionID);
        return new ResponseEntity<>(new ApiResponse(answer,"Answer Created successfully"), HttpStatus.CREATED);
    }
}

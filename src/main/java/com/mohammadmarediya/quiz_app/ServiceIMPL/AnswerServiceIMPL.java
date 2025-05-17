package com.mohammadmarediya.quiz_app.ServiceIMPL;

import com.mohammadmarediya.quiz_app.DTOS.AnswerDTO;
import com.mohammadmarediya.quiz_app.Entities.Answers;
import com.mohammadmarediya.quiz_app.Entities.Questions;
import com.mohammadmarediya.quiz_app.Exception.ResourceNotFoundException;
import com.mohammadmarediya.quiz_app.Repositories.AnswerRepository;
import com.mohammadmarediya.quiz_app.Repositories.QuestionRepository;
import com.mohammadmarediya.quiz_app.Services.AnswerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceIMPL implements AnswerService {

    private final AnswerRepository answerRepository;
    private final ModelMapper modelMapper;
    private final QuestionRepository questionRepository;

    @Autowired
    public AnswerServiceIMPL(AnswerRepository answerRepository, ModelMapper modelMapper, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.modelMapper = modelMapper;
        this.questionRepository = questionRepository;
    }

    @Override
    public AnswerDTO giveAnswer(AnswerDTO answerDTO, Integer questionId) {

        Questions question = questionRepository.findById(questionId)
                .orElseThrow(() -> new ResourceNotFoundException("Question Not Found"));

        Answers answer = modelMapper.map(answerDTO, Answers.class);
        answer.setQuestions(question);

        Answers saved = answerRepository.save(answer);

        AnswerDTO response = new AnswerDTO();
        response.setAnswerId(saved.getAnswerId());
        response.setAnswer(saved.getAnswer());
        response.setRightAnswer(question.getRightAnswer());
        response.setQuestions(question);

        return response;
    }

}

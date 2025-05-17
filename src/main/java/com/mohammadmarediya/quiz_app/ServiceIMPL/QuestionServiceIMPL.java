package com.mohammadmarediya.quiz_app.ServiceIMPL;

import com.mohammadmarediya.quiz_app.DTOS.QuestionDTO;
import com.mohammadmarediya.quiz_app.Entities.Questions;
import com.mohammadmarediya.quiz_app.Exception.ResourceNotFoundException;
import com.mohammadmarediya.quiz_app.Repositories.QuestionRepository;
import com.mohammadmarediya.quiz_app.Services.QuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceIMPL implements QuestionService {

    private final QuestionRepository questionRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public QuestionServiceIMPL(QuestionRepository questionRepository, ModelMapper modelMapper) {
        this.questionRepository = questionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public QuestionDTO createQuestion(QuestionDTO questionDTO) {
        Questions questions = modelMapper.map(questionDTO, Questions.class);
        Questions savedQuestion = questionRepository.save(questions);
        return modelMapper.map(savedQuestion, QuestionDTO.class);
    }

    @Override
    public QuestionDTO updateQuestion(QuestionDTO questionDTO, Integer questionID) {
        Questions question = questionRepository.findById(questionID)
                .orElseThrow(() -> new ResourceNotFoundException("Question Not Found"));
        question.setQuestionTitle(questionDTO.getQuestionTitle());
        question.setRightAnswer(questionDTO.getRightAnswer());
        question.setSubject(questionDTO.getSubject());
        question.setOption1(questionDTO.getOption1());
        question.setOption2(questionDTO.getOption2());
        question.setOption3(questionDTO.getOption3());
        question.setOption4(questionDTO.getOption4());

        Questions updatedQuestion = questionRepository.save(question);
        return modelMapper.map(updatedQuestion, QuestionDTO.class);

    }

    @Override
    public void deleteQuestion(Integer questionId) {
        questionRepository.deleteById(questionId);

    }

    @Override
    public List<QuestionDTO> getAllQuestion() {
        List<Questions> allQuestion = questionRepository.findAll();
       return allQuestion.stream().map(question ->
                modelMapper.map(question, QuestionDTO.class))
                .toList();

    }

    @Override
    public List<QuestionDTO> getQuestionBySubject(String subject) {
        List<Questions> questions = questionRepository.findBySubject(subject);
        return questions.stream().map(question ->
                        modelMapper.map(question, QuestionDTO.class))
                .toList();
    }

    @Override
    public QuestionDTO getQuestionByID(Integer id) {
        Questions question = questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question Not Found"));
        return modelMapper.map(question,QuestionDTO.class);
    }
}

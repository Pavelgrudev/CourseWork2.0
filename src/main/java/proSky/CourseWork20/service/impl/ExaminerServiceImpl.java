package proSky.CourseWork20.service.impl;

import org.springframework.stereotype.Service;
import proSky.CourseWork20.exception.IncorrectQuestionAmountException;
import proSky.CourseWork20.model.Question;
import proSky.CourseWork20.service.ExaminerService;
import proSky.CourseWork20.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService)  {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount <= 0 || amount > questionService.getAll().size()) {
            throw new IncorrectQuestionAmountException();
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }
}

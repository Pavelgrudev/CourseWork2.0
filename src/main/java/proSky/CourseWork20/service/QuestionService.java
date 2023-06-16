package proSky.CourseWork20.service;

import proSky.CourseWork20.model.Question;

import java.util.Collection;

public interface QuestionService  {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();

}

package proSky.CourseWork20.service;

import proSky.CourseWork20.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}

package proSky.CourseWork20.service.impl;

import proSky.CourseWork20.model.Question;

import java.util.Collection;
import java.util.Set;

public class TestConstants {
    public static final Question QUESTION_1 = new Question("q1", "a1");
    public static final Question QUESTION_2 = new Question("q2", "a2");
    public static final Question QUESTION_3 = new Question("q3", "a3");
    public static final Question QUESTION_4 = new Question("q4", "a4");
    public static final Question QUESTION_5 = new Question("q5", "a5");

    public static final Collection<Question> MOCK_QUESTIONS = Set.of(
            QUESTION_1
            , QUESTION_2
            , QUESTION_3
            , QUESTION_4);
}

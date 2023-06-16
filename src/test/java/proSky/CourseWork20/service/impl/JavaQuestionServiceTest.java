package proSky.CourseWork20.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import proSky.CourseWork20.exception.QuestionNotFoundException;
import proSky.CourseWork20.model.Question;
import proSky.CourseWork20.service.QuestionService;


import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import static proSky.CourseWork20.service.impl.TestConstants.*;


class JavaQuestionServiceTest {
    private final QuestionService questionService = new JavaQuestionService();

    @BeforeEach
    public void beforeEach() {
        questionService.add(QUESTION_1);
        questionService.add(QUESTION_2);
        questionService.add(QUESTION_3);
    }

    @Test
    void shouldAddQuestion() {
        int beforeCount = questionService.getAll().size();


        Assertions.assertThat(questionService.add(QUESTION_4))
                .isEqualTo(QUESTION_4)
                .isIn(questionService.getAll());

        Assertions.assertThat(questionService.getAll()).hasSize(beforeCount + (1));
    }  // action.accept(elementAt(es, i));

    @Test
    void shouldRemoveQuestion() {
        int beforeCount = questionService.getAll().size();


        Assertions.assertThat(questionService.remove(QUESTION_1))
                .isEqualTo(QUESTION_1)
                .isNotIn(questionService.getAll());

        Assertions.assertThat(questionService.getAll()).hasSize(beforeCount - 1);

    }

    @Test
    public void shouldThrowQuestionNotFoundException() {
        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> questionService.remove(new Question("INCORRECT", "INCORRECT")));
    }

    @Test
    public void shouldReturnAllQuestions() {
        Assertions.assertThat(questionService.getAll())
                .hasSize(3)
                .containsExactlyInAnyOrder(
                        QUESTION_1
                        , QUESTION_2
                        , QUESTION_3);
    }

    @Test
    public void shouldReturnRandomQuestion() {
        Assertions.assertThat(questionService.getRandomQuestion())
                .isNotNull()
                .isIn(questionService.getAll());

    }


}
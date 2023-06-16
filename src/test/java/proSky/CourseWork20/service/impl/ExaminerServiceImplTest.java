package proSky.CourseWork20.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import proSky.CourseWork20.exception.IncorrectQuestionAmountException;
import proSky.CourseWork20.service.QuestionService;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;
import static proSky.CourseWork20.service.impl.TestConstants.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void shouldThrowIncorrectQuestionAmountException() {
        when(questionService.getAll()).thenReturn(MOCK_QUESTIONS);

        assertThatExceptionOfType(IncorrectQuestionAmountException.class)
                .isThrownBy(() -> examinerService.getQuestions(-1));
        assertThatExceptionOfType(IncorrectQuestionAmountException.class)
                .isThrownBy(() -> examinerService.getQuestions(MOCK_QUESTIONS.size() + 1));
    }

    @Test
    public void shouldReturnQuestions() {
        when(questionService.getAll()).thenReturn(MOCK_QUESTIONS);
        when(questionService.getRandomQuestion()).thenReturn(
                QUESTION_1
                , QUESTION_2
                , QUESTION_3
                , QUESTION_4
        );
        int questionAmount = MOCK_QUESTIONS.size() - 3;
        Assertions.assertThat(examinerService.getQuestions(questionAmount))
                .hasSize(questionAmount);
    }
}
package com.flowable.training.dp.t100.rest;

import com.flowable.training.dp.t100.quiz.Quiz;
import com.flowable.training.dp.t100.quiz.QuizService;
import org.flowable.rest.service.api.history.HistoricProcessInstanceResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuizResource {

    private final QuizService quizService;

    public QuizResource(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("api/quiz/newest")
    public List<Quiz> getNewestQuiz() {
        return quizService.getNewestQuizes();
    }

}

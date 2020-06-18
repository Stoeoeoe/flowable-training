package com.flowable.training.dp.t100.quiz;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.flowable.engine.HistoryService;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.rest.service.api.RestResponseFactory;
import org.flowable.rest.service.api.history.HistoricProcessInstanceResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class QuizService {

    private final HistoryService historyService;
    private final RestResponseFactory restResponseFactory;

    public QuizService(HistoryService historyService, RestResponseFactory restResponseFactory) {
        this.historyService = historyService;
        this.restResponseFactory = restResponseFactory;
    }

    public List<Quiz> getNewestQuizes() {
        List<Quiz> finalList = new ArrayList<>();
        List<HistoricProcessInstance> allQuizProcesses = historyService.createHistoricProcessInstanceQuery()
                .processDefinitionKey("TRA-P001")
                .variableExists("quiz")
                .finished()
                .includeProcessVariables()
                .list();

        Map<String, List<HistoricProcessInstance>> groupedQuizes = allQuizProcesses.stream().collect(Collectors.groupingBy(hpi -> getQuizName(hpi.getProcessVariables())));
        for (Map.Entry<String, List<HistoricProcessInstance>> quizEnty: groupedQuizes.entrySet()) {
            HistoricProcessInstance newestQuiz = quizEnty.getValue().get(0);
            for (int i = 1; i < quizEnty.getValue().size(); i++) {
                HistoricProcessInstance quiz = quizEnty.getValue().get(i);
                if(quiz.getEndTime().after(newestQuiz.getEndTime())) {
                    newestQuiz = quiz;
                }
            }
            Quiz quiz = new Quiz();
            Map<String, Object> processVariables = newestQuiz.getProcessVariables();
            JsonNode quizVariable = (JsonNode)processVariables.get("quiz");
            quiz.setName((String) quizVariable.get("name").asText());
            quiz.setQuestions((ArrayNode) quizVariable.get("questions"));
            finalList.add(quiz);
        }

        return finalList;
    }

    private String getQuizName(Map<String, Object> variables) {
        JsonNode quiz = (JsonNode)variables.get("quiz");
        if(quiz.has("name")) {
            return quiz.get("name").asText();
        } else {
            return "";
        }

    }

}

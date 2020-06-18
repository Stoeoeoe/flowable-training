package com.flowable.training.dp.t100.quiz;


import com.fasterxml.jackson.databind.node.ArrayNode;

public class Quiz {

    private String name;
    private ArrayNode questions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayNode getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayNode questions) {
        this.questions = questions;
    }
}

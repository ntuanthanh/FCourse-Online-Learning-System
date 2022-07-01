/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Question {
    private int id;
    private String content;
    private Quiz quiz;
    private Status status;
    private QuizLevel quizLevel;
    private ArrayList<Option> options;

    public ArrayList<Option> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Option> options) {
        this.options = options;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public QuizLevel getQuizLevel() {
        return quizLevel;
    }

    public void setQuizLevel(QuizLevel quizLevel) {
        this.quizLevel = quizLevel;
    }
    
}

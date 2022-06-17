/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Question {
    private int id;
    
    private String answer;
    private String content;
    private String explain;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private Course course;
    private Dimension dimension;
    private QuizLevel quizlevel;
    private Status status;

    public Question() {
    }

    public Question(int id, String answer, String content, String explain, String option1, String option2, String option3, String option4, Course course, QuizLevel quizlevel, Status status) {
        this.id = id;
        this.answer = answer;
        this.content = content;
        this.explain = explain;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.course = course;
        this.quizlevel = quizlevel;
        this.status = status;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public QuizLevel getQuizlevel() {
        return quizlevel;
    }

    public void setQuizlevel(QuizLevel quizlevel) {
        this.quizlevel = quizlevel;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    
}

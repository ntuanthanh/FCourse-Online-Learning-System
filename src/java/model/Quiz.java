/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author thand
 */
public class Quiz {
    private int id;
    private String Descripsion;
    private int Duration;
    private String Name;
    private float PassRate;
    private Course course;
    private int QuizLevelId;
    private int QuizTypeId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripsion() {
        return Descripsion;
    }

    public void setDescripsion(String Descripsion) {
        this.Descripsion = Descripsion;
    }

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int Duration) {
        this.Duration = Duration;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public float getPassRate() {
        return PassRate;
    }

    public void setPassRate(float PassRate) {
        this.PassRate = PassRate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getQuizLevelId() {
        return QuizLevelId;
    }

    public void setQuizLevelId(int QuizLevelId) {
        this.QuizLevelId = QuizLevelId;
    }

    public int getQuizTypeId() {
        return QuizTypeId;
    }

    public void setQuizTypeId(int QuizTypeId) {
        this.QuizTypeId = QuizTypeId;
    }
    
    
}

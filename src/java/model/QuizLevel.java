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
public class QuizLevel {
    private int id;
    private String levelName;

    public QuizLevel() {
    }

    public QuizLevel(int id, String levelName) {
        this.id = id;
        this.levelName = levelName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
    
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jicon
 */
public class UserQuestionAnswer {
    int id;
    Option option;
    UserQuiz userQuiz;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public UserQuiz getUserQuiz() {
        return userQuiz;
    }

    public void setUserQuiz(UserQuiz userQuiz) {
        this.userQuiz = userQuiz;
    }
    
}

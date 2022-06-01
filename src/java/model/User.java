/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author pv
 */
public class User {
    private int id; 
    private String fullName; 
    private String email; 
    private boolean gender; 
    private String password; 
    private String phone; 
    private String avatarImage;
    private String resetToken; 
    private String createTimeResetToken; 
    private Status status; 
    public User(int id, String fullName, String email, boolean gender, String password, String phone, String avatarImage, String resetToken
            , String createTimeResetToken,  Status status) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.gender = gender;
        this.password = password;
        this.phone = phone;
        this.avatarImage = avatarImage;
        this.resetToken = resetToken; 
        this.createTimeResetToken = createTimeResetToken;
        this.status = status;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(String avatarImage) {
        this.avatarImage = avatarImage;
    }

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public String getCreateTimeResetToken() {
        return createTimeResetToken;
    }

    public void setCreateTimeResetToken(String createTimeResetToken) {
        this.createTimeResetToken = createTimeResetToken;
    }
  
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
}

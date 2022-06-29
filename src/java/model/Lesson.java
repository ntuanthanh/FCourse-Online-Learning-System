/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author tuann
 */
public class Lesson {
    private int id;
    private String videolink;
    private String lessonname;
    private String content;
    private Status status;
    private int type;
    private int topicid;
    private int lessonorder;
    private String LessonType;

    public String getLessonType() {
        return LessonType;
    }

    public void setLessonType(String LessonType) {
        this.LessonType = LessonType;
    }
    
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVideolink() {
        return videolink;
    }

    public void setVideolink(String videolink) {
        this.videolink = videolink;
    }

    public String getLessonname() {
        return lessonname;
    }

    public void setLessonname(String lessonname) {
        this.lessonname = lessonname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getTopicid() {
        return topicid;
    }

    public void setTopicid(int topicid) {
        this.topicid = topicid;
    }

    public int getLessonorder() {
        return lessonorder;
    }

    public void setLessonorder(int lessonorder) {
        this.lessonorder = lessonorder;
    }
    
    
}

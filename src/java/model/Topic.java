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
public class Topic {
    private int id;
    private int topicOrder;
    private String topicName;
    private String description;

    public Topic() {
    }

    public int getId() {
        return id;
    }

    public void setId(int Id) {
        this.id = Id;
    }

    public int getTopicOrder() {
        return topicOrder;
    }

    public void setTopicOrder(int TopicOrder) {
        this.topicOrder = TopicOrder;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

   

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}

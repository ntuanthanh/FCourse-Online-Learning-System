/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author thand
 */
public class Course implements java.io.Serializable {

    private int courseId;
    private Date createDate;
    private String briefInfo;
    private String thumnailURL;
    private String title;
    private String description;
    private boolean feature;
    private Category category;
    private Status status;
    private ArrayList<Tag> tags = new ArrayList<>();
    private ArrayList<PricePackage> pricePackage = new ArrayList<>(); ;
    private ArrayList<User> owners = new ArrayList<>();
    private ArrayList<Dimension> dimensions = new ArrayList<>();
    public Course() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public Date getCreatedate() {
        return createDate;
    }

    public void setCreatedate(Date createdate) {
        this.createDate = createdate;
    }

    public String getBriefinfo() {
        return briefInfo;
    }

    public void setBriefinfo(String briefinfo) {
        this.briefInfo = briefinfo;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }



    public String getThumnailURL() {
        return thumnailURL;
    }

    public void setThumnailURL(String thumnailURL) {
        this.thumnailURL = thumnailURL;
    }

    public boolean isFeature() {
        return feature;
    }

    public void setFeature(boolean feature) {
        this.feature = feature;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Status getStatus() {
        return status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getBriefInfo() {
        return briefInfo;
    }

    public void setBriefInfo(String briefInfo) {
        this.briefInfo = briefInfo;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
     public ArrayList<PricePackage> getPricePackage() {
        return pricePackage;
    }

    public void setPricePackage(ArrayList<PricePackage> pricePackage) {
        this.pricePackage = pricePackage;
    }

    public ArrayList<User> getOwners() {
        return owners;
    }

    public void setOwners(ArrayList<User> owners) {
        this.owners = owners;
    }

    public ArrayList<Dimension> getDimensions() {
        return dimensions;
    }

    public void setDimensions(ArrayList<Dimension> dimensions) {
        this.dimensions = dimensions;
    }
    
}

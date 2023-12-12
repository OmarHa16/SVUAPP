package com.example.ourmeetingapp;

import java.util.Date;

public class meetings {
    private String placeName;
    private Date date;
    private String placeDes;
    private String PersonName;
    private String PersonDes;
    private boolean expandable;

    public meetings(String placeName, Date date, String placeDes, String personName, String personDes) {
        this.placeName = placeName;
        this.date = date;
        this.placeDes = placeDes;
        this.PersonName = personName;
        this.PersonDes = personDes;
        this.expandable = false;
    }

    public boolean getExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlaceDes() {
        return placeDes;
    }

    public void setPlaceDes(String placeDes) {
        this.placeDes = placeDes;
    }

    public String getPersonName() {
        return PersonName;
    }

    public void setPersonName(String personName) {
        PersonName = personName;
    }

    public String getPersonDes() {
        return PersonDes;
    }

    public void setPersonDes(String personDes) {
        PersonDes = personDes;
    }

    @Override
    public String toString() {
        return "meetings{" +
                "placeName='" + placeName + '\'' +
                ", date=" + date +
                ", placeDes='" + placeDes + '\'' +
                ", PersonName='" + PersonName + '\'' +
                ", PersonDes='" + PersonDes + '\'' +
                '}';
    }
}

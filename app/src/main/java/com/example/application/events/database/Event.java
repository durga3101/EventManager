package com.example.application.events.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import java.io.Serializable;

@Entity(tableName = "event_table")
@SuppressWarnings("serial")
public class Event implements  Serializable{

    @PrimaryKey(autoGenerate = true)
    private int eventId;

    private String name;
    private String place;
    private String date;
    private String time;
    private String description;

    public Event(String name, String place, String date, String time, String description) {
        this.name = name;
        this.place = place;
        this.date = date;
        this.time = time;
        this.description = description;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

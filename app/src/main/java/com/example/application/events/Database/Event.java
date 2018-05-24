package com.example.application.events.Database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "event_table")
public class Event {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    private String eventName;

    public Event(String eventName) {
        this.eventName = eventName;
    }

    public int getUid() {
        return uid;
    }

    public String getEventName() {
        return eventName;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;

    }
}

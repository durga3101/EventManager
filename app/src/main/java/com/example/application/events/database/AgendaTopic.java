package com.example.application.events.database;

public class AgendaTopic {

    private String name;
    private String speaker;
    private String time;

    public AgendaTopic(String name, String speaker, String time) {
        this.name = name;
        this.speaker = speaker;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getSpeaker() {
        return speaker;
    }

    public String getTime() {
        return time;
    }
}

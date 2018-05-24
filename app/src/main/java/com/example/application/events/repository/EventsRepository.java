package com.example.application.events.repository;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.application.events.Database.Event;
import com.example.application.events.Database.EventsDatabase;

import java.util.List;

public class EventsRepository {
    private final EventsDatabase db;

    public EventsRepository(Context applicationContext) {
        db = Room.databaseBuilder(applicationContext,
                EventsDatabase.class, "events").allowMainThreadQueries().build();
    }

    public void saveEvent(Event event) {
        db.databaseDao().insertAll(event);
        getEvents();
    }

    public List<Event> getEvents() {
        List<Event> all = db.databaseDao().getAll();

        System.out.println("==========================");
        System.out.println(all.get(0).getEventName());
        System.out.println("==========================");
        return all;
    }
}

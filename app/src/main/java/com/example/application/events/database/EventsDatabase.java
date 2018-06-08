package com.example.application.events.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Event.class}, version = 1)
public abstract class EventsDatabase extends RoomDatabase {
    public abstract DatabaseDao databaseDao();
}

package com.example.application.events.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface DatabaseDao {
    @Query("SELECT * FROM event_table")
    List<Event> getAll();

    @Insert
    void insertAll(Event... event);

    @Query("DELETE FROM event_table where eventId = :eventId")
    void delete(int eventId);
}

package com.example.application.events.Database;

        import android.arch.persistence.room.Dao;
        import android.arch.persistence.room.Delete;
        import android.arch.persistence.room.Insert;
        import android.arch.persistence.room.Query;

        import java.util.List;

@Dao
public interface DatabaseDao {
    @Query("SELECT * FROM event_table")
    List<Event> getAll();

    @Insert
    void insertAll(Event... event);

    @Delete
    void delete(Event event);
}

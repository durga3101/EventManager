package com.example.application.events.view;

import com.example.application.events.database.Event;

import java.util.List;

public interface EventsListView {

    public void renderEvents(List<Event> events);
}

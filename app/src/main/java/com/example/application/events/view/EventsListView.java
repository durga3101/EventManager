package com.example.application.events.view;

import com.example.application.events.Database.Event;

import java.util.List;

public interface EventsListView {

    public void renderEvents(List<Event> events);
}

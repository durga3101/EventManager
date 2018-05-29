package com.example.application.events.presenters;

import com.example.application.events.Database.Event;
import com.example.application.events.repository.EventsRepository;
import com.example.application.events.view.EventsListView;

import java.util.List;

public class EventsListPresenter {

    private final EventsListView view;
    private final EventsRepository repository;

    public EventsListPresenter(EventsListView view, EventsRepository repository) {
        this.view = view;
        this.repository = repository;
    }


    public List<Event> getEvents() {
        return repository.getEvents();
    }

    public void saveEvent(String eventName) {
        repository.saveEvent(new Event(eventName));
    }
}

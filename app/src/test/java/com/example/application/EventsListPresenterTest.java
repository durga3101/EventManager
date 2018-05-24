package com.example.application;

import com.example.application.events.Database.Event;
import com.example.application.events.presenters.EventsListPresenter;
import com.example.application.events.repository.EventsRepository;
import com.example.application.events.view.EventsListView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class EventsListPresenterTest {
    @Mock
    private EventsListView mockView;

    @Mock
    private EventsRepository eventsRepository;

    private EventsListPresenter eventsListPresenter;

    @Before
    public void setUp() {
        eventsListPresenter  = new EventsListPresenter(mockView, eventsRepository);
    }

    @Test
    public void shouldSaveDataIntoDatabase() {
        eventsListPresenter.saveEvent("testEvent");

        verify(eventsRepository).saveEvent(any(Event.class));
    }

    @Test
    public void shouldGetDataFromDatabase() {
        eventsListPresenter.getEvents();

        verify(eventsRepository).getEvents();
    }
}
package com.example.application.events.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.application.R;
import com.example.application.events.adapters.EventsListAdapter;
import com.example.application.events.database.Event;
import com.example.application.events.presenters.EventsListPresenter;
import com.example.application.events.repository.EventsRepository;

import java.util.List;

public class EventsListActivity extends AppCompatActivity implements EventsListView {
    EventsListPresenter presenter;
    private EventsListAdapter eventsListAdapter;

    public static final int ADD_EVENT_CODE = 9090;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        EventsRepository repository = new EventsRepository(this);
        presenter = new EventsListPresenter(this, repository);

        List<Event> events = presenter.getEvents();
        renderEvents(events);
        displayEvents(events);
    }

    private void displayEvents(List<Event> events) {
        int viewId = events.isEmpty() ? R.id.noEventsFound : R.id.event_list_view;
        View eventsView = findViewById(viewId);
        eventsView.setVisibility(View.VISIBLE);
    }

    @Override
    public void renderEvents(List<Event> events) {
        eventsListAdapter = new EventsListAdapter(events, this);
        RecyclerView recyclerView = findViewById(R.id.event_list_view);
        recyclerView.setAdapter(eventsListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    public void addEvent(View view) {
        Intent intent = new Intent(this, AddEventActivity.class);
        startActivityForResult(intent, ADD_EVENT_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == ADD_EVENT_CODE) {
            Event event = (Event) data.getSerializableExtra("event_thumbnail");
            presenter.saveEvent(event);
            eventsListAdapter.addEvent(event);
            View noEventsView = findViewById(R.id.noEventsFound);
            noEventsView.setVisibility(View.VISIBLE);
        }
    }

    public void deleteEvent(int eventId) {
        presenter.deleteEvent(eventId);
    }
}

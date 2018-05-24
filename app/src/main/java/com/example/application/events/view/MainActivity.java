package com.example.application.events.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.application.R;
import com.example.application.events.presenters.EventsListPresenter;
import com.example.application.events.repository.EventsRepository;

public class MainActivity extends AppCompatActivity implements EventsListView {
    EventsListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventsRepository repository = new EventsRepository(this);
        presenter = new EventsListPresenter(this, repository);
    }

    public void addEvent(View view) {
        String eventName = ((EditText) findViewById(R.id.addEvent)).getText().toString();

        Intent intent = new Intent(this, EventsListActivity.class);
        intent.putExtra("eventName", eventName);
        startActivity(intent);
        presenter.saveEvent(eventName);
    }
}

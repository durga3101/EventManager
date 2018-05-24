package com.example.application.events.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.application.R;

public class EventsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        String eventName = getIntent().getStringExtra("eventName");

        TextView eventView = ((TextView) findViewById(R.id.displayEvent));
        eventView.setText(eventName);
    }
}

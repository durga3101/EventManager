package com.example.application.events.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.application.R;
import com.example.application.events.Database.Event;

import static com.example.application.events.view.EventsListActivity.ADD_TODO_CODE;

public class AddEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
    }

    public void saveEvent(View view) {
        String eventName = ((EditText) findViewById(R.id.eventName)).getText().toString();
        String eventPlace = ((EditText) findViewById(R.id.eventPlace)).getText().toString();
        String eventDate = ((EditText) findViewById(R.id.eventDate)).getText().toString();
        String eventTime = ((EditText) findViewById(R.id.eventTime)).getText().toString();
        String eventDescription = ((EditText) findViewById(R.id.eventDescription)).getText().toString();



        Intent intent = new Intent();
        intent.putExtra("eventName", eventName);
        intent.putExtra("eventPlace", eventPlace);
        intent.putExtra("eventDate", eventDate);
        intent.putExtra("eventTime", eventTime);
        intent.putExtra("eventDescription", eventDescription);
        setResult(ADD_TODO_CODE, intent);
        finish();
    }
}

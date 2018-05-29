package com.example.application.events.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.application.R;
import com.example.application.events.repository.EventsRepository;

import static com.example.application.events.view.EventsListActivity.ADD_TODO_CODE;

public class AddEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        EventsRepository repository = new EventsRepository(this);
    }

    public void saveEvent(View view) {
        String eventName = ((EditText) findViewById(R.id.addEvent)).getText().toString();

        Intent intent = new Intent();
        intent.putExtra("eventName", eventName);
        setResult(ADD_TODO_CODE, intent);
        finish();
    }
}

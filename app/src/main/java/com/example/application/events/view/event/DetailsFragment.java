package com.example.application.events.view.event;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.application.R;
import com.example.application.events.database.Event;

public class DetailsFragment extends Fragment {

    Event event;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        event = (Event) getArguments().getSerializable("event_thumbnail");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myInflatedView = inflater.inflate(R.layout.fragment_event_details, container,false);

        setDetails(myInflatedView);

        return myInflatedView;
    }

    private void setDetails(View myInflatedView) {
        TextView titleView = myInflatedView.findViewById(R.id.eventDetailsTitle);
        titleView.setText(event.getName());

        TextView placeView = myInflatedView.findViewById(R.id.eventDetailsPlace);
        placeView.setText(event.getPlace());

        TextView dateView = myInflatedView.findViewById(R.id.eventDetailsDate);
        dateView.setText(event.getDate());

        TextView timeView = myInflatedView.findViewById(R.id.eventDetailsTime);
        timeView.setText(event.getTime());

        TextView descriptionView = myInflatedView.findViewById(R.id.eventDetailsDescription);
        descriptionView.setText(event.getDescription());
    }

}

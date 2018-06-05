package com.example.application.events.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.application.R;
import com.example.application.events.Database.Event;
import com.example.application.events.view.EventActivity;
import com.example.application.events.view.EventsListActivity;

import java.util.List;

public class EventsListAdapter extends RecyclerView.Adapter<EventsListAdapter.EventViewHolder> {

    private final EventsListActivity activity;
    private List<Event> events;

    public EventsListAdapter(List<Event> events, EventsListActivity activity) {
        this.activity = activity;
        this.events = events;
    }


    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View eventView = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_thumbnail, null, false);
        return new EventViewHolder(eventView);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsListAdapter.EventViewHolder holder, int position) {
        Event event = events.get(position);
        holder.titleView.setText(event.getName());
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public void addEvent(Event event) {
        events.add(event);
        notifyDataSetChanged();
    }


    public class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView titleView;
        private final View deleteEvent;

        public EventViewHolder(View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.event_thumbnail_title);
            deleteEvent = itemView.findViewById(R.id.deleteEvent);
            itemView.setOnClickListener(this);
            deleteEvent.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.deleteEvent:
                    Event event = events.get(getAdapterPosition());
                    activity.deleteEvent(event.getEventId());
                    events.remove(event);
                    notifyDataSetChanged();
                    break;
                default:
                    Context context = view.getContext();
                    Intent intent = new Intent(context.getApplicationContext(), EventActivity.class);
                    intent.putExtra("event_thumbnail", events.get(getAdapterPosition()));
                    ((Activity) context).startActivity(intent);

            }
        }
    }
}

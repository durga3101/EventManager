package com.example.application.events.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.application.R;
import com.example.application.events.database.AgendaTopic;
import com.example.application.events.view.event.AgendaFragment;

import java.util.List;

public class AgendaListAdapter extends RecyclerView.Adapter<AgendaListAdapter.AgendaViewHolder> {

    private final AgendaFragment activity;
    private List<AgendaTopic> agendaTopics;

    public AgendaListAdapter(List<AgendaTopic> topics, AgendaFragment activity) {
        this.activity = activity;
        this.agendaTopics = topics;
    }

    @Override
    public AgendaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View agentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.agenda_topic, null, false);
        return new AgendaViewHolder(agentView);
    }

    @Override
    public void onBindViewHolder(@NonNull AgendaListAdapter.AgendaViewHolder holder, int position) {
        AgendaTopic topic = agendaTopics.get(position);
        holder.topicName.setText(topic.getName());
        holder.topicSpeaker.setText(topic.getSpeaker());
        holder.topicTime.setText(topic.getTime());
    }

    @Override
    public int getItemCount() {
        return agendaTopics.size();
    }

    public class AgendaViewHolder extends RecyclerView.ViewHolder {

        private final TextView topicName;
        private final TextView topicSpeaker;
        private final TextView topicTime;

        public AgendaViewHolder(View itemView) {
            super(itemView);
            topicName = itemView.findViewById(R.id.topicName);
            topicSpeaker = itemView.findViewById(R.id.topicSpeaker);
            topicTime = itemView.findViewById(R.id.topicTime);
        }
    }
}

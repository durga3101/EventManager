package com.example.application.events.view.event;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.application.R;
import com.example.application.events.adapters.AgendaListAdapter;
import com.example.application.events.database.AgendaTopic;

import java.util.ArrayList;
import java.util.List;

public class AgendaFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myInflatedView = inflater.inflate(R.layout.fragment_event_agenda, container,false);

        List<AgendaTopic> topics = new ArrayList<>();
        topics.add(new AgendaTopic("keynote1", "speaker1", "6:30 to 7:30pm" ));
        topics.add(new AgendaTopic("keynote2", "speaker2", "7:30 to 8:30pm" ));
        renderTopics(myInflatedView, topics);

        return myInflatedView;
    }

    private void renderTopics(View myInflatedView, List<AgendaTopic> topics) {
        RecyclerView recyclerView = myInflatedView.findViewById(R.id.agenda_list_view);
        AgendaListAdapter agendaListAdapter = new AgendaListAdapter(topics, this);
        recyclerView.setAdapter(agendaListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL));
    }
}

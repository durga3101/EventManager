package com.example.application.events.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.application.R;
import com.example.application.events.Adapters.ViewPagerAdapter;
import com.example.application.events.Database.Event;
import com.example.application.events.view.event.AgendaFragment;
import com.example.application.events.view.event.DetailsFragment;
import com.example.application.events.view.event.VolunteersFragment;

public class EventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.eventTabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(getDetailsFragment(), "Details");
        adapter.addFragment(new AgendaFragment(), "Agenda");
        adapter.addFragment(new VolunteersFragment(), "Volunteers");
        viewPager.setAdapter(adapter);
    }

    private DetailsFragment getDetailsFragment() {
        Event event = (Event) getIntent().getSerializableExtra("event");
        Bundle bundle = new Bundle();
        bundle.putSerializable("event", event);

        DetailsFragment detailsFragment = new DetailsFragment();
        detailsFragment.setArguments(bundle);
        return detailsFragment;
    }
}

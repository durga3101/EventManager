package com.example.application.events.view;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.application.R;
import com.example.application.events.Adapters.ViewPagerAdapter;
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

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new DetailsFragment(), "Details");
        adapter.addFragment(new AgendaFragment(), "Agenda");
        adapter.addFragment(new VolunteersFragment(), "Volunteers");
        viewPager.setAdapter(adapter);
    }
}

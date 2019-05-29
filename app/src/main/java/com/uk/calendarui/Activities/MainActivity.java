package com.uk.calendarui.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.uk.calendarui.Adapters.DatesAdapter;
import com.uk.calendarui.Adapters.EventsAdapter;
import com.uk.calendarui.Model.Date;
import com.uk.calendarui.Model.Event;
import com.uk.calendarui.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
	
	private final int offset = 2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		RecyclerView rvDates = findViewById(R.id.rvDates);
		RecyclerView rvEvents = findViewById(R.id.rvEvents);
		
		
		ArrayList<Date> dates = new ArrayList<>();
		ArrayList<Event> events = new ArrayList<>();
		
		
		//Adding empty objects for offset
		for (int i = 0; i < offset; i++) {
			Date date = new Date();
			date.setNumber("");
			dates.add(date);
		}
		
		//Adding actual date objects
		for (int i = 0; i < 31; i++) {
			Date date = new Date();
			date.setNumber(String.valueOf(i + 1));
			dates.add(date);
		}
		
		
		//Setting random dates as important for demonstration
		dates.get(1 + offset - 1).setImp(true);
		dates.get(8 + offset - 1).setImp(true);
		dates.get(28 + offset - 1).setImp(true);
		
		DatesAdapter adapter = new DatesAdapter(MainActivity.this, dates);
		rvDates.setLayoutManager(new GridLayoutManager(MainActivity.this, 7));
		rvDates.setHasFixedSize(true);
		rvDates.setAdapter(adapter);
		
		
		events.add(new Event("Meeting with Nix", "Today, 21:00 - 22:00"));
		events.add(new Event("Work", "01/08, 09:00 - 17:00"));
		events.add(new Event("Vacation", "01/28, All Day"));
		
		EventsAdapter eventsAdapter = new EventsAdapter(MainActivity.this, events);
		rvEvents.setLayoutManager(new LinearLayoutManager(this));
		rvEvents.setHasFixedSize(true);
		rvEvents.setAdapter(eventsAdapter);
		
	}
}

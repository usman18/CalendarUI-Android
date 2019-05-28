package com.uk.calendarui.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.uk.calendarui.DatesAdapter;
import com.uk.calendarui.Model.Date;
import com.uk.calendarui.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		RecyclerView rvDates = findViewById(R.id.rvDates);
		ArrayList<Date> dates = new ArrayList<>();
		
		for (int i = 0; i < 30; i++) {
			Date date = new Date();
			date.setNumber(String.valueOf(i + 1));
			dates.add(date);
		}
		
		DatesAdapter adapter = new DatesAdapter(MainActivity.this, dates);
		dates.get(5).setImp(true);
		rvDates.setLayoutManager(new GridLayoutManager(MainActivity.this, 7));
		rvDates.setHasFixedSize(true);
		rvDates.setAdapter(adapter);
		
	}
}

package com.uk.calendarui.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uk.calendarui.Model.Event;
import com.uk.calendarui.R;

import java.util.ArrayList;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventsViewHolder>{
	
	private Context context;
	private ArrayList<Event> events;
	
	public EventsAdapter(Context context, ArrayList<Event> events) {
		this.context = context;
		this.events = events;
	}
	
	@NonNull
	@Override
	public EventsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
		return new EventsViewHolder(LayoutInflater.from(context)
		.inflate(R.layout.event_layout, viewGroup, false));
	}
	
	@Override
	public void onBindViewHolder(@NonNull EventsViewHolder eventsViewHolder, int i) {
		Event event = events.get(i);
		
		eventsViewHolder.tvName.setText(event.getName());
		eventsViewHolder.tvDescription.setText(event.getDescription());
		
	}
	
	@Override
	public int getItemCount() {
		if (events != null) {
			return events.size();
		}
		return 0;
	}
	
	class EventsViewHolder extends RecyclerView.ViewHolder {
		TextView tvName;
		TextView tvDescription;
		
		EventsViewHolder(@NonNull View itemView) {
			super(itemView);
			tvName = itemView.findViewById(R.id.tvEventName);
			tvDescription = itemView.findViewById(R.id.tvEventDescription);
		}
	}

}

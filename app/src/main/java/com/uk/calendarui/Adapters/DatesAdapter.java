package com.uk.calendarui.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uk.calendarui.Model.Date;
import com.uk.calendarui.R;

import java.util.ArrayList;

public class DatesAdapter extends RecyclerView.Adapter<DatesAdapter.DatesViewHolder> {
	private static final String TAG = "DatesAdapter";
	private Context context;
	private ArrayList<Date> dates;
	
	public DatesAdapter(Context context, ArrayList<Date> dates) {
		this.context = context;
		this.dates = dates;
	}
	
	@NonNull
	@Override
	public DatesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
		return new DatesViewHolder(LayoutInflater.from(context).inflate(R.layout.date_layout, viewGroup, false));
	}
	
	@Override
	public void onBindViewHolder(@NonNull DatesViewHolder datesViewHolder, int i) {
		
		Date date = dates.get(i);
		
		if (date.getNumber().equals("")) {
			//Empty object for offset
			datesViewHolder.cvImportant.setVisibility(View.INVISIBLE);
			return;
		}
		
		datesViewHolder.cvImportant.setVisibility(View.VISIBLE);
		
		datesViewHolder.tvDayNumber.setText(date.getNumber());
		
		if (date.isImp()) {
			datesViewHolder.tvDayNumber.setTextColor(context.getResources().getColor(R.color.white));
			datesViewHolder.cvImportant.setCardBackgroundColor(context.getResources().getColor(R.color.colorAccent));
		} else  {
			datesViewHolder.tvDayNumber.setTextColor(context.getResources().getColor(R.color.colorPrimary));
			datesViewHolder.cvImportant.setCardBackgroundColor(context.getResources().getColor(R.color.white));
		}
		
	}
	
	@Override
	public int getItemCount() {
		if (dates != null) {
			return dates.size();
		}
		return 0;
	}
	
	class DatesViewHolder extends RecyclerView.ViewHolder {
		
		CardView cvImportant;
		TextView tvDayNumber;
		
		 DatesViewHolder(@NonNull View itemView) {
			super(itemView);
			
			cvImportant = itemView.findViewById(R.id.cvImp);
			tvDayNumber = itemView.findViewById(R.id.tvDateNumber);
			
		}
	}
}

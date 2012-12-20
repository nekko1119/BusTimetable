package com.tbt;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TimetableAdapter extends BaseAdapter
{
	private List<TimeData> timeDataList;
	private Context context;
	private static final int TIME_RANGE = 15;//バスは7時から21時までの15時間ある
	
	private static class ViewHolder
	{
		TextView hour;
		TextView minutes;
	}
	
	public TimetableAdapter(Context context, Area area, Time time)
	{
		super();
		this.context = context;
		this.timeDataList = new ArrayList<TimeData>();
		String[] strings = new String[TIME_RANGE];
		strings = setTimetableStrings(strings, area, time);
		Integer hour;
		for(Integer i = 0; i < TIME_RANGE; ++i)
		{
			//バスは7時からなので、+7している。
			hour = i + 7;
			timeDataList.add(new TimeData(hour.toString() + " :", strings[i]));
		}
	}

	public int getCount()
	{
		return timeDataList.size();
	}

	public TimeData getItem(int position)
	{
		return timeDataList.get(position);
	}

	public long getItemId(int position)
	{
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent)
	{
		TimeData data = getItem(position);
		ViewHolder holder;
		
		if(convertView == null)
		{
			LayoutInflater inflater = LayoutInflater.from(context);
		    convertView = inflater.inflate(R.layout.timetable_listrow, null);
			
		    holder = new ViewHolder();
		    holder.hour = (TextView)convertView.findViewById(R.id.timetable_listview_hour);
		    holder.minutes = (TextView)convertView.findViewById(R.id.timetable_listview_minute);
		    
		    convertView.setTag(holder);
		}
		else
		{
			holder = (ViewHolder)convertView.getTag();
		}
		holder.hour.setText(data.getHour());
		holder.hour.setTextColor(Color.BLUE);
		holder.minutes.setText(data.getMinutes());
		
	    return convertView;
	}
	
	private String[] setTimetableStrings(String[] strings, Area area, Time time)
	{
		//2重switch書いてしまうとは恥ずかしい…
		switch(area)
		{
		case TAKASAKA_TDU:
			strings = getFromTakasaka(strings, time);
			break;
		case TDU_TAKASAKA:
			strings = getToTakasaka(strings, time);
			break;
		case KITASAKADO_TDU:
			strings = getFromKitasakado(strings, time);
			break;
		case TDU_KITASAKADO:
			strings = getToKitasakado(strings, time);
			break;
		case KUMAGAYA_TDU:
			strings = getFromKumagaya(strings, time);
			break;
		case TDU_KUMAGAYA:
			strings = getToKumagaya(strings, time);
			break;
		case KONOSU_TDU:
			strings = getFromKounosu(strings, time);
			break;
		case TDU_KONOSU:
			strings = getToKounosu(strings, time);
			break;
		case TAKASAKI_TDU:
			strings = getFromTakasaki(strings, time);
			break;
		case TDU_TAKASAKI:
			strings = getToTakasaki(strings, time);
			break;
		default:
			break;
		}
		return strings;
	}

	private String[] getFromTakasaka(String[] strings, Time time)
	{
		switch(time)
		{
		case WEEKDAY:
			strings = this.context.getResources().getStringArray(R.array.timetable_weekday_from_takasaka);
			break;
		case SATURDAY:
			strings = this.context.getResources().getStringArray(R.array.timetable_saturday_from_takasaka);
			break;
		case VACATION_WEEKDAY:
			strings = this.context.getResources().getStringArray(R.array.timetable_vacation_weekday_from_takasaka);
			break;
		case VACATION_SATURDAY:
			strings = this.context.getResources().getStringArray(R.array.timetable_vacation_saturday_from_takasaka);
			break;
		default:
			break;
		}
		return strings;
	}
	
	private String[] getToTakasaka(String[] strings, Time time)
	{
		switch(time)
		{
		case WEEKDAY:
			strings = this.context.getResources().getStringArray(R.array.timetable_weekday_to_takasaka);
			break;
		case SATURDAY:
			strings = this.context.getResources().getStringArray(R.array.timetable_saturday_to_takasaka);
			break;
		case VACATION_WEEKDAY:
			strings = this.context.getResources().getStringArray(R.array.timetable_vacation_weekday_to_takasaka);
			break;
		case VACATION_SATURDAY:
			strings = this.context.getResources().getStringArray(R.array.timetable_vacation_saturday_to_takasaka);
			break;
		default:
			break;
		}
		return strings;
	}
	
	private String[] getFromKitasakado(String[] strings, Time time)
	{
		switch(time)
		{
		case WEEKDAY:
			strings = this.context.getResources().getStringArray(R.array.timetable_weekday_from_kitasakado);
			break;
		case SATURDAY:
			strings = this.context.getResources().getStringArray(R.array.timetable_saturday_from_kitasakado);
			break;
		case VACATION_WEEKDAY:
			strings = this.context.getResources().getStringArray(R.array.timetable_vacation_weekday_from_kitasakado);
			break;
		case VACATION_SATURDAY:
		default:
			break;
		}
		return strings;
	}
	
	private String[] getToKitasakado(String[] strings, Time time)
	{
		switch(time)
		{
		case WEEKDAY:
			strings = this.context.getResources().getStringArray(R.array.timetable_weekday_to_kitasakado);
			break;
		case SATURDAY:
			strings = this.context.getResources().getStringArray(R.array.timetable_saturday_to_kitasakado);
			break;
		case VACATION_WEEKDAY:
			strings = this.context.getResources().getStringArray(R.array.timetable_vacation_weekday_to_kitasakado);
			break;
		case VACATION_SATURDAY:
		default:
			break;
		}
		return strings;
	}
	
	private String[] getFromKumagaya(String[] strings, Time time)
	{
		switch(time)
		{
		case WEEKDAY:
			strings = this.context.getResources().getStringArray(R.array.timetable_weekday_from_kumagaya);
			break;
		case SATURDAY:
			strings = this.context.getResources().getStringArray(R.array.timetable_saturday_from_kumagaya);
			break;
		case VACATION_WEEKDAY:
			strings = this.context.getResources().getStringArray(R.array.timetable_vacation_weekday_from_kumagaya);
			break;
		case VACATION_SATURDAY:
			strings = this.context.getResources().getStringArray(R.array.timetable_vacation_saturday_from_kumagaya);
			break;
		default:
			break;
		}
		return strings;
	}
	
	private String[] getToKumagaya(String[] strings, Time time)
	{
		switch(time)
		{
		case WEEKDAY:
			strings = this.context.getResources().getStringArray(R.array.timetable_weekday_to_kumagaya);
			break;
		case SATURDAY:
			strings = this.context.getResources().getStringArray(R.array.timetable_saturday_to_kumagaya);
			break;
		case VACATION_WEEKDAY:
			strings = this.context.getResources().getStringArray(R.array.timetable_vacation_weekday_to_kumagaya);
			break;
		case VACATION_SATURDAY:
			strings = this.context.getResources().getStringArray(R.array.timetable_vacation_saturday_to_kumagaya);
			break;
		default:
			break;
		}
		return strings;
	}
	
	private String[] getFromKounosu(String[] strings, Time time)
	{
		switch(time)
		{
		case WEEKDAY:
			strings = this.context.getResources().getStringArray(R.array.timetable_weekday_from_kounosu);
			break;
		case SATURDAY:
		case VACATION_WEEKDAY:
		case VACATION_SATURDAY:
		default:
			break;
		}
		return strings;
	}
	
	private String[] getToKounosu(String[] strings, Time time)
	{
		switch(time)
		{
		case WEEKDAY:
			strings = this.context.getResources().getStringArray(R.array.timetable_weekday_to_kounosu);
			break;
		case SATURDAY:
		case VACATION_WEEKDAY:
		case VACATION_SATURDAY:
		default:
			break;
		}
		return strings;
	}
	
	private String[] getFromTakasaki(String[] strings, Time time)
	{
		switch(time)
		{
		case WEEKDAY:
			strings = this.context.getResources().getStringArray(R.array.timetable_weekday_from_takasaki);
			break;
		case SATURDAY:
		case VACATION_WEEKDAY:
		case VACATION_SATURDAY:
		default:
			break;
		}
		return strings;
	}
	
	private String[] getToTakasaki(String[] strings, Time time)
	{
		switch(time)
		{
		case WEEKDAY:
			strings = this.context.getResources().getStringArray(R.array.timetable_weekday_to_takasaki);
			break;
		case SATURDAY:
		case VACATION_WEEKDAY:
		case VACATION_SATURDAY:
		default:
			break;
		}
		return strings;
	}
}
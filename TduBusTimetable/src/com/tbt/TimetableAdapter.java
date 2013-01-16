package com.tbt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.content.res.Resources;
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
	private static final int TIME_RANGE = 15;//ƒoƒX‚Í7Žž‚©‚ç21Žž‚Ü‚Å‚Ì15ŽžŠÔ‚ ‚é
	
	static private HashMap<String, String[]> timetableMap = new HashMap<String, String[]>();
	static private boolean isTimetableMapInit = false;
	
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
		if(!isTimetableMapInit)
		{
			setTimetableMap(area, time);
			isTimetableMapInit = true;
		}
		String[] strings = new String[TIME_RANGE];
		strings = timetableMap.get(area.name() + time.name());
		Integer hour;
		for(Integer i = 0; i < TIME_RANGE; ++i)
		{
			//ƒoƒX‚Í7Žž‚©‚ç‚È‚Ì‚ÅA+7‚µ‚Ä‚¢‚éB
			hour = i + 7;
			timeDataList.add(new TimeData(hour.toString() + " :", strings[i]));
		}
		
	}
	
	private void setTimetableMap(Area area, Time time)
	{
		String[] areaStrings = getEnumStrings(area);
		String[] timeStrings = getEnumStrings(time);
		Resources resource = this.context.getResources();
		
		//‚â
		timetableMap.put(areaStrings[0] + timeStrings[0], resource.getStringArray(R.array.timetable_weekday_from_takasaka));
		timetableMap.put(areaStrings[1] + timeStrings[0], resource.getStringArray(R.array.timetable_weekday_to_takasaka));
		timetableMap.put(areaStrings[0] + timeStrings[1], resource.getStringArray(R.array.timetable_saturday_from_takasaka));
		timetableMap.put(areaStrings[1] + timeStrings[1], resource.getStringArray(R.array.timetable_saturday_to_takasaka));
		timetableMap.put(areaStrings[0] + timeStrings[2], resource.getStringArray(R.array.timetable_vacation_weekday_from_takasaka));
		timetableMap.put(areaStrings[1] + timeStrings[2], resource.getStringArray(R.array.timetable_vacation_weekday_to_takasaka));
		timetableMap.put(areaStrings[0] + timeStrings[3], resource.getStringArray(R.array.timetable_vacation_saturday_from_takasaka));
		timetableMap.put(areaStrings[1] + timeStrings[3], resource.getStringArray(R.array.timetable_vacation_saturday_to_takasaka));

		//–kâŒË
		timetableMap.put(areaStrings[2] + timeStrings[0], resource.getStringArray(R.array.timetable_weekday_from_kitasakado));
		timetableMap.put(areaStrings[3] + timeStrings[0], resource.getStringArray(R.array.timetable_weekday_to_kitasakado));
		timetableMap.put(areaStrings[2] + timeStrings[1], resource.getStringArray(R.array.timetable_saturday_from_kitasakado));
		timetableMap.put(areaStrings[3] + timeStrings[1], resource.getStringArray(R.array.timetable_saturday_to_kitasakado));
		timetableMap.put(areaStrings[2] + timeStrings[2], resource.getStringArray(R.array.timetable_vacation_weekday_from_kitasakado));
		timetableMap.put(areaStrings[3] + timeStrings[2], resource.getStringArray(R.array.timetable_vacation_weekday_to_kitasakado));
		timetableMap.put(areaStrings[2] + timeStrings[3], null);
		timetableMap.put(areaStrings[3] + timeStrings[3], null);
		
		//ŒF’J
		timetableMap.put(areaStrings[4] + timeStrings[0], resource.getStringArray(R.array.timetable_weekday_from_kumagaya));
		timetableMap.put(areaStrings[5] + timeStrings[0], resource.getStringArray(R.array.timetable_weekday_to_kumagaya));
		timetableMap.put(areaStrings[4] + timeStrings[1], resource.getStringArray(R.array.timetable_saturday_from_kumagaya));
		timetableMap.put(areaStrings[5] + timeStrings[1], resource.getStringArray(R.array.timetable_saturday_to_kumagaya));
		timetableMap.put(areaStrings[4] + timeStrings[2], resource.getStringArray(R.array.timetable_vacation_weekday_from_kumagaya));
		timetableMap.put(areaStrings[5] + timeStrings[2], resource.getStringArray(R.array.timetable_vacation_weekday_to_kumagaya));
		timetableMap.put(areaStrings[4] + timeStrings[3], resource.getStringArray(R.array.timetable_vacation_saturday_from_kumagaya));
		timetableMap.put(areaStrings[5] + timeStrings[3], resource.getStringArray(R.array.timetable_vacation_saturday_to_kumagaya));
		
		//ƒ‘ƒ
		timetableMap.put(areaStrings[6] + timeStrings[0], resource.getStringArray(R.array.timetable_weekday_from_kounosu));
		timetableMap.put(areaStrings[7] + timeStrings[0], resource.getStringArray(R.array.timetable_weekday_to_kounosu));
		timetableMap.put(areaStrings[6] + timeStrings[1], null);
		timetableMap.put(areaStrings[7] + timeStrings[1], null);
		timetableMap.put(areaStrings[6] + timeStrings[2], null);
		timetableMap.put(areaStrings[7] + timeStrings[2], null);
		timetableMap.put(areaStrings[6] + timeStrings[3], null);
		timetableMap.put(areaStrings[7] + timeStrings[3], null);
		
		//‚è
		timetableMap.put(areaStrings[8] + timeStrings[0], resource.getStringArray(R.array.timetable_weekday_from_takasaki));
		timetableMap.put(areaStrings[9] + timeStrings[0], resource.getStringArray(R.array.timetable_weekday_to_takasaki));
		timetableMap.put(areaStrings[8] + timeStrings[1], null);
		timetableMap.put(areaStrings[9] + timeStrings[1], null);
		timetableMap.put(areaStrings[8] + timeStrings[2], null);
		timetableMap.put(areaStrings[9] + timeStrings[2], null);
		timetableMap.put(areaStrings[8] + timeStrings[3], null);
		timetableMap.put(areaStrings[9] + timeStrings[3], null);

	}
	private String[] getEnumStrings(Area noUse)
	{
		int i = 0;
		String[] strings = new String[Area.values().length];
		for (Area a : Area.values())
		{
			strings[i++] = a.name();
		}
		return strings;
	}
	
	private String[] getEnumStrings(Time noUse)
	{
		int i = 0;
		String[] strings = new String[Time.values().length];
		for (Time t : Time.values())
		{
			strings[i++] = t.name();
		}
		return strings;
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
}
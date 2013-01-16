package com.tbt.scene;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.tbt.Area;
import com.tbt.R;
import com.tbt.Time;
import com.tbt.TimetableAdapter;
import com.tbt.TransformTbtEnums;

public class TimetableActivity extends Activity
{
	Area area;
	Time time;
	
	ListView listView;
	TextView textView;
	Button switchButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timetable);
		
		Intent intent = getIntent();
		area = (Area)intent.getSerializableExtra("Area");
		time = (Time)intent.getSerializableExtra("Time");
		
		setTextView(area, time);				
		setListView(area);
		
		switchButton = (Button)findViewById(R.id.timetable_switch_button);
		switchButton.setOnClickListener(new SwitchButton(this));
	}
	
	public void setTextView(Area area, Time time)
	{
		textView = (TextView)findViewById(R.id.timetable_text);
		textView.setText(TransformTbtEnums.toString(this, time) + " " + TransformTbtEnums.toString(this, area));
	}
	
	public void setListView(Area area)
	{
		this.area = area;
		listView = (ListView)findViewById(R.id.timetable_listview);
		listView.setAdapter(new TimetableAdapter(this, area, time));
	}
	
	public Area getArea()
	{
		return area;
	}
	
	public Time getTime()
	{
		return time;
	}
} 

class SwitchButton implements OnClickListener
{
	private TimetableActivity activity;
	
	public SwitchButton(TimetableActivity activity)
	{
		this.activity = activity;
	}
	
	public void onClick(View v)
	{
		Area area = TransformTbtEnums.reverse(activity.getArea());
		activity.setListView(area);
		activity.setTextView(area, activity.getTime());
	}
}
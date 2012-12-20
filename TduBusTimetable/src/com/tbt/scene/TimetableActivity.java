package com.tbt.scene;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timetable);
		
		Intent intent = getIntent();
		area = (Area)intent.getSerializableExtra("Area");
		time = (Time)intent.getSerializableExtra("Time");
		
		textView = (TextView)findViewById(R.id.timetable_text);
		textView.setText(TransformTbtEnums.toStringFromTime(this, time) + " " + TransformTbtEnums.toStringFromArea(this, area));
				
		listView = (ListView)findViewById(R.id.timetable_listview);
		listView.setAdapter(new TimetableAdapter(this, area, time));
	}
} 
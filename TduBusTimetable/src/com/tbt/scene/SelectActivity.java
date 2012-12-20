package com.tbt.scene;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Spinner;

import com.tbt.Area;
import com.tbt.R;
import com.tbt.Time;
import com.tbt.TransformTbtEnums;

public class SelectActivity extends Activity
{
	//widgets
	private Spinner timeSpinner;
	private Spinner areaSpinner;
	private Button showButton;
	
	//spinner statuses
	private String timeString;
	private String areaString;
	
	public String getTimeString()
	{
		return timeString;
	}
	
	public void setTimeString(String string)
	{
		timeString = string;
	}
	
	public String getAreaString()
	{
		return areaString;
	}
	
	public void setAreaString(String string)
	{
		areaString = string;
	}
	
	@Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        
        timeSpinner = (Spinner)findViewById(R.id.select_time_spinner);
        timeSpinner.setOnItemSelectedListener(new TimeSpinner(this));
        
        areaSpinner = (Spinner)findViewById(R.id.select_area_spinner);
        areaSpinner.setOnItemSelectedListener(new AreaSpinner(this));
        
        showButton = (Button)findViewById(R.id.select_show_button);
        showButton.setOnClickListener(new ShowButton(this));
    }
}

class TimeSpinner implements OnItemSelectedListener
{
	private SelectActivity activity;
	
	public TimeSpinner(SelectActivity activity)
	{
		this.activity = activity;
	}
	
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3)
	{
		Spinner spinner = (Spinner)arg0;
		String item = (String)spinner.getSelectedItem();
		activity.setTimeString(item);
	}

	public void onNothingSelected(AdapterView<?> arg0)
	{
	}
}

class AreaSpinner implements OnItemSelectedListener
{
	private SelectActivity activity;
	
	public AreaSpinner(SelectActivity activity)
	{
		this.activity = activity;
	}
	
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3)
	{
		Spinner spinner = (Spinner)arg0;
		String item = (String)spinner.getSelectedItem();
		activity.setAreaString(item);
	}

	public void onNothingSelected(AdapterView<?> arg0)
	{
	}
}

class ShowButton implements OnClickListener
{
	private SelectActivity activity;
	
	public ShowButton(SelectActivity activity)
	{
		this.activity = activity;
	}

	public void onClick(View v)
	{
		Area area = TransformTbtEnums.toArea(activity, activity.getAreaString());
		Time time = TransformTbtEnums.toTime(activity, activity.getTimeString());
		Intent intent = new Intent(activity.getApplicationContext(), TimetableActivity.class);
		intent.putExtra("Area", area);
		intent.putExtra("Time", time);
		activity.startActivity(intent);
	}
}
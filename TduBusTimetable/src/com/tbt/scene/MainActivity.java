package com.tbt.scene;

import com.tbt.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity
{
	Button readButton;
	Button updateButton;
	
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        readButton = (Button)findViewById(R.id.main_read_button);
        readButton.setOnClickListener(new ReadButton(this));
    }
}

class ReadButton implements OnClickListener
{
	private MainActivity activity;
	
	public ReadButton(MainActivity activity)
	{
		this.activity = activity;
	}
	
	public void onClick(View v)
	{
		Intent intent = new Intent(activity.getApplicationContext(), SelectActivity.class);
		activity.startActivity(intent);
	}
}

class UpdateButton implements OnClickListener
{
	private MainActivity activity;
	
	public UpdateButton(MainActivity activity)
	{
		this.activity = activity;
	}
	
	public void onClick(View v)
	{
		Toast.makeText(activity, "ñ¢é¿ëïÅI", Toast.LENGTH_LONG).show();
	}
}
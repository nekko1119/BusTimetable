package com.tbt.scene;

import com.tbt.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.widget.Button;
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
		switch(v.getId())
		{
		case R.id.main_read_button:
		{
			Intent intent = new Intent(activity.getApplicationContext(), SelectActivity.class);
			activity.startActivity(intent);
			break;
		}
		default:
		{
			assert false : "default‚Í‚ ‚è‚¦‚È‚¢";
			break;
		}
		}
	}
}
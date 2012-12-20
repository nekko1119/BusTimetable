package com.tbt;

public class TimeData
{
	private String hour;
	private String minutes;

	public TimeData(String hour, String minutes)
	{
		this.hour = hour;
		this.minutes = minutes;
	}

	public String getHour()
	{
		return hour;
	}

	public String getMinutes()
	{
		return minutes;
	}
}
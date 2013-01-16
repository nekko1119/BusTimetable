package com.tbt;

import android.content.Context;

public class TransformTbtEnums
{
	public static Area toArea(Context context, String string)
	{
		String[] str = context.getResources().getStringArray(R.array.select_areas);
		if(string.equals(str[0]))
		{
			return Area.TAKASAKA_TDU;
		}
		else if(string.equals(str[1]))
		{
			return Area.TDU_TAKASAKA;
		}
		else if(string.equals(str[2]))
		{
			return Area.KITASAKADO_TDU;
		}
		else if(string.equals(str[3]))
		{
			return Area.TDU_KITASAKADO;
		}
		else if(string.equals(str[4]))
		{
			return Area.KUMAGAYA_TDU;
		}
		else if(string.equals(str[5]))
		{
			return Area.TDU_KUMAGAYA;
		}
		else if(string.equals(str[6]))
		{
			return Area.KONOSU_TDU;
		}
		else if(string.equals(str[7]))
		{
			return Area.TDU_KONOSU;
		}
		else if(string.equals(str[8]))
		{
			return Area.TAKASAKI_TDU;
		}
		else if(string.equals(str[9]))
		{
			return Area.TDU_TAKASAKI;
		}
		else
		{
			return null;
		}
	}
	
	public static String toString(Context context, Area area)
	{
		String[] areaString = context.getResources().getStringArray(R.array.select_areas);
		switch(area)
		{
		case TAKASAKA_TDU:
			return areaString[0];
		case TDU_TAKASAKA:
			return areaString[1];
		case KITASAKADO_TDU:
			return areaString[2];
		case TDU_KITASAKADO:
			return areaString[3];
		case KUMAGAYA_TDU:
			return areaString[4];
		case TDU_KUMAGAYA:
			return areaString[5];
		case KONOSU_TDU:
			return areaString[6];
		case TDU_KONOSU:
			return areaString[7];
		case TAKASAKI_TDU:
			return areaString[8];
		case TDU_TAKASAKI:
			return areaString[9];
		default:
			return null;
		}
	}
	
	public static Time toTime(Context context, String string)
	{
		String[] str = context.getResources().getStringArray(R.array.select_times);
		
		if(string.equals(str[0]))
		{
			return Time.WEEKDAY;
		}
		else if(string.equals(str[1]))
		{
			return Time.SATURDAY;
		}
		else if(string.equals(str[2]))
		{
			return Time.VACATION_WEEKDAY;
		}
		else if(string.equals(str[3]))
		{
			return Time.VACATION_SATURDAY;
		}
		else
		{
			return null;
		}
	}
	
	public static String toString(Context context, Time time)
	{
		String[] timeString = context.getResources().getStringArray(R.array.select_times);
		switch(time)
		{
		case WEEKDAY:
			return timeString[0];
		case SATURDAY:
			return timeString[1];
		case VACATION_WEEKDAY:
			return timeString[2];
		case VACATION_SATURDAY:
			return timeString[3];
		default:
			return null;
		}
	}
	
	public static Area reverse(Area area)
	{
		switch (area)
		{
		case TAKASAKA_TDU:
			return Area.TDU_TAKASAKA;
		case TDU_TAKASAKA:
			return Area.TAKASAKA_TDU;
		case KITASAKADO_TDU:
			return Area.TDU_KITASAKADO;
		case TDU_KITASAKADO:
			return Area.KITASAKADO_TDU;
		case KUMAGAYA_TDU:
			return Area.TDU_KUMAGAYA;
		case TDU_KUMAGAYA:
			return Area.KUMAGAYA_TDU;
		case KONOSU_TDU:
			return Area.TDU_KONOSU;
		case TDU_KONOSU:
			return Area.KONOSU_TDU;
		case TAKASAKI_TDU:
			return Area.TDU_TAKASAKI;
		case TDU_TAKASAKI:
			return Area.TAKASAKI_TDU;
		default:
			return null;
		}
	}
}

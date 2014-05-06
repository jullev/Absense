package id.flwi.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import android.content.Context;
import android.util.Log;

public class DateUtil{

	private static Calendar substractCalendar(Calendar calendar, int val) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(calendar.getTime());
		cal.add(Calendar.DATE, val);
		return cal;
	}

	public static String CalendarToString(Calendar calendar, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format,
				Locale.ENGLISH);
		String dateString = dateFormat.format(calendar.getTime());
		return dateString;
	}

	public static Date strTodate(String dateString, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format,Locale.ENGLISH);
		Date date = new Date();
		try {
			date = dateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static String CalendarToString(Date calendar, String format){
		SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
		String dateString = dateFormat.format(calendar.getTime());
        return dateString;
	}

//	public static Date strJpnToDate(Context context, String strDate) {
//		int year = Integer.valueOf(strDate.substring(0, 4));
//		int posBulan = strDate.indexOf(context.getResources().getString(R.string.month));
//		int month = 0;
//		if (posBulan == 6) {
//			month = Integer.valueOf(strDate.substring(5, 6));
//		} else {
//			month = Integer.valueOf(strDate.substring(5, 7));
//		}
//		int day = Integer.valueOf(strDate.substring(posBulan + 1, strDate.length() - 1));
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = new Date();
//		try {
//			date = dateFormat.parse(year + "-" + month + "-" + day);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////		Log.i("Date", "Date String "+year + "-" + month + "-" + day+" date "+date.toLocaleString());
//		return date;
//	}

	public static Calendar dateToCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}
	public static Date calendarToDate(Calendar calendar) {
		Date date = new Date();
		date.setTime(calendar.getTimeInMillis());
		return date;
	}
	public static Calendar cleanCalendarTime(Calendar calendar){
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		
		return calendar;
	}
}

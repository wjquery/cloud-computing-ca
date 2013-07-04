package sg.edu.nus.iss.eleave.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Xiong Gaogao
 * @metric_id A0015118U
 *
 */
public class DateUtil {
	
	public static final String DEFAULT_FORMAT = "yyyy-MM-dd";
	public static final String LONG_FORMAT = "yyyy MMM dd";
			
	public static Date parse(String date, String pattern) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.parse(date);
	}
	
	public static String format(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	/**
	 * get the Date # of days after/before the parameter date
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date getDate(Date date, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, day);
		return cal.getTime();
	}
	
	public static Date getNextDate(Date date) {
		return getDate(date, 1);
	}
	
	public static boolean IsSameDay(Date d1, Date d2) {
		if (d1 == null || d2 == null)
			return false;
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(d1);
		cal2.setTime(d2);
		return (cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
				&& cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) 
				&& cal1.get(Calendar.DATE) == cal2.get(Calendar.DATE));
	}
}

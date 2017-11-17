package giantsweetroll;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class GDateManager.
 */
public class GDateManager 
{
	
	/** The Constant sdf. */
	private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
    /**
     * Gets the current date time.
     *
     * @return the current date time
     */
    public static String getCurrentDateTime()
    {
    	Date date = new Date();
    	
    	return sdf.format(date);
    }
    
    /**
     * Gets the local date.
     *
     * @return the local date
     */
    public static String getLocalDate()
    {
    	LocalDate localDate = LocalDate.now();
    	
    	return DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate);
    }
    
    /**
     * Gets the current year.
     *
     * @return the current year
     */
    public static String getCurrentYear()
    {
    	String date = getLocalDate();
    	
    	return date.substring(0,4);
    }
    
    /**
     * Gets the current month.
     *
     * @return the current month
     */
    public static String getCurrentMonth()
    {
    	String date = getLocalDate();
    	
    	return date.substring(5, 7);
    }
    
    /**
     * Gets the current day.
     *
     * @return the current day
     */
    public static String getCurrentDay()
    {
    	String date = getLocalDate();
    	
    	return date.substring(8, 10);
    }
    
    /**
     * Gets the local time.
     *
     * @return the local time
     */
    public static String getLocalTime()
    {
    	String dateTime = getCurrentDateTime();
    	
    	return dateTime.substring(11, 19);
    }
    
    /**
     * Gets the current hour.
     *
     * @return the current hour
     */
    public static String getCurrentHour()
    {
    	String time = getLocalTime();
    	
    	return time.substring(0, 2);
    }
    
    /**
     * Gets the current minute.
     *
     * @return the current minute
     */
    public static String getCurrentMinute()
    {
    	String time = getLocalTime();
    	
    	return time.substring(3, 5);
    }
    
    /**
     * Gets the current second.
     *
     * @return the current second
     */
    public static String getCurrentSecond()
    {
    	String time = getLocalTime();
    	
    	return time.substring(6, 8);
    }
}

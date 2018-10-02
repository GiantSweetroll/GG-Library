package giantsweetroll.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class GDateManager.
 */
public class DateManager 
{
public static final byte FEBRUARY = 2;
	
	public static final byte[] MONTHS_31 = {1, 3, 5, 7, 8, 10, 12};
	public static final byte[] MONTHS_30 = {2, 4, 6, 9, 11};
	
	public static final List<String> MONTH_NAME_LIST = getMonthNameList();
	
	public static final short START_YEAR_RANGE = 1800;
	
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
    
    public static byte[] getMaxDays(byte month, short year)
	{
		byte[] days;
		
		if (month == FEBRUARY)
		{
			if (isLeapYear(year))
			{
				days = new byte[29];
				for (byte i=0; i<days.length; i++)
				{
					days[i] = (byte)(i+1);
				}
			}
			else
			{
				days = new byte[28];
				for (byte i=0; i<days.length; i++)
				{
					days[i] = (byte)(i+1);
				}
			}
		}
		else
		{
			if (is30Days(month))
			{
				days = new byte[30];
				for (byte i=0; i<days.length; i++)
				{
					days[i] = (byte)(i+1);
				}
			}
			else
			{
				days = new byte[31];
				for (byte i=0; i<days.length; i++)
				{
					days[i] = (byte)(i+1);
				}
			}
		}
		
		return days;
	}
	public static short[] getYearRange()
	{
		short startYear = START_YEAR_RANGE;
		short maxYear = Short.parseShort(DateManager.getCurrentYear());
		
		short[] years;
		
		if (startYear == maxYear)
		{
			years = new short[1];
			years[0] = startYear;
		}
		else
		{
			short range = (short)(maxYear - startYear);
			years = new short[range+1];
			
			for (short i=0; i<=range; i++)
			{
				years[i] = (short)(startYear+i);
			}
		}
		
		return years;
	}
	public static String[] getYearRangeString()
	{
		short[] raw = getYearRange();
		String[] string = new String[raw.length];
		
		for (int i=0; i<string.length; i++)
		{
			string[i] = Short.toString(raw[i]);
		}
		
		return string;
	}
	public static String[] getMaxDaysString(byte month, short year)
	{
		byte[] days = getMaxDays(month, year);
		String[] daysString = new String[days.length];
		
		for (int i=0; i<daysString.length; i++)
		{
			if (isOneDigit(Byte.toString(days[i])))
			{
				daysString[i] = 0 + Byte.toString(days[i]);
			}
			else
			{
				daysString[i] = Byte.toString(days[i]);
			}
		}
		
		return daysString;
	}
	public static String[] getMonthsString()
	{
		String[] arr = new String[12];
		
		for (int i=0; i<arr.length; i++)
		{
			if (isOneDigit(Integer.toString(i)))
			{
				arr[i] = 0 + Integer.toString(i+1);
			}
			else
			{
				arr[i] = Integer.toString(i+1);
			}
		}
		
		return arr;
	}
	public static boolean is30Days(byte month)
	{
		for (int i=0; i<MONTHS_30.length; i++)
		{
			if (month == MONTHS_30[i])
			{
				return true;
			}
		}
		return false;
	}
	public static boolean is31Days(byte month)
	{
		for (int i=0; i<MONTHS_31.length; i++)
		{
			if (month == MONTHS_31[i])
			{
				return true;
			}
		}
		return false;
	}
	public static boolean isLeapYear(int year)
	{
		if (year%4==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static String[] getYearRangeStringReversed()
	{
		List<String> list = Arrays.asList(getYearRangeString());
		Collections.reverse(list);
		return list.toArray(new String[list.size()]);
	}
	
	public static final List<String> getMonthNameList()
	{
		List<String> list = new ArrayList<String>();
		
		list.add("JANUARY");
		list.add("FEBRUARY");
		list.add("MARCH");
		list.add("APRIL");
		list.add("MAY");
		list.add("JUNE");
		list.add("JULY");
		list.add("AUGUST");
		list.add("SEPTEMBER");
		list.add("OCTOBER");
		list.add("NOVEMBER");
		list.add("DECEMBER");
		
		return list;
	}
	
	public static boolean isOneDigit(String value)
	{
		if (value.length()==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}

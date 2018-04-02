package giantsweetroll.test;

import giantsweetroll.date.Date;

public class Test 
{	
	public static void main(String args[])
	{
		Date date = new Date(3, 2, 2018);
		Date date2 = new Date(3, 2, 2015);
		
		System.out.println(Date.getDaysDifference(date, date2, false));
	}
}

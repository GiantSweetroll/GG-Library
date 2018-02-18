package giantsweetroll.numbers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;

public class GNumbers 
{
	//Randomization
	public static int radomize(int min, int max)
	{
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
	public static long randomize(long min, long max)
	{
		return ThreadLocalRandom.current().nextLong(min, max + 1);
	}
	
	//Getting Length of number
	public static int getLength(BigInteger value)
	{	
		return value.toString().length();
	}
	
	public static int getLength(BigDecimal value)
	{
		return value.toPlainString().length();
	}
	
	//Checking for prime number
	public static boolean isPrime(double value)		//Checks if number is prime
	{
		double divisor = 0;
		
		if (value%2==0)
		{
			return false;
		}
		
		for (double i=3; i*i<value; i+=2)
		{
	//		System.out.println("Checking for factors of " + value + " (" + i + ")...");
			divisor = value%i;
			
			if (divisor==0)
			{
				return false;
			}
		}
		
		return true;
	}
	public static boolean isPrime(int value)		//Checks if number is prime
	{
		int divisor = 0;
		
		if (value%2==0)
		{
			return false;
		}
		
		for (int i=3; i*i<value; i+=2)
		{
	//		System.out.println("Checking for factors of " + value + " (" + i + ")...");
			divisor = value%i;
			
			if (divisor==0)
			{
				return false;
			}
		}
		
		return true;
	}
	public static boolean isPrime(float value)		//Checks if number is prime
	{
		float divisor = 0;
		
		if (value%2==0)
		{
			return false;
		}
		
		for (float i=3; i*i<value; i+=2)
		{
	//		System.out.println("Checking for factors of " + value + " (" + i + ")...");
			divisor = value%i;
			
			if (divisor==0)
			{
				return false;
			}
		}
		
		return true;
	}
	
	
	public static float round(float value, int precision)
	{
	    int scale = (int) Math.pow(10, precision);
	    return (float) Math.round(value * scale) / scale;
	}
	public static double round(double value, int precision)
	{
	    int scale = (int) Math.pow(10, precision);
	    return (double) Math.round(value * scale) / scale;
	}
	
	/*
	public static float round(float value, int decimalPlaces)
	{
		if (decimalPlaces < 0)
		{
			throw new NumberFormatException("Invalid decimal places: " + decimalPlaces);
		}
		
		String valueString = Float.toString(value);
		
		//Check the decimal place of value
		String decimals = valueString.substring(valueString.indexOf(".")+1, valueString.length());
		if (decimals.length() < decimalPlaces)
		{
			StringBuilder sb = new StringBuilder(valueString);
			int diff = decimalPlaces - decimals.length();
			for (int i=0; i<=diff; i++)
			{
				sb.append("0");
			}
			valueString = sb.toString();
		}
		else if (decimals.length()==decimalPlaces)
		{
			return value;
		}
		
		valueString = valueString.substring(0, valueString.indexOf(".")+ decimalPlaces + 2);	//Reduce to the decimal place + 1
		
		System.out.println("valueString: " + Float.parseFloat(valueString));
		
		//Round
		String trimmedValue = valueString.substring(0, valueString.length()-1);   //value string with proper decimal places
		System.out.println("trimmedValue: " + Float.parseFloat(trimmedValue));
		float smallestDecimal = Float.parseFloat(valueString) - Float.parseFloat(trimmedValue);
		System.out.println("smallestDecimal before trim: " + smallestDecimal);
		int lastDecimal = Integer.parseInt(valueString.substring(valueString.length()-1, valueString.length()));
		System.out.println("lastDecimal: " + lastDecimal);
		smallestDecimal = Float.parseFloat(Float.toString(smallestDecimal).substring(0, Float.toString(smallestDecimal).indexOf(Integer.toString(lastDecimal))+1));
		System.out.println("smallestDecimal after trim: " + smallestDecimal);
		if (lastDecimal>=5 && lastDecimal<10)
		{
			String smallestDecimalString = Float.toString(smallestDecimal);
			StringBuilder sb = new StringBuilder(smallestDecimalString.substring(0, smallestDecimalString.length()-2));
			sb.append("1");
			return Float.parseFloat(trimmedValue) + Float.parseFloat(sb.toString());
			
//			float trimmedLastDecimal = Float.parseFloat(trimmedValue) % Float.parseFloat(trimmedValue.substring(0, trimmedValue.length()-1));
//			return trimmedLastDecimal;
		}
		else
		{
			return Float.parseFloat(trimmedValue);
		}
	}
	
	public static void main(String args[])
	{
		System.out.println(round(29.3955f, 3));
	}
	*/
}

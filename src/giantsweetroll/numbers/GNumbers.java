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
}

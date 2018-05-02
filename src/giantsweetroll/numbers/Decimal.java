package giantsweetroll.numbers;

import java.util.ArrayList;

//TODO: Auto-generated Javadoc
/**
* The Class Decimal.
*/
public final class Decimal 
{	
	public static final long getDecimalFromHexa(String hexa)
	{
		long dec = 0;
		//Reverse Hexa digits
		StringBuilder sb = new StringBuilder(hexa);
		sb.reverse();
		hexa = sb.toString();
		
		//separate hexa digits (while converting letters to numbers)
		ArrayList<String> hexaDigits = new ArrayList<String>();
		for (int i=0; i<hexa.length(); i++)
		{
			String temp = hexa.substring(i, i+1);
			temp = Integer.toString(Hexadecimal.getSingularDecimalValue(temp));
			hexaDigits.add(temp);
		}
		
		//raise 16 to the power of the digit, multiply it by the value of the digit, then add to get decimal
		for (int i=0; i<hexaDigits.size(); i++)
		{
			dec += Long.parseLong(hexaDigits.get(i)) * (long)Math.pow(16, i);
		}
		
		return dec;
	}
	public static final long getDecimalFromOctal(String octal)
	{
		long dec = 0;
		//Reverse octal digits
		StringBuilder sb = new StringBuilder(octal);
		sb.reverse();
		octal = sb.toString();
		
		//raise 8 to the power of the digits, multiply it by the value of the digit, 
		//then add to get decimal
		for (int i=0; i<octal.length(); i++)
		{
			String temp = octal.substring(i,i+1);
			if (!temp.equals("0"));
			{
				dec += Long.parseLong(temp) * (long)Math.pow(8, i);
			}
		}
		return dec;
	}
	public static final long getDecimalFromBinary(String binary)
	{
		long dec = 0;
		StringBuilder sb = new StringBuilder(binary);
		sb.reverse();
		binary = sb.toString();
		
		for (int i=0; i<binary.length(); i++)
		{
			String temp = binary.substring(i, i+1);
			if (temp.equals("1"))
			{
				dec += Math.pow(2, i);
			}
		}
		
		return dec;
	}
}

package giantsweetroll.numbers;

import java.util.ArrayList;

public final class Octal
{
	
	/**
	 * Gets the octal.
	 *
	 * @param decimal the decimal
	 * @return the octal
	 */
	public static String getOctal(long decimal)
	{
		StringBuilder octal = new StringBuilder();
		ArrayList<String> binaryCut = new ArrayList<String>();
		
		StringBuilder sb = new StringBuilder(Binary.getBinaryFromDecimal(decimal));
		sb.reverse();
		//Check if binary digit is divisible by 3
		int remainder = sb.length()%3;
		if (remainder == 1)
		{
			sb.append("0");
			sb.append("0");
		}
		else if (remainder == 2)
		{
			sb.append("0");
		}
		sb.reverse();
		
		String binary = sb.toString();
		//Divide binary to 3 members per group
		boolean done = false;
		int awal = 0;
		int akhir = 3;
		while (!done)
		{
			if (akhir+1>=binary.length())
			{
				akhir = binary.length();
				done = true;
			}
			
			binaryCut.add(binary.substring(awal, akhir));
			awal+=3;
			akhir+=3;
		}
		
		//Changing all the numbers in each digit to decimal
		for (int i=0; i<binaryCut.size(); i++)
		{
			String temp = binaryCut.get(i);
			binaryCut.set(i, Long.toString(Decimal.getDecimalFromBinary(temp)));
		}
		
		//merge the octal decimal
		for (int i=0; i<binaryCut.size(); i++)
		{
			octal.append(binaryCut.get(i));
		}
		
		return octal.toString();
	}

	/**
	 * Checks if is octal.
	 *
	 * @param octal the octal
	 * @return true, if is octal
	 */
	public static boolean isOctal(String octal)
	{
		//Check if it contains any number greater than 7
		for (int i=0; i<octal.length(); i++)
		{
			if (Integer.parseInt(octal.substring(i,  i+1)) > 7)
			{
				return false;
			}
		}
		
		return true;
	}
}

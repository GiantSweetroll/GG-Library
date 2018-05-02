package giantsweetroll.numbers;

import java.util.ArrayList;

public final class Hexadecimal 
{
	
	/** The Constant HEXA_LIST. */
	public static final String[] HEXA_LIST = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
												"A", "B", "C", "D", "E", "F"};
	
	/** The Constant NOT_HEXA_DIGIT. */
	private static final int NOT_HEXA_DIGIT = 16;
	
	/**
	 * Gets the hexa decimal.
	 *
	 * @param decimal the decimal
	 * @return the hexa decimal
	 */
	public static String getHexaDecimal(long decimal)
	{
		StringBuilder hexa = new StringBuilder();
		ArrayList<String> binaryCut = new ArrayList<String>();
		
		StringBuilder sb = new StringBuilder(Binary.getBinaryFromDecimal(decimal));
		sb.reverse();
		//Check if binary digit is divisible by 4
		int remainder = sb.length()%4;
		if (remainder == 1)
		{
			sb.append("0");
			sb.append("0");
			sb.append("0");
		}
		else if (remainder == 2)
		{
			sb.append("0");
			sb.append("0");
		}
		else if (remainder == 3)
		{
			sb.append("0");
		}
		sb.reverse();
		
		String binary = sb.toString();
		//Divide binary to 4 members per group
		boolean done = false;
		int awal = 0;
		int akhir = 4;
		while (!done)
		{
			if (akhir+1>=binary.length())
			{
				akhir = binary.length();
				done = true;
			}
			
			binaryCut.add(binary.substring(awal, akhir));
			awal+=4;
			akhir+=4;
		}
		
		//Changing all the numbers greater than 9
		for (int i=0; i<binaryCut.size(); i++)
		{
			String temp = binaryCut.get(i);
			binaryCut.set(i, getSingularHexaValue((int)Decimal.getDecimalFromBinary(temp)));
		}
		
		//merge the hexa decimal
		hexa = new StringBuilder();
		for (int i=0; i<binaryCut.size(); i++)
		{
			hexa.append(binaryCut.get(i));
		}
		
		return hexa.toString();
	}
	
	/**
	 * Gets the singular hexa value.
	 *
	 * @param value the value
	 * @return the singular hexa value
	 */
	public static final String getSingularHexaValue(int value)
	{	
		return Hexadecimal.HEXA_LIST[value];
	}

	/**
	 * Gets the singular decimal value.
	 *
	 * @param hexa the hexa
	 * @return the singular decimal value
	 */
	public static final int getSingularDecimalValue(String hexa)
	{
		int value = NOT_HEXA_DIGIT;
		
		for (int i=0; i<Hexadecimal.HEXA_LIST.length; i++)
		{
			if (hexa.equalsIgnoreCase(Hexadecimal.HEXA_LIST[i]))
			{
				value = i;
				break;
			}
		}	
		
		return value;
	}

	/**
	 * Checks if is hexa.
	 *
	 * @param hexa the hexa
	 * @return true, if is hexa
	 */
	public static final boolean isHexa(String hexa)
	{
		for (int i=0; i<hexa.length(); i++)
		{
			if (Hexadecimal.getSingularDecimalValue(hexa.substring(i,  i+1)) == NOT_HEXA_DIGIT)
			{
				return false;
			}
		}
		return true;
	}
}

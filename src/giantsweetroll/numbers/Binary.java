package giantsweetroll.numbers;

public final class Binary 
{	
	
	/**
	 * Gets the binary from decimal.
	 *
	 * @param decimal the decimal
	 * @return the binary from decimal
	 */
	public static final String getBinaryFromDecimal(long decimal)
	{
		if (decimal == 0)
		{
			return "0";
		}
		else
		{
			StringBuilder binary = new StringBuilder();
			while (decimal>0)
			{
				binary.append(Long.toString(decimal%2));
				decimal/=2;
			}
			return binary.reverse().toString();
		}
	}
	
	/**
	 * Checks string is binary.
	 *
	 * @param binary the binary
	 * @return true, if is binary
	 */
	public static final boolean isBinary(String binary)
	{
		for (int i=0; i<binary.length(); i++)
		{
			String code = binary.substring(i,  i+1);
			if (!code.equals("0") && !code.equals("1"))
			{
				return false;
			}
		}
		return true;
	}
}

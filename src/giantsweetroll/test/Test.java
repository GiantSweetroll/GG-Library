package giantsweetroll.test;

import giantsweetroll.numbers.Binary;
import giantsweetroll.numbers.Hexadecimal;
import giantsweetroll.numbers.Octal;

public class Test 
{	
	public static void main(String args[])
	{
		long decimal = 12;
		System.out.println(Binary.getBinaryFromDecimal(decimal));
		System.out.println(Octal.getOctal(decimal));
		System.out.println(Hexadecimal.getHexaDecimal(decimal));
	}
}

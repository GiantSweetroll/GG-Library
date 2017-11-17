package giantsweetroll;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class Convert.
 */
public class Convert 
{
	
	/**
	 * Convert Map to LinkedHashMap.
	 *
	 * @param map the map
	 * @return the linked hash map
	 */
	public LinkedHashMap<Object, Object> toLinkedHashMap(Map<Object, Object> map)
	{
		LinkedHashMap<Object, Object> mapLink = new LinkedHashMap<Object, Object>(map);
		
		return mapLink;
	}
	
	/**
	 * Convert String to Char array.
	 *
	 * @param string the string
	 * @return the char[]
	 */
	public char[] toCharArray(String string)
	{
		char[] array = new char[string.length()];
		
		for (int i=0; i<array.length; i++)
		{
			array[i] = string.charAt(i);
		}
		
		return array;
	}
	
	/**
	 * Convert Char array to String.
	 *
	 * @param charArray the char array
	 * @return the string
	 */
	public String toString(char[] charArray)
	{
		String string = "";
		
		for (int i=0; i<charArray.length; i++)
		{
			string += Character.toString(charArray[i]);
		}
		
		return string;
	}
	
	/**
	 * Convert ArrayList to standard array.
	 *
	 * @param list the list
	 * @return the object[]
	 */
	public static Object[] toArray (ArrayList<Object> list)
	{
		Object[] data = new Object[list.size()];
		
		for (int i=0; i<data.length; i++)
		{
			data[i] = list.get(i);
		}
		
		return data;
	}
	
	/**
	 * Convert standard array to ArrayList.
	 *
	 * @param array the array
	 * @return the array list
	 */
	public static ArrayList<Object> toArrayList (Object[] array)
	{
		ArrayList<Object> data = new ArrayList<Object>();
		
		for (int i=0; i<array.length; i++)
		{
			data.add(array[i]);
		}
		
		return data;
	}
	
	/**
	 * To integer.
	 *
	 * @param number the number
	 * @return the int
	 */
	public static int toInteger(BigInteger number)
	{
		return Integer.parseInt(number.toString().replaceAll(".", ""));
	}
	
	/**
	 * To integer.
	 *
	 * @param number the number
	 * @return the int
	 */
	public static int toInteger(BigDecimal number)
	{
		return Integer.parseInt(number.toPlainString().replaceAll(".", ""));
	}
	
	/**
	 * To double.
	 *
	 * @param number the number
	 * @return the double
	 */
	public static double toDouble(int number)
	{
		return Double.parseDouble(Integer.toString(number).replaceAll(".", ""));
	}
	
	/**
	 * To double.
	 *
	 * @param number the number
	 * @return the double
	 */
	public static double toDouble(float number)
	{
		return Double.parseDouble(Float.toHexString(number).replaceAll(".", ""));
	}
	
	/**
	 * To double.
	 *
	 * @param number the number
	 * @return the double
	 */
	public static double toDouble(BigInteger number)
	{
		return Double.parseDouble(number.toString().replaceAll(".", ""));
	}
	
	/**
	 * To double.
	 *
	 * @param number the number
	 * @return the double
	 */
	public static double toDouble(BigDecimal number)
	{
		return Double.parseDouble(number.toPlainString().replaceAll(".", ""));
	}
	
	/**
	 * To float.
	 *
	 * @param number the number
	 * @return the float
	 */
	public static float toFloat(int number)
	{
		return Float.parseFloat(Integer.toString(number).replaceAll(".", ""));
	}
	
	/**
	 * To float.
	 *
	 * @param number the number
	 * @return the float
	 */
	public static float toFloat(double number)
	{
		return Float.parseFloat(Double.toString(number).replaceAll(".", ""));
	}
	
	/**
	 * To float.
	 *
	 * @param number the number
	 * @return the float
	 */
	public static float toFloat(BigInteger number)
	{
		return Float.parseFloat(number.toString().replaceAll(".", ""));
	}
	
	/**
	 * To float.
	 *
	 * @param number the number
	 * @return the float
	 */
	public static float toFloat(BigDecimal number)
	{
		return Float.parseFloat(number.toPlainString().replaceAll(".", ""));
	}
}

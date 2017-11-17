package giantsweetroll.message;

import javax.swing.JOptionPane;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageManager.
 */
public class MessageManager
{
	
	/**
	 * Show dialog.
	 *
	 * @param message the message
	 */
	public static void showDialog(String message)
	{
		JOptionPane.showMessageDialog(null, message);
	}
	
	/**
	 * Show error dialog with custom message.
	 *
	 * @param message the message
	 * @param title the title of the dialog
	 */
	public static void showErrorDialog(String message, String title)
	{
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Show error dialog displaying message from the Exception.
	 *
	 * @param ex the exception
	 */
	public static void showErrorDialog(Exception ex)
	{
		JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Prints into console.
	 *
	 * @param obj the object
	 */
	public static void print(Object obj)
	{
		System.out.print(obj);
	}
	
	/**
	 * Prints empty line into console.
	 */
	public static void printLine()
	{
		System.out.println();
	}
	
	/**
	 * Prints line of message into console.
	 *
	 * @param obj the object
	 */
	public static void printLine(Object obj)
	{
		System.out.println(obj);
	}
}

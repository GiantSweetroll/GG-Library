package giantsweetroll;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JComboBox;

// TODO: Auto-generated Javadoc
/**
 * The Class Misc.
 */
public class Misc 
{
	
	/**
	 * Gets the screen size.
	 *
	 * @return the screen size
	 */
	public static Dimension getScreenSize()
	{
		return Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	/**
	 * Gets the selected item in the JComboBox.
	 *
	 * @param combo the JComboBox
	 * @return the item
	 */
	public static Object getItem(JComboBox combo)
	{
		return combo.getSelectedItem();
	}
}

package giantsweetroll;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Enumeration;

import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

// TODO: Auto-generated Javadoc
/**
 * The Class GMisc.
 */
public class GGUtilities 
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
	
	public static void setUIFont(FontUIResource f)
	{
		Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements())
		{
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof FontUIResource)
			{
				UIManager.put(key, f);
			}
		}
	}
	public static void setUIFont(String fontName, int fontType, int fontSize)
	{
		setUIFont(new FontUIResource(fontName, fontType, fontSize));
	}
}

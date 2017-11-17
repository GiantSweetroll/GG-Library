package giantsweetroll.gui.swing;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

// TODO: Auto-generated Javadoc
/**
 * The Class TextAreaManager.
 */
public class TextAreaManager 
{
	
	/**
	 * Auto configure text area with:
	 * 1. Enable/Disable editing
	 * 2. Line Wrap  = true
	 * 3. Set Wrap Style Word = true
	 * 4. Wraps text area with a black line border of size 1
	 *
	 * @param ta the text area
	 * @param enable enable the JTextArea
	 */
	public static void autoConfigureTextArea(JTextArea ta, boolean enable)
	{
		ta.setEditable(enable);
		ta.setLineWrap(true);
		ta.setWrapStyleWord(true);
		ta.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	}
}

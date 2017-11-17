package giantsweetroll.gui.swing;

import java.awt.Component;

import javax.swing.JScrollPane;

// TODO: Auto-generated Javadoc
/**
 * The Class Spm.
 */
public class ScrollPaneManager
{
	
	/**
	 * Generate default scroll pane.
	 *
	 * @param component the component
	 * @return the j scroll pane
	 */
	public static JScrollPane generateDefaultScrollPane(Component component)
	{
		JScrollPane scroll = new JScrollPane (component, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    scroll.setBorder(null);
	    scroll.getViewport().setOpaque(false);
	    scroll.setOpaque(false);
	    
	    return scroll;
	}
	
	/**
	 * Generate a JScrollPane with some features as follows:
	 * 1. Vertical ScrollBar Policy set to as needed
	 * 2. Horizontal ScrollBar Policy set to as needed
	 * 3. null border
	 * 4. Non-opaque
	 * 5. Vertical and horizontal unit increment set as specified
	 *
	 * @param component the component that will use the JScrollPane
	 * @param vInc the vertical increment
	 * @param hInc the horizontal increment
	 * @return the scroll pane
	 */
	public static JScrollPane generateDefaultScrollPane(Component component, int vInc, int hInc)
	{
		JScrollPane scroll = new JScrollPane (component, 
												JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
												JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    scroll.setBorder(null);
	    scroll.getViewport().setOpaque(false);
	    scroll.setOpaque(false);
	    scroll.getVerticalScrollBar().setUnitIncrement(vInc);
	    scroll.getHorizontalScrollBar().setUnitIncrement(hInc);
	    
	    return scroll;
	}
	
	/**
	 * Auto configure the scroll pane with no borders and makes it not opaque.
	 *
	 * @param scroll the scroll pane
	 */
	public static void autoConfigureScrollPane(JScrollPane scroll)
	{
		scroll.setBorder(null);
	    scroll.getViewport().setOpaque(false);
	    scroll.setOpaque(false);
	}
	
	/**
	 * Auto configure scroll pane with no borders, non-opaque, and specified vertical and horizontal increments.
	 *
	 * @param scroll the scroll
	 * @param vInc the vertical increment
	 * @param hInc the horizontal increment
	 */
	public static void autoConfigureScrollPane(JScrollPane scroll, int vInc, int hInc)
	{
		scroll.setBorder(null);
	    scroll.getViewport().setOpaque(false);
	    scroll.setOpaque(false);
	    scroll.getVerticalScrollBar().setUnitIncrement(vInc);
	    scroll.getHorizontalScrollBar().setUnitIncrement(hInc);
	}
}

package giantsweetroll.gui.swing;

import java.awt.GridBagConstraints;

// TODO: Auto-generated Javadoc
/**
 * The Class Gbm.
 */
public class Gbm
{
	
	/**
	 * Set the gridx and gridy to 0.
	 *
	 * @param c the grid bag constraints
	 */
	public static void goToOrigin(GridBagConstraints c)
	{
		c.gridx = 0;
		c.gridy = 0;
	}
	
	/**
	 * Increment gridx by 1.
	 *
	 * @param c the grid bag constraints
	 */
	public static void nextGridColumn(GridBagConstraints c)
	{
		c.gridx++;
	}
	
	/**
	 * Increment gridx by the specified value.
	 *
	 * @param c the grid bag constraints
	 * @param increment the increment
	 */
	public static void nextGridColumn(GridBagConstraints c, int increment)
	{
		c.gridx += increment;
	}
	
	/**
	 * Increment gridy by 1 and set gridx to 0.
	 *
	 * @param c the grid bag constraints
	 */
	public static void newGridLine(GridBagConstraints c)
	{
		c.gridy++;
		c.gridx = 0;
	}
	
	/**
	 * Increment gridy by the specified value (gridx remains the same value)
	 *
	 * @param c the grid bag constraints
	 * @param increment the increment
	 */
	public static void newGridLine(GridBagConstraints c, int increment)
	{
		c.gridy += increment;
	}
	
	/**
	 * Sets gridx and gridy to the specified values
	 *
	 * @param c the grid bag constraints
	 * @param x the x
	 * @param y the y
	 */
	public static void moveToGrid(GridBagConstraints c, int x, int y)
	{
		c.gridx = x;
		c.gridy = y;
	}
}

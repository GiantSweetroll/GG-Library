package giantsweetroll.gui.swing;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class GSPanel extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 857100271107347766L;

	//Constructors
	public GSPanel(LayoutManager layout)
	{
		setLayout(layout);
	}
	public GSPanel(LayoutManager layout, boolean opaque)
	{
		setLayout(layout);
		setOpaque(opaque);
	}
	public GSPanel(LayoutManager layout, Color color)
	{
		setLayout(layout);
		setBackground(color);
	}
}

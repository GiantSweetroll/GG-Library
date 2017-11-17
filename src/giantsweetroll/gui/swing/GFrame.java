package giantsweetroll.gui.swing;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

// TODO: Auto-generated Javadoc
/**
 * The Class GFrame.
 */
public class GFrame extends JFrame
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1998435482406233087L;

	/** The panel below right. */
	//Constants
	public static int PANEL_MAIN = 0,
					  PANEL_CENTER = 1,
					  PANEL_CENTER_CENTER = 2,
					  PANEL_CENTER_LEFT = 3,
					  PANEL_CENTER_RIGHT = 4,
					  PANEL_TOP = 5,
					  PANEL_TOP_CENTER = 6,
					  PANEL_TOP_LEFT = 7,
					  PANEL_TOP_RIGHT = 8,
					  PANEL_BELOW = 9,
					  PANEL_BELOW_CENTER = 10,
					  PANEL_BELOW_LEFT = 11,
					  PANEL_BELOW_RIGHT = 12;
	
	/** The panel main. */
	//JPanels
	private JPanel panelMain;
	
	/** The panel center. */
	private JPanel panelCenter;
	
	/** The panel center center. */
	private JPanel panelCenterCenter;
	
	/** The panel center left. */
	private JPanel panelCenterLeft;
	
	/** The panel center right. */
	private JPanel panelCenterRight;
	
	/** The panel top. */
	private JPanel panelTop;
	
	/** The panel top center. */
	private JPanel panelTopCenter;
	
	/** The panel top left. */
	private JPanel panelTopLeft;
	
	/** The panel top right. */
	private JPanel panelTopRight;
	
	/** The panel below. */
	private JPanel panelBelow;
	
	/** The panel below center. */
	private JPanel panelBelowCenter;
	
	/** The panel below left. */
	private JPanel panelBelowLeft;
	
	/** The panel below right. */
	private JPanel panelBelowRight;
	
	/** The scroll main. */
	//JScrollPanes
	private JScrollPane scrollMain;
	
	/** The scroll center. */
	private JScrollPane scrollCenter;
	
	/** The scroll center center. */
	private JScrollPane scrollCenterCenter;
	
	/** The scroll center left. */
	private JScrollPane scrollCenterLeft;
	
	/** The scroll center right. */
	private JScrollPane scrollCenterRight;
	
	/** The scroll top. */
	private JScrollPane scrollTop;
	
	/** The scroll top center. */
	private JScrollPane scrollTopCenter;
	
	/** The scroll top right. */
	private JScrollPane scrollTopRight;
	
	/** The scroll top left. */
	private JScrollPane scrollTopLeft;
	
	/** The scroll below. */
	private JScrollPane scrollBelow;
	
	/** The scroll below center. */
	private JScrollPane scrollBelowCenter;
	
	/** The scroll below right. */
	private JScrollPane scrollBelowRight;
	
	/** The scroll below left. */
	private JScrollPane scrollBelowLeft;
	
	/** The panels. */
	//ArrayList
	private ArrayList<JPanel> panels;
	
	/**
	 * Instantiates a new g frame.
	 */
	public GFrame()
	{
		
	}
	
	/**
	 * Inits the panel list.
	 */
	//private methods
	private void initPanelList()
	{
		this.panels = new ArrayList<JPanel>();
		
		this.panels.add(this.panelBelow);
		this.panels.add(this.panelBelowCenter);
		this.panels.add(this.panelBelowLeft);
		this.panels.add(this.panelBelowRight);
		this.panels.add(this.panelCenter);
		this.panels.add(this.panelCenterCenter);
		this.panels.add(this.panelCenterLeft);
		this.panels.add(this.panelCenterRight);
		this.panels.add(this.panelMain);
		this.panels.add(this.panelTop);
		this.panels.add(this.panelTopLeft);
		this.panels.add(this.panelTopCenter);
		this.panels.add(this.panelTopRight);
	}
	
	/**
	 * Inits the panel below.
	 */
	private void initPanelBelow()
	{
		//Initialization
		this.panelBelow = new JPanel();
		this.panelBelowCenter = new JPanel();
		this.panelBelowLeft = new JPanel();
		this.panelBelowRight = new JPanel();
	}
	
	/**
	 * Inits the panel top.
	 */
	private void initPanelTop()
	{
		this.panelTop = new JPanel();
		this.panelTopCenter = new JPanel();
		this.panelTopLeft = new JPanel();
		this.panelTopRight = new JPanel();
	}
	
	/**
	 * Inits the panel center.
	 */
	private void initPanelCenter()
	{
		this.panelCenter = new JPanel();
		this.panelCenterCenter = new JPanel();
		this.panelCenterLeft = new JPanel();
		this.panelCenterRight = new JPanel();
	}
	
	/**
	 * Inits the panel main.
	 */
	private void initPanelMain()
	{
		this.panelMain = new JPanel();
	}
	
	/**
	 * Reset panel to defaults.
	 */
	//public methods
	public void resetPanelToDefaults()
	{
		for (int i=0; i<this.panels.size(); i++)
		{
			this.panels.get(i).setOpaque(false);
		}
	}
	
	/**
	 * Gets the panel.
	 *
	 * @param panel the panel
	 * @return the panel
	 */
	//Getters
	public JPanel getPanel(int panel)
	{
		if (panel == GFrame.PANEL_BELOW)
		{
			return this.panelBelow;
		}
		else if (panel == GFrame.PANEL_BELOW_CENTER)
		{
			return this.panelBelowCenter;
		}
		else if (panel == GFrame.PANEL_BELOW_LEFT)
		{
			return this.panelBelowLeft;
		}
		else if (panel == GFrame.PANEL_BELOW_RIGHT)
		{
			return this.panelBelowRight;
		}
		else if (panel == GFrame.PANEL_CENTER)
		{
			return this.panelCenter;
		}
		else if (panel == GFrame.PANEL_CENTER_CENTER)
		{
			return this.panelCenterCenter;
		}
		else if (panel == GFrame.PANEL_CENTER_LEFT)
		{
			return this.panelCenterLeft;
		}
		else if (panel == GFrame.PANEL_CENTER_RIGHT)
		{
			return this.panelCenterRight;
		}
		else if (panel == GFrame.PANEL_MAIN)
		{
			return this.panelMain;
		}
		else if (panel == GFrame.PANEL_TOP)
		{
			return this.panelTop;
		}
		else if (panel == GFrame.PANEL_TOP_CENTER)
		{
			return this.panelTopCenter;
		}
		else if (panel == GFrame.PANEL_TOP_LEFT)
		{
			return this.panelTopLeft;
		}
		else if (panel == GFrame.PANEL_TOP_RIGHT)
		{
			return this.panelTopRight;
		}
		else
		{
			return new JPanel();
		}
	}
}

package giantsweetroll.gui.swing;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -802565984384550643L;
	private BufferedImage image;
	private Dimension dimension;
	
	//Constructors
	public ImagePanel(URL imageUrl, Dimension dimension) throws IOException
	{
		this.image = ImageIO.read(imageUrl);
		this.dimension = dimension;
		this.repaint();
	}
	public ImagePanel(URL imageUrl) throws IOException
	{
		this.image = ImageIO.read(imageUrl);
		this.dimension = new Dimension(this.image.getWidth(), this.image.getHeight());
		this.repaint();
	}
	
	//Overriden Methods
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(image, 0, 0, dimension.width, dimension.height, this);
	}
}

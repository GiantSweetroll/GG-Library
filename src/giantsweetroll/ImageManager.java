package giantsweetroll;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

// TODO: Auto-generated Javadoc
/**
 * The Class ImageManager.
 */
public class ImageManager 
{	
	/**
	 * Gets the image icon from URL with unaltered width and height.
	 *
	 * @param filePath the file url
	 * @return the image icon
	 */
	public static ImageIcon getImageIcon(URL filePath)
	{
		ImageIcon bgimage = new ImageIcon(filePath);
		Image bgimg = bgimage.getImage();
		ImageIcon backgroundImgFinal = new ImageIcon (bgimg);
		
		return backgroundImgFinal;
	}
	
	/**
	 * Gets the image icon from URL scaled with the specified width and height.
	 *
	 * @param filePath the file URL
	 * @param width the width
	 * @param height the height
	 * @return the image icon
	 */
	public static ImageIcon getImageIcon(URL filePath, int width, int height)		//Loads background Image to fill the the screen size
	{
		ImageIcon bgimage = new ImageIcon(filePath);
		Image bgimg = bgimage.getImage();
		Image bgimgNew = bgimg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon backgroundImgFinal = new ImageIcon (bgimgNew);
		
		return backgroundImgFinal;
	}
	
	/**
	 * Gets the image icon from the specified directory with unaltered width and height.
	 *
	 * @param filePath the file path
	 * @return the image icon
	 */
	public static ImageIcon getImageIcon(String filePath)
	{
		ImageIcon bgimage = new ImageIcon(filePath);
		Image bgimg = bgimage.getImage();
		ImageIcon backgroundImgFinal = new ImageIcon (bgimg);
		
		return backgroundImgFinal;
	}
	
	/**
	 * Gets the image icon from the specified directory scaled to the specified width and height.
	 *
	 * @param filePath the file path
	 * @param width the width
	 * @param height the height
	 * @return the image icon
	 */
	public static ImageIcon getImageIcon(String filePath, int width, int height)
	{
		ImageIcon bgimage = new ImageIcon(filePath);
		Image bgimg = bgimage.getImage();
		Image bgimgNew = bgimg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon backgroundImgFinal = new ImageIcon (bgimgNew);
		
		return backgroundImgFinal;
	}
	
	/**
	 * Gets the image from the specified directory with unaltered width and height.
	 *
	 * @param filePath the file path
	 * @return the image
	 */
	public static Image getImage(String filePath)
	{
		ImageIcon bgimage = new ImageIcon(filePath);
		Image bgimg = bgimage.getImage();
	
		return bgimg;
	}
	
	/**
	 * Gets the image from the specified URL with unaltered width and height
	 * 
	 * @param url the URL path
	 * @return the image
	 */
	public static Image getImage(URL url)
	{
		ImageIcon bgimage = new ImageIcon(url);
		Image bgimg = bgimage.getImage();
	
		return bgimg;
	}
	
	/**
	 * Gets the image from the specified directory scaled to the specified width and height.
	 *
	 * @param filePath the file path
	 * @param width the width
	 * @param height the height
	 * @return the image
	 */
	public static Image getImage(String filePath, int width, int height)
	{
		ImageIcon bgimage = new ImageIcon(filePath);
		Image bgimg = bgimage.getImage();
		Image bgimgNew = bgimg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	
		return bgimgNew;
	}
	
	/**
	 * Gets the image from the specified URL scaled to the specified width and height.
	 *
	 * @param filePath the URL path
	 * @param width the width
	 * @param height the height
	 * @return the image
	 */
	public static Image getImage(URL filePath, int width, int height)
	{
		ImageIcon bgimage = new ImageIcon(filePath);
		Image bgimg = bgimage.getImage();
		Image bgimgNew = bgimg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	
		return bgimgNew;
	}
	
	/**
	 * Scales the Image to the specified width and height
	 * 
	 * @param img the image
	 * @param width	the width
	 * @param height the height
	 * @return the scaled image
	 */
	public static Image scaleImage(Image img, int width, int height)
	{
		return img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	}
}

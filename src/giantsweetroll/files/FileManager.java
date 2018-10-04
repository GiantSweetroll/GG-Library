package giantsweetroll.files;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;

// TODO: Auto-generated Javadoc
/**
 * The Class FileManager.
 */
public class FileManager 
{
	
	//Acquired File Format
	public static final int FOLDER_ONLY = 0;
	public static final int FILE_ONLY = 1;
	public static final int BOTH_FOLDER_AND_FILE = 2;
	
	/** The Constant ABSOLUTE_PATH. */
	//Return Format
	public static final int ABSOLUTE_PATH = 3;
	
	/** The Constant SUB_PATH. */
	public static final int SUB_PATH = 4;
	
	/** The Constant NAME_ONLY. */
	public static final int NAME_ONLY = 5;
	
	/**
	 * Import per lines.
	 *
	 * @param file the file
	 * @return the array list
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static ArrayList<Object> importPerLines(File file) throws IOException
	{
		ArrayList<Object> data = new ArrayList<Object>();
		
		Scanner scanner = new Scanner(file);
		
		while (scanner.hasNext())
		{
			data.add(scanner.nextLine());
		}
		
		scanner.close();
		
		return data;
	}

	/**
	 * Import per integer.
	 *
	 * @param file the file
	 * @return the array list
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static ArrayList<Integer> importPerInt(File file) throws IOException
	{
		ArrayList<Integer> data = new ArrayList<Integer>();
		
		Scanner scanner = new Scanner(file);
		
		while (scanner.hasNext())
		{
			data.add(scanner.nextInt());
		}
		
		scanner.close();
		
		return data;
	}
	
	/**
	 * Import per boolean.
	 *
	 * @param file the file
	 * @return the array list
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static ArrayList<Boolean> importPerBool(File file) throws IOException
	{
		ArrayList<Boolean> data = new ArrayList<Boolean>();
		
		Scanner scanner = new Scanner(file);
		
		while (scanner.hasNext())
		{
			data.add(scanner.nextBoolean());
		}
		
		scanner.close();
		
		return data;
	}
	
	/**
	 * Import per big integer.
	 *
	 * @param file the file
	 * @return the array list
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static ArrayList<BigInteger> importPerBigInt(File file) throws IOException
	{
		ArrayList<BigInteger> data = new ArrayList<BigInteger>();
		
		Scanner scanner = new Scanner(file);
		
		while (scanner.hasNext())
		{
			data.add(scanner.nextBigInteger());
		}
		
		scanner.close();
		
		return data;
	}
	
	/**
	 * Import per big dec.
	 *
	 * @param file the file
	 * @return the array list
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static ArrayList<BigDecimal> importPerBigDec(File file) throws IOException
	{
		ArrayList<BigDecimal> data = new ArrayList<BigDecimal>();
		
		Scanner scanner = new Scanner(file);
		
		while (scanner.hasNext())
		{
			data.add(scanner.nextBigDecimal());
		}
		
		scanner.close();
		
		return data;
	}
	
	/**
	 * Import per byte.
	 *
	 * @param file the file
	 * @return the array list
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static ArrayList<Byte> importPerByte(File file) throws IOException
	{
		ArrayList<Byte> data = new ArrayList<Byte>();
		
		Scanner scanner = new Scanner(file);
		
		while (scanner.hasNext())
		{
			data.add(scanner.nextByte());
		}
		
		scanner.close();
		
		return data;
	}
	
	/**
	 * Gets the files in the directory. Folders will not be opened.
	 *
	 * @param directory the directory
	 * @return the files in an array
	 */
	public static void getListOfFiles(List<File> list, String directory)
	{	
		File file = new File(directory);
		File[] files = file.listFiles();
	
		for (File file2 : files)
		{
			list.add(file2);
		}
	}
	
	/**
	 * Gets the files in the directory. Folders will not be opened.
	 *
	 * @param directory the directory
	 * @param openFolders whether to open folders or not
	 * @return the files in an array
	 */
	public static void getListOfFiles(List<File> list, String directory, boolean openFolders)
	{
		if (openFolders)
		{
			File file = new File(directory);
			File[] files = file.listFiles();
			for (File file2 : files)
			{
				if (file2.isDirectory())
				{
					FileManager.getListOfFiles(list, file2.getAbsolutePath(), openFolders);
				}
				else
				{
					list.add(file2);
				}
			}
		}
		else
		{
			FileManager.getListOfFiles(list, directory);
		}
	}

	/**
	 * Gets the names of files in the directory.
	 *
	 * @param list the list to which the list of files is to be listed
	 * @param directory the directory
	 * @param openFolders whether to open folders or not
	 * @param format the imported file format (file or directory/folder or both)
	 * @param returnFormat whether to return just the file names, path, or absolute path
	 * @return the list of files
	 */
	public static void getListOfFiles(List<String> list, 
										String directory, 
										boolean openFolders, 
										int format, 
										int returnFormat)
	{	
		if (openFolders)
		{
			File folder = new File(directory);
			File[] listOfFiles = folder.listFiles();
			
			for (File fileEntry : listOfFiles) 
		    {
		        if (fileEntry.isDirectory())
		        {
		           getListOfFiles(list, fileEntry.getAbsolutePath(), true, format, returnFormat);
		        } 
		        else
		        {
		        	if (returnFormat == FileManager.NAME_ONLY)
		        	{
		        		list.add(fileEntry.getName());
		        	}
		        	else if (returnFormat == FileManager.ABSOLUTE_PATH)
		        	{
		        		list.add(fileEntry.getAbsolutePath());
		        	}
		        	else if (returnFormat == FileManager.SUB_PATH)
		        	{
		        		list.add(fileEntry.getPath());
		        	}
		        }
		    }
		}
		else
		{
			File folder = new File(directory);
			File[] listOfFiles = folder.listFiles();

			for (File file : listOfFiles) 
			{
				if (format == FileManager.FILE_ONLY)
				{
					if (file.isFile()) 
				    {
						if (returnFormat == FileManager.NAME_ONLY)
			        	{
			        		list.add(file.getName());
			        	}
			        	else if (returnFormat == FileManager.ABSOLUTE_PATH)
			        	{
			        		list.add(file.getAbsolutePath());
			        	}
			        	else if (returnFormat == FileManager.SUB_PATH)
			        	{
			        		list.add(file.getPath());
			        	}
				    }
				}
				else if (format == FileManager.FOLDER_ONLY)
				{
					if (file.isDirectory())
					{
						if (returnFormat == FileManager.NAME_ONLY)
			        	{
			        		list.add(file.getName());
			        	}
			        	else if (returnFormat == FileManager.ABSOLUTE_PATH)
			        	{
			        		list.add(file.getAbsolutePath());
			        	}
			        	else if (returnFormat == FileManager.SUB_PATH)
			        	{
			        		list.add(file.getPath());
			        	}
					}
				}
				else if (format == FileManager.BOTH_FOLDER_AND_FILE)
				{
					if (returnFormat == FileManager.NAME_ONLY)
		        	{
		        		list.add(file.getName());
		        	}
		        	else if (returnFormat == FileManager.ABSOLUTE_PATH)
		        	{
		        		list.add(file.getAbsolutePath());
		        	}
		        	else if (returnFormat == FileManager.SUB_PATH)
		        	{
		        		list.add(file.getPath());
		        	}
				}
			}
		}
	}
	
	/**
	 * Gets the list of files in the directory (depecrated).
	 *
	 * @param list the list
	 * @param directory the directory
	 * @param openFolders whether to open files or not
	 * @return the list of files
	 */ /*
	@Deprecated
	public static void getListOfFiles(List<String> list, String directory, boolean openFolders)
	{	
		if (openFolders)
		{
			File folder = new File(directory);
			File[] listOfFiles = folder.listFiles();
			
			for (File fileEntry : listOfFiles) 
		    {
		        if (fileEntry.isDirectory())
		        {
		           getListOfFiles(list, fileEntry.getAbsolutePath(), true);
		        } 
		        else
		        {
		        	list.add(fileEntry.getName());
		        }
		    }
		}
		else
		{
			File folder = new File(directory);
			File[] listOfFiles = folder.listFiles();

			for (File file : listOfFiles) 
			{
				list.add(file.getName());
			}
		}
	}		*/
	
	/**
	 * Save image.
	 *
	 * @param image the image
	 * @param outputPath the output path
	 * @param fileFormat the file format
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void saveImage(BufferedImage image, String outputPath, String fileFormat) throws IOException
	{
		File outputFile = new File(outputPath);
		if (!outputFile.exists())
		{
			outputFile.mkdirs();
			outputFile.createNewFile();
		}
		ImageIO.write(image, fileFormat, outputFile);
	}
}

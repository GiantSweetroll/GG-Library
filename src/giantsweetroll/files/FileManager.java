package giantsweetroll.files;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.imageio.ImageIO;

import giantsweetroll.comparators.FileComparator;

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
	public static void getListOfFiles(Collection<File> list, String directory)
	{	
		File file = new File(directory);
		File[] files = file.listFiles();
		Arrays.sort(files, new FileComparator());
	
		for (File file2 : files)
		{
			list.add(file2);
		}
	}
	
	/**
	 * Gets the files in the directory. Folders will not be opened.
	 *
	 * @param directory the directory
	 * @return the files in an array
	 */
	public static void getListOfFiles(Set<File> list, String directory)
	{	
		File file = new File(directory);
		File[] files = file.listFiles();
		Arrays.sort(files, new FileComparator());
	
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
	public static void getListOfFiles(Collection<File> list, String directory, boolean openFolders)
	{
		if (openFolders)
		{
			File file = new File(directory);
			File[] files = file.listFiles();
			Arrays.sort(files, new FileComparator());
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
	public static void getListOfFiles(Collection<String> list, 
										String directory, 
										boolean openFolders, 
										int format, 
										int returnFormat)
	{	
		if (openFolders)
		{
			File folder = new File(directory);
			File[] listOfFiles = folder.listFiles();
			
			Arrays.sort(listOfFiles, new FileComparator());
			
			for (File fileEntry : listOfFiles) 
		    {
		        if (fileEntry.isDirectory())
		        {
		           getListOfFiles(list, fileEntry.getAbsolutePath(), true, format, returnFormat);
		        } 
		        else
		        {
		        	checkStateAndAddToList(list, fileEntry, returnFormat);
		        }
		    }
		}
		else
		{
			File folder = new File(directory);
			File[] listOfFiles = folder.listFiles();
			
			Arrays.sort(listOfFiles, new FileComparator());

			for (File file : listOfFiles) 
			{
				if (format == FileManager.FILE_ONLY)
				{
					if (file.isFile()) 
				    {
						checkStateAndAddToList(list, file, returnFormat);
				    }
				}
				else if (format == FileManager.FOLDER_ONLY)
				{
					if (file.isDirectory())
					{
						checkStateAndAddToList(list, file, returnFormat);
					}
				}
				else if (format == FileManager.BOTH_FOLDER_AND_FILE)
				{
					checkStateAndAddToList(list, file, returnFormat);
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
	
	public static void zip(String fileToZip, String targetZipLocation) throws IOException
	{
		FileOutputStream fos = new FileOutputStream(targetZipLocation);
		ZipOutputStream zos = new ZipOutputStream(fos);
		
		File file = new File(fileToZip);
		if (file.isFile())
		{
			zipFile(file, "", zos);
		}
		else if (file.isDirectory())
		{
			zipFolder(zos, file, "");
		}
		
		zos.close();
	}
	
	public static void zipFolder(ZipOutputStream zos, File folderToZip, String parentName) throws IOException
	{
		String myName = parentName + folderToZip.getName() + File.separator;
		
		ZipEntry zipEntry = new ZipEntry(myName);
		zos.putNextEntry(zipEntry);
		
		File[] contents = folderToZip.listFiles();
		
		try
		{
			for (File f : contents)
			{
				if (f.isFile())
				{
					zipFile(f, myName, zos);
				}
				else
				{
					zipFolder(zos, f, myName);
				}
			}
		}
		catch(NullPointerException ex){}
		
		zos.closeEntry();
	}
	
	public static void zipFile(File fileToZip, String parentName, ZipOutputStream zos) throws IOException
	{
		ZipEntry zipEntry = new ZipEntry(parentName + fileToZip.getName());
		zos.putNextEntry(zipEntry);
		
		FileInputStream fis = new FileInputStream(fileToZip);
		byte[] buffer = new byte[1024];
		int bytesRead;
		
		while ((bytesRead = fis.read(buffer)) > 0)
		{
			zos.write(buffer, 0, bytesRead);
		}
		
		fis.close();
		zos.closeEntry();
	}
	
	//Private Methods
	private static void checkStateAndAddToList(Collection<String> list, File file, int returnFormat)
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

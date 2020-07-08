package giantsweetroll.comparators;

import java.io.File;
import java.util.Comparator;

public class FileComparator implements Comparator<File>
{

	@Override
	public int compare(File f1, File f2) 
	{
		String s1 = f1.getName();
		String s2 = f2.getName();
		
		return s1.compareTo(s2);
	}
}

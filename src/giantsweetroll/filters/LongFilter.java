package giantsweetroll.filters;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

public class LongFilter  extends DocumentFilter
{
	private long min, max;
	
	public LongFilter(long min, long max)
	{
		this.min = min;
		this.max = max;
	}
	 
	 	private boolean lessThanMin(long num)
	 	{
	 		return num<min;
	 	}
	 	private boolean moreThanMax(long num)
	 	{
	 		return num>max;
	 	}
	 
	   private boolean isLong(String text) {
	      try {
	         Long.parseLong(text);
	         return true;
	      } catch (NumberFormatException e) {
	         return false;
	      }
	   }

	   //Overridden Methods
	   @Override
	   public void insertString(FilterBypass fb, int offset, String string,
	         AttributeSet attr) throws BadLocationException {

	      Document doc = fb.getDocument();
	      StringBuilder sb = new StringBuilder();
	      sb.append(doc.getText(0, doc.getLength()));
	      sb.insert(offset, string);

	      if (isLong(sb.toString())){
	         if (this.lessThanMin(Long.parseLong(string)))
	         {
	        	 string = Long.toString(min);
	         }
	         else if (this.moreThanMax(Long.parseLong(string)))
	         {
	        	 string = Long.toString(max);
	         }
	         super.insertString(fb, offset, string, attr);
	      } else {
	         // warn the user and don't allow the insert
	      }
	   }
	   @Override
	   public void replace(FilterBypass fb, int offset, int length, String text,
	         AttributeSet attrs) throws BadLocationException {

	      Document doc = fb.getDocument();
	      StringBuilder sb = new StringBuilder();
	      sb.append(doc.getText(0, doc.getLength()));
	      sb.replace(offset, offset + length, text);

	      if (isLong(sb.toString())) 
	      {
		         if (this.lessThanMin(Long.parseLong(text)))
		         {
		        	 text = Long.toString(min);
		         }
		         else if (this.moreThanMax(Long.parseLong(text)))
		         {
		        	 text = Long.toString(max);
		         }
	         super.replace(fb, offset, length, text, attrs);
	          
	      } else {
	         // warn the user and don't allow the insert
	      }

	   }

	   @Override
	   public void remove(FilterBypass fb, int offset, int length)
	         throws BadLocationException {
	      Document doc = fb.getDocument();
	      StringBuilder sb = new StringBuilder();
	      sb.append(doc.getText(0, doc.getLength()));
	      sb.delete(offset, offset + length);

	      if (isLong(sb.toString())) {
	         super.remove(fb, offset, length);
	      }
	      else if (sb.toString().equals(""))
	      {
	    	  super.remove(fb, offset, length);
	      }
	      else {
	         // warn the user and don't allow the insert
	      }

	   }
}


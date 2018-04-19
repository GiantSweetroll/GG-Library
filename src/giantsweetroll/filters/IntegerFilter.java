package giantsweetroll.filters;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

public class IntegerFilter extends DocumentFilter
{
	private int min, max;
	
	public IntegerFilter(int min, int max)
	{
		this.min = min;
		this.max = max;
	}
	 
	 	private boolean lessThanMin(int num)
	 	{
	 		return num<min;
	 	}
	 	private boolean moreThanMax(int num)
	 	{
	 		return num>max;
	 	}
	 
	   private boolean isInteger(String text) {
	      try {
	         Integer.parseInt(text);
	         return true;
	      } catch (NumberFormatException e) {
	         return false;
	      }
	   }

	   //Overriden Methods
	   @Override
	   public void insertString(FilterBypass fb, int offset, String string,
	         AttributeSet attr) throws BadLocationException {

	      Document doc = fb.getDocument();
	      StringBuilder sb = new StringBuilder();
	      sb.append(doc.getText(0, doc.getLength()));
	      sb.insert(offset, string);

	      if (isInteger(sb.toString())){
	         if (this.lessThanMin(Integer.parseInt(string)))
	         {
	        	 string = Integer.toString(min);
	         }
	         else if (this.moreThanMax(Integer.parseInt(string)))
	         {
	        	 string = Integer.toString(max);
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

	      if (isInteger(sb.toString())) 
	      {
		         if (this.lessThanMin(Integer.parseInt(text)))
		         {
		        	 text = Integer.toString(min);
		         }
		         else if (this.moreThanMax(Integer.parseInt(text)))
		         {
		        	 text = Integer.toString(max);
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

	      if (isInteger(sb.toString())) {
	         super.remove(fb, offset, length);
	      } else {
	         // warn the user and don't allow the insert
	      }

	   }
}

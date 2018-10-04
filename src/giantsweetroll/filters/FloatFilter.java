package giantsweetroll.filters;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

public class FloatFilter extends DocumentFilter
{
	private float min, max;
	
	public FloatFilter(float min, float max)
	{
		this.min = min;
		this.max = max;
	}
	 
	 	private boolean lessThanMin(float num)
	 	{
	 		return num<min;
	 	}
	 	private boolean moreThanMax(float num)
	 	{
	 		return num>max;
	 	}
	 
	   private boolean isFloat(String text) {
	      try {
	         Float.parseFloat(text);
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

	      if (isFloat(sb.toString()))
	      {
	    	  try
	    	  {
	    		  if (this.lessThanMin(Float.parseFloat(string)))
	 	         {
	 	        	 string = Float.toString(min);
	 	         }
	 	         else if (this.moreThanMax(Float.parseFloat(string)))
	 	         {
	 	        	 string = Float.toString(max);
	 	         }
	    	  }
	    	  catch(NumberFormatException ex) {}
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

	      if (isFloat(sb.toString())) 
	      {
	    	  try
	    	  {
	    		  if (this.lessThanMin(Float.parseFloat(text)))
			         {
			        	 text = Float.toString(min);
			         }
			         else if (this.moreThanMax(Float.parseFloat(text)))
			         {
			        	 text = Float.toString(max);
			         }
	    	  }
	    	  catch(NumberFormatException ex) {}
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

	      if (isFloat(sb.toString())) {
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

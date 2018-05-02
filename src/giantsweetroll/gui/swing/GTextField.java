package giantsweetroll.gui.swing;

import javax.swing.JTextField;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class GTextField extends JTextField
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4644339339945431340L;

	//Constructors
	public GTextField()
	{
		super();
	}
	public GTextField(String txt)
	{
		super(txt);
	}
	public GTextField(String txt, int columns)
	{
		super(txt, columns);
	}
	public GTextField(DocumentFilter df)
	{
		super();
		((PlainDocument)this.getDocument()).setDocumentFilter(df);
	}
	public GTextField(String txt, DocumentFilter df)
	{
		super(txt);
		((PlainDocument)this.getDocument()).setDocumentFilter(df);
	}
	public GTextField(String txt, int columns, DocumentFilter df)
	{
		super(txt, columns);
		((PlainDocument)this.getDocument()).setDocumentFilter(df);
	}
}

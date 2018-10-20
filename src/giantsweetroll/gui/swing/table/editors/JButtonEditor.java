package giantsweetroll.gui.swing.table.editors;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

public abstract class JButtonEditor extends DefaultCellEditor
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4125956220726416516L;
	protected JButton button;
	private String label;
	private boolean clicked;
	
	public JButtonEditor()
	{
		super(new JTextField());
		
		button = new JButton();
		button.setOpaque(true);
		
		//When button is clicked
		button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						fireEditingStopped();
					}
				});
	}
	
	//Public Methods
	public void setButtonClicked(boolean clicked)
	{
		this.clicked = clicked;
	}
	public boolean buttonIsClicked()
	{
		return this.clicked;
	}
	
	//Overridden Methods
	@Override
	public Component getTableCellEditorComponent(JTable table, Object obj, boolean isSelected, int row, int column) 
	{
		this.label = (obj == null)? "" : obj.toString();
		this.button.setText(label);
		this.setButtonClicked(true);
		
		return button;
	}
	
	@Override
	public Object getCellEditorValue() 
	{
		if (this.buttonIsClicked())
		{
			this.clickedAction();
		}
		this.setButtonClicked(false);
		return new String(label);
	}
	
	@Override
	public boolean stopCellEditing() 
	{
		this.clicked = false;
		return super.stopCellEditing();
	}
	
	@Override
	protected void fireEditingStopped() 
	{
		super.fireEditingStopped();
	}
	
	//Abstract Methods
	public abstract void clickedAction();
}

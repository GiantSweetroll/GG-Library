package giantsweetroll.gui.swing.table.renderers;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class JButtonRenderer extends JButton implements TableCellRenderer
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2457230486120594944L;

	public JButtonRenderer()
	{
		this.setOpaque(true);
	}

	//Overridden Methods
	@Override
	public Component getTableCellRendererComponent(JTable table, Object obj, boolean selected, boolean focused, int row,
			int column)
	{
		if (obj == null)
		{
			this.setText("");
		}
		else
		{
			this.setText(obj.toString());
		}
		
		return this;
	}
}

package giantsweetroll.gui.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

// TODO: Auto-generated Javadoc
/**
 * The Class TableManager.
 */
public class TableManager 
{
	
	/**
	 * Resize column width both.
	 *
	 * @param table the table
	 */
	public static void resizeColumnWidthBoth(JTable table)
	{
		 int width1 = 0;
		 DefaultTableColumnModel colModel = (DefaultTableColumnModel) table.getColumnModel();
		 TableColumn col = colModel.getColumn(1);
		 
		 for (int c=0; c<table.getColumnCount(); c++)		//Cell component alignment
		 {
			 DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			 if (table.getColumnModel().getColumn(c)==table.getColumnModel().getColumn(0))	//if its the first column (0, not 1)
			 {
				 centerRenderer.setHorizontalAlignment(SwingConstants.LEFT);	//Aligns it LEFT
			 }
			 else
			 {
				 centerRenderer.setHorizontalAlignment(SwingConstants.CENTER); 	//ALigns it CENTER
			 }
		     table.getColumnModel().getColumn(c).setCellRenderer(centerRenderer);
		 }
		
		for(int i=0;i<table.getColumnCount();i++)
		{
		      col = colModel.getColumn(i);

		      TableCellRenderer renderer = col.getHeaderRenderer();
		      if (renderer == null) 
		      {
		        renderer = table.getTableHeader().getDefaultRenderer();
		      }
		      Component comp = renderer.getTableCellRendererComponent(table, col.getHeaderValue(), false, false, 0, 0);
		      width1 = comp.getPreferredSize().width;
		         
		      col.setPreferredWidth(width1+2);
		}
		
		final int margin = 1;
		int width2 = 15; // Min width
	    final TableColumnModel columnModel = table.getColumnModel();
	    for (int column = 0; column < table.getColumnCount(); column++) 
	    {
	        for (int row = 0; row < table.getRowCount(); row++) 
	        {
	            TableCellRenderer renderer = table.getCellRenderer(row, column);
	            Component comp = table.prepareRenderer(renderer, row, column);
	            width2 = Math.max(comp.getPreferredSize().width + margin, width2);
	        }
	        columnModel.getColumn(column).setPreferredWidth(width2);
	    }
	    
	    if (width1+2>width2)
	    {
	    	for(int i=0;i<table.getColumnCount();i++)
			{      
	    		col = colModel.getColumn(i);
	    		col.setPreferredWidth(width1+2);
			}
	    }
	    else if (width2>width1+2)
	    {
	    	for(int i=0;i<table.getColumnCount();i++)
			{      
	    		col = colModel.getColumn(i);
	    		col.setPreferredWidth(width1+2);
			}
	    }
	    else if (width1+2==width2)
	    {
	    	for(int i=0;i<table.getColumnCount();i++)
			{      
	    		col = colModel.getColumn(i);
	    		col.setPreferredWidth(width1+2);
			}
	    }
	}

	/**
	 * Auto configure J table.
	 *
	 * @param table the table
	 * @param dataCount the data count
	 * @param automaticResizeColumnWidth the automatic resize column width
	 * @param fontName the font name
	 * @param fontType the font type
	 * @param fontSize the font size
	 * @param enable the enable
	 * @param headerColor the header color
	 * @param opaque the opaque
	 * @param borderScroll the border scroll
	 * @return the j scroll pane
	 */
	public static JScrollPane autoConfigureJTable(JTable table, int dataCount, boolean automaticResizeColumnWidth, String fontName, int fontType, int fontSize, boolean enable, Color headerColor, boolean opaque, Border borderScroll)
	{
		//Set JTable height
		int tableHeight = 0;
		for (int row = 0; row < dataCount; row++)
		{
			tableHeight += table.getRowHeight(row);
		}
		//table properties
		table.getTableHeader().setFont(new Font (fontName, fontType, fontSize));
		table.setAutoCreateColumnsFromModel(true);
		table.setEnabled(enable);			//Disallow editing of table directly
		table.getTableHeader().setBackground(headerColor);		//sets color of the table headers
		table.setPreferredScrollableViewportSize(new Dimension(table.getPreferredScrollableViewportSize().width, tableHeight));	//Makes the scrollbars stick to the end of the table, instead of the panel
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		if (automaticResizeColumnWidth)
		{
			resizeColumnWidthBoth(table);
		}
		table.setAutoCreateRowSorter(true);
		
		JScrollPane scroll = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setOpaque(opaque);
		scroll.getViewport().setOpaque(opaque);
		scroll.setBorder(borderScroll);
		
		return scroll;
	}
}

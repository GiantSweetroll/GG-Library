package giantsweetroll.date;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import giantsweetroll.gui.swing.Gbm;

public class DateSelectionPanel extends JPanel implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4573262763411489584L;
	private JComboBox<String> comboDay, comboMonth, comboYear;
	private JButton butAuto, butDefault;
	private GridBagConstraints c;
	private Date defaultDate;
	
	//Constants
	private final String AUTO = "auto";
	private final String DEFAULT = "default";
	
	//Conditional
	private boolean enable;
	
	//Constructor
	public DateSelectionPanel(boolean enabled, String autoText, String defaultText, String autoToolTip, String defaultToolTip)
	{
		this.enable = enabled;
		this.init(autoText, defaultText, autoToolTip, defaultToolTip);
		this.enableComponents(enabled);
	}
	
	//Methods
	public void enableComponents(boolean enable)
	{
		this.comboMonth.setEnabled(enable);
		this.comboYear.setEnabled(enable);
		this.comboDay.setEnabled(enable);
		this.butAuto.setEnabled(enable);
		this.butDefault.setEnabled(enable);
	}
	private final void init(String autoText, String defaultText, String autoToolTip, String defaultToolTip)
	{
		//Initialization
		this.comboYear = new JComboBox<String>(DateManager.getYearRangeStringReversed());
	//	this.comboYear = new JComboBox<String>(DateManager.getYearRangeString());
		this.comboMonth = new JComboBox<String>(DateManager.getMonthNameList().toArray(new String[12]));
		this.comboDay = new JComboBox<String>(DateManager.getMaxDaysString(Byte.parseByte(Integer.toString(this.comboMonth.getSelectedIndex()+1)), Short.parseShort(this.comboYear.getSelectedItem().toString())));
		this.butAuto = new JButton(autoText);
		this.butDefault = new JButton(defaultText);
		this.c = new GridBagConstraints();
		this.defaultDate = new Date();
		
		//Properties
		this.setLayout(new GridBagLayout());
		this.setOpaque(false);
		this.comboYear.addActionListener(this.yearListener);
		this.comboMonth.addActionListener(this.monthListener);
		this.comboDay.setEnabled(this.enable);
		this.butAuto.addActionListener(this);
		this.butAuto.setActionCommand(this.AUTO);
		this.butAuto.setToolTipText(autoToolTip);
		this.butDefault.addActionListener(this);
		this.butDefault.setActionCommand(this.DEFAULT);
		this.butDefault.setToolTipText(defaultToolTip);
		this.comboDay.setBackground(Color.WHITE);
		this.comboMonth.setBackground(Color.WHITE);
		this.comboYear.setBackground(Color.WHITE);
		this.setAsDefaultDataThis();
		
		//Add to panel
		Gbm.goToOrigin(c);
		c.insets = new Insets(5, 5, 5, 5);
	//	this.vecDay = new VectorInt(c.gridx, c.gridy);
		this.add(this.comboDay, c);							//Day
		Gbm.nextGridColumn(c);
		this.add(this.comboMonth, c);						//Month
		Gbm.nextGridColumn(c);
		this.add(this.comboYear, c);						//Year
		Gbm.nextGridColumn(c);
		this.add(this.butDefault, c);
		Gbm.nextGridColumn(c);
		this.add(this.butAuto, c);							//Auto Button
	}
	
	private void refreshDayRange()
	{	
		int index = -1;
		try
		{
			index = this.comboDay.getSelectedIndex();
		}
		catch(NullPointerException ex) {}
		this.comboDay.setModel(new DefaultComboBoxModel<String>(DateManager.getMaxDaysString(Byte.parseByte(Integer.toString(this.comboMonth.getSelectedIndex()+1)), 
																				Short.parseShort(this.comboYear.getSelectedItem().toString()))));
		int size = this.comboDay.getModel().getSize();
		if (index < 0)
		{
			this.comboDay.setSelectedIndex(0);			//First index
		}
		else if (index <= size-1)
		{
			this.comboDay.setSelectedIndex(index);
		}
		else
		{
			this.comboDay.setSelectedIndex(size-1);		//Last index
		}
		
		this.revalidate();
		this.repaint();
	}
	
	public void setDate(Date date)
	{
		this.comboYear.setSelectedItem(Integer.toString(date.getYear()));
		this.comboMonth.setSelectedIndex(date.getMonth()-1);
		this.comboDay.setSelectedIndex(date.getDay()-1);
	}
	
	public String getDay()
	{
		return this.comboDay.getSelectedItem().toString();
	}
	public String getMonth()			//As String
	{
		return this.comboMonth.getSelectedItem().toString();
	}
	public int getMonthValue()			//In value form
	{
		return this.comboMonth.getSelectedIndex() + 1;
	}
	public String getYear()
	{
		return this.comboYear.getSelectedItem().toString();
	}
	
	public void setAsDefaultDataThis()
	{
		this.setDefaultDate(new Date(Integer.parseInt(this.getDay()), this.getMonthValue(), Integer.parseInt(this.getYear())));
	}
	
	public void setDefaultDate(Date date)
	{
		this.defaultDate = date;
	}
	
	public void resetDefault()
	{
		try
		{
			this.setDate(this.defaultDate);
		}
		catch(NullPointerException ex){ex.printStackTrace();}
	}
	
	public void autoSetDate()
	{
		this.setDate(new Date());
	}
	
	public boolean sameAsDefault()
	{
		Date date = this.getDate();
		if (this.defaultDate.getYear() == date.getYear() && 
				this.defaultDate.getMonth() == date.getMonth() && 
				this.defaultDate.getDay() == date.getDay())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String getDateAsString()
	{
		return this.getDay() + "/" + this.getMonthValue() + "/" + this.getYear();
	}
	
	public Date getDate()
	{
		return new Date(Integer.parseInt(this.getDay()), this.getMonthValue(), Integer.parseInt(this.getYear()));
	}
	
	//Overriden Methods
	@Override
	public void setEnabled(boolean enable)
	{
		super.setEnabled(enable);
		
		this.comboDay.setEnabled(enable);
		this.comboMonth.setEnabled(enable);
		this.comboYear.setEnabled(enable);
		this.butAuto.setEnabled(enable);
		this.butDefault.setEnabled(enable);
	}
	
	//Interfaces
	private ActionListener yearListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				refreshDayRange();
			}
		};
			
	private ActionListener monthListener = new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			refreshDayRange();
		}
	};

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch(e.getActionCommand())
		{
			case AUTO:
				this.autoSetDate();
				break;
				
			case DEFAULT:
				this.resetDefault();
				break;
		}
	}
}

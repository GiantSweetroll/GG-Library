package giantsweetroll.message;

public class GLogManager
{
	private boolean enableLogging;
	
	public GLogManager(boolean enableLogging)
	{
		this.enableLogging = enableLogging;
	}
	
	public void print(Object obj)
	{
		if (this.isEnabled())
		{
			System.out.print(obj);
		}
	}
	
	public void printLine(Object obj)
	{
		if (this.isEnabled())
		{
			System.out.println(obj);
		}
	}

	//Setter
	public void setEnabled(boolean enable)
	{
		this.enableLogging = enable;
	}
	
	//Getter
	public boolean isEnabled()
	{
		return this.enableLogging;
	}
}

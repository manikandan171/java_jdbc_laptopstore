package manikandan.laptop.com;

public class usererror extends Exception
{
	usererror(String msg)
	{
		super(msg);
	}
	void display()
	{
		System.out.println("User name does Not created");
	}
	
}

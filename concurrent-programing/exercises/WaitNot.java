import java.util.*;
class Tl extends Thread
{
	int i=0;
	Tll t2;

	public Tl(Tll t2)
	{
		this.t2=t2;
	}

	public void run()
	{
		while(i<10000)
		{
			synchronized(t2)
			{
				if(i==2000)
				{
					t2.suspended = true;
				}
				if(i==6000)
				{
					t2.suspended = false;
					t2.notify();
				}
			}
			i++;
			try
			{
				Thread.sleep((int).Math.random()*100);
			}
			catch (InterruptedException e)
			{
				System.out.println(e);
			}
		}
	}
}

class Tll extends Thread
{
	public boolean suspended = false;

	public void run()
	{
		while(true)
		{
			synchronized(this)
			{
				while(suspended)
				{
					try
					{
						this.wait();
					}
					catch (InterruptedException e)
					{
						System.out.println(e);	
					}
				}
				System.out.println("t2 printing. Suspended=" + suspended);
			}
		
			try
			{
				Thread.sleep((int).Math.random()*100);
			}
			catch (InterruptedException e)
			{
				System.out.println(e);
			}
		}
	}
}

public class WaitNot
{
	public static void main(String[] args)
	{
		Object lock = new Object();

		Tll t2 = new Tll();
		Tl t1 = new Tl(t2);

		try
		{
			t1.start();
			t2.start();
		}
		catch (InterruptedException e) 
		{
			System.out.println(e);	
		}		
	}	
}
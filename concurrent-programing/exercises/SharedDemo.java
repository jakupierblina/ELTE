class Shared
{
	public static int count = 0;
	//we can access the public static variables even though they are not initialzated
}

abstract class Effector extends Thread 
{
	Effector(String name)
	{
		super(name);
	}
}

class Increment extends Effector
{
	Increment(String name)
	{
		super(name);

	}

	public void run ()
	{
		try 
		{
			for (int i=0; i<10; i++)
			{
				Shared.count++;
				Thread.sleep(20); 
				
			}
			System.out.println(getName() + " " + Shared.count);
		}
		catch (InterruptedException ex)
		{
			System.out.println(ex);
		}
		
	}
}

class Decrement extends Effector
{
	Decrement(String name)
	{
		super(name);

	}

	public void run ()
	{
		try 
		{
			for (int i=0; i<10; i++)
			{
				Shared.count--;
				Thread.sleep(20); 
				
			}
			//System.out.println(Shared.count);
			System.out.println(getName() + " " + Shared.count);
		}
		catch (InterruptedException ex)
		{
			System.out.println(ex);
		}
		
	}
}


public class SharedDemo 
{
	public static void main (String [] args) throws InterruptedException
	{
		Thread t1 = new Increment("Increment");
		Thread t2 = new Decrement("Decrement");

		t1.start();
		t2.start();
	
		t1.join();
		t2.join();

		System.out.println("Finished. Shared value " + Shared.count);

	}
}
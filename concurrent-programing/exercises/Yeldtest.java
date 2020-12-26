class CostumThread extends Thread 
{
	public CostumThread (String name)
	{
		//this.name=name;
		super(name);
	}

	public void run()
	{
		for(int i=0; i<10; i++)
		{
			System.out.println(getName()); //printing the thread name
		}
	}
}

public class Yeldtest
{
	public static void main(String[] args)
	{
		Thread t1 = new CostumThread("C1");
		//t1.setPriority(Thread.MAX_PRIORITY);
		t1.start();

		Thread t2 = new CostumThread("C2");
		//t2.setPriority(Thread.MAX_PRIORITY);
		t2.start();

		try 
		{
			t1.join();
		}
		catch(InterruptedException ex)
		{
			return;
		}



		for(int i=0; i<10; i++)
		{
			System.out.println(Thread.currentThread().getName());
		}
	}


}
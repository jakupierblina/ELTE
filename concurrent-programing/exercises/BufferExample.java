/*
	Server side synchronization
*/

class BounderBuffer
{
	private final Object[] items = new Object[100];
	private int cnt;
	private int put,take;

	public synchronized Object take() throws InterruptedException
	{
		while(cnt==0)
		{
			System.out.println("Empty buffer");
			wait();
		}

		Object tmp = items[take];
		take++;

		if(take==items.length){
			take=0;
		}

		cnt--;
		notify();
		return tmp;
	}

	public synchronized void put(Object ob) throws InterruptedException
	{
		while(cnt == items.length)
		{
			System.out.println("Full buffer");
			wait();
		}
		items[put] = ob;
		put++;

		if(put == items.length)
		{
			put=0;
		}

		cnt++;
		notify();
	}
}

class Producer extends Thread
{
	private BounderBuffer bb;
	public Producer(BounderBuffer bb)
	{
		this.bb=bb;
	}

	public void run()
	{
		int i=0;
		while(i<200)
		{
			synchronized(bb)
			{
				try
				{
					bb.put("Car");
					System.out.println("elem "+i+" added");
					i++;

				}
				catch (InterruptedException e) 
				{
					System.out.println(e);	
				}
			}
			try
			{
				Thread.sleep( (int)Math.random()*100 );
			}
			catch (InterruptedException e) 
			{
				System.out.println(e);	
			}

		}
	}
}


class Consumer extends Thread
{
	private BounderBuffer bb;
	public Consumer(BounderBuffer bb)
	{
		this.bb=bb;
	}

	public void run()
	{
		int i=0;
		while(i<200)
		{
			synchronized(bb)
			{
				try
				{
					
					System.out.println("elem "+bb.take()+" at position" +i+ "taken");
					i++;

				}
				catch (InterruptedException e) 
				{
					System.out.println(e);	
				}
			}
			try
			{
				Thread.sleep( (int)Math.random()*100 );
			}
			catch (InterruptedException e) 
			{
				System.out.println(e);	
			}

		}
	}
}

public class BufferExample
{
	public static void main(String[] args)
	{
		BounderBuffer buff = new BounderBuffer();
		Producer prod = new Producer(buff);
		Consumer con = new Consumer(buff);

		prod.start();
		con.start();
	}
}
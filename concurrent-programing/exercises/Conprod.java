/*
	This is always the producer starting first because of the Semaphore.
	The idea of the code is the assuarance of the buffer which is used for the reading and the wiriting 
	deadlock waiting and jumpiing from one thread to another
*/

import java.util.concurrent.Semaphore;

class SharedBuffer 
{
	int cnt =0;
	Semaphore sem = new Semaphore(0);
	Semaphore cem = new Semaphore(1);


	public void put(int i)
	{
		try 
		{
			cem.acquire(); // producer semaphore taken
			//sem.release();
		}
		catch(InterruptedException ex)
		{
			System.out.println(ex);
		}
		cnt = i;
		sem.release(); //costumer released
		System.out.println(Thread.currentThread().getName()+ " putting: " + i);

	}

	public int get()
	{
		int aux=0;
		try 
		{
			sem.acquire(); // costumer semaphore taken
			aux = cnt;
			//sem.release();
		}
		catch(InterruptedException ex)
		{
			System.out.println(ex);
		}
		//cem = i;
		System.out.println(Thread.currentThread().getName()+ " putting: " + aux);
		cem.release(); //producer released
		return aux;
	}
}

class Produer implements Runnable
{
	SharedBuffer s;

	public Produer (SharedBuffer s)
	{
		this.s=s;
	}

	public void run()
	{
		for(int i=0; i<5; i++)
		{
			s.put(i);
		}
	}
}


class Consumer implements Runnable
{
	SharedBuffer s;

	public Consumer (SharedBuffer s)
	{
		this.s=s;
	}

	public void run()
	{
		for(int i=0; i<5; i++)
		{
			s.get();
		}
	}
}

public class Conprod 
{
	public static void main (String [] args) throws InterruptedException
	{
		SharedBuffer sb = new SharedBuffer();

		Thread prod = new Thread(new Produer(sb), "Produer");
		Thread cont = new Thread(new Consumer(sb), "Consumer");
		prod.start();
		cont.start();
	}
}
/*
	acquire() method returns true or false about if a permit is available immediately and acquires it, 
	
	Remember:
		A semaphore is a synchronization object that controls access by multiple processes 
		to a common resource in a parallel programming environment. 
		Mostly used to control access to files and shared memory
*/
import java.util.concurrent.Semaphore;

class ResourceHandler implements Runnable
{
	Semaphore first;
	Semaphore second;

	public ResourceHandler(Semaphore first, Semaphore second)
	{
		this.first=first;
		this.second=second;
	}

	public void run()
	{
		Thread t = Thread.currentThread(); //get the identity of the thread and print it
		try
		{
			first.acquire();
			System.out.println(t + " acquire " + first);

			Thread.sleep(20);

			second.acquire();
			System.out.println(t + " acquire " + second);

			second.release();
			System.out.println(t + " release " + second);

			first.release();
			System.out.println(t + " release " + first);
		}
		catch (InterruptedException e) {
			System.out.println(e);
		}
	}

}

public class Deadlock
{
	public static void main(String[] args) throws InterruptedException
	{
		Semaphore one = new Semaphore(1);
		Semaphore two = new Semaphore(1);

		Thread t1 = new Thread(new ResourceHandler(one,two),"t1");
		Thread t2 = new Thread(new ResourceHandler(two,one),"t2");

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println("We managed to finish!");

		/*			
			Thread[t2,5,main] acquire java.util.concurrent.Semaphore@3e856472[Permits = 0]
			Thread[t1,5,main] acquire java.util.concurrent.Semaphore@1da78047[Permits = 0]
		*/
	}
}
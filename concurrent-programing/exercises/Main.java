/*
	Java synchronized method. If you declare any method as synchronized, it is known as synchronized method.
	 Synchronized method is used to lock an object for any shared resource. 
	 When a thread invokes a synchronized method, it automatically acquires the lock 
	 for that object and releases it when the thread completes its task.
*/

class T extends Thread
{
	Object l;
	public T(Object l)
	{
		this.l=l;
	}

	public void run()
	{
		synchronized(l)
		{
			System.out.println(getName() + " something 1");
			for(int i=0; i<1000;i++)
			{
				System.out.println(getName() + " something 2");
			}

		}

	}
}

public class Main
{
	public static void main(String[] args) 
	{
		Object lock = new Object();
		T t1 = new T(lock);
		T t2 = new T(lock);

		t1.start();
		t2.start();
	}
}
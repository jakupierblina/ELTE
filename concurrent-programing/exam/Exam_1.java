//Erblina Jakupi
//HIGO5T

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.Date;

class HarmonicThreadPool 
{
	private final Worker[] workers; // internal list of threads
	private final LinkedBlockingQueue<Runnable> queue; // queue of tasks
	private boolean stopped = false;

	private final int size;
	private final long base_tick,max_time;
	private long time;


	HarmonicThreadPool(int n,long base_tick, long max_time)
	{
		size = n;
		this.base_tick=base_tick;
		this.max_time=max_time;
		time= base_tick * base_tick;

		workers = new Worker[n];
		queue = new LinkedBlockingQueue<Runnable>();

		for(int i = 0; i<n; i++){
			workers[i] = new Worker();
			workers[i].start();
		}
	}
		
	private class Worker extends Thread
	{
		public void run()
		{
			Runnable task;
			//ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(2);

			while(!(isStopped() && queue.isEmpty()))
			{
				synchronized(queue)
				{
					while(queue.isEmpty())
					{
						try
						{
							//queue.wait();
							//long howlong  = nTime - time;
							Thread.sleep(time);

						}
						catch(InterruptedException e){}
					}
					task = queue.poll();
					//executor.scheduleWithFixedDelay(task, 2, 1, TimeUnit.SECONDS);
					//System.out.println("pretty-print " + new Date() + " by " + Thread.currentThread().getName());
					System.out.println(Thread.currentThread().getName()); //printing the pool and thread
					
				}
				
				try
				{
					task.run();

				}
				catch(RuntimeException e)
				{
					System.out.println("Runtime exception in task "+ task);

				}
			}
		}
	}

	public synchronized boolean isStopped(){ // MUST NOT be changed
		return stopped;
	}
	
	public void execute(Runnable task){ // MUST NOT be changed
		synchronized(queue){
			queue.add(task);
			queue.notify();
		}
	}

	public void update(long nTime)
	{
		//duration time and recived value --> ntime
		if( nTime > max_time)
		{
			System.out.println("Max time exceeded! Shutting down the thread pool");

		} 
		/*
			if the duration of a task is greater than the current time property 
			of the thread pool, it is used to compute a new value for time 
		*/
		else if (nTime > max_time)
		{
			if(time == base_tick)
			{
				time = base_tick * base_tick;
			}
		}
	}


	public void shutdown()
	{
		Thread t;
		synchronized(this)
		{
			stopped = true;
		}
		try
		{
			for(int i = 0; i<size; i++)
			{
				t = workers[i];
				t.join();
			}
		}
		catch(InterruptedException e)
		{
			System.out.println(Thread.currentThread().getName()+ " has stopped");

		}

		System.out.println("Thread pool "+ Thread.currentThread().getName()+ " has shut down");	}
}

class Task implements Runnable
{
	public void run()
	{
		try
		{
    	  Thread.sleep((int)Math.random() * 100);
    	} 
    	catch(InterruptedException ex)
    	{ 
    		System.out.println(ex); 
    	}
    	//System.out.println(new Date());
	}

	//System.out.println("sleeping time " + new Date());
}



public class Exam_1{ // MUST NOT be changed
	public static void main(String[] args){
		HarmonicThreadPool htp = new HarmonicThreadPool(3, 4, 500);
		
		for(int i = 0; i<10; i++){
			Runnable t = new Task();
			htp.execute(t);
		}
		
		htp.shutdown();
	}
}
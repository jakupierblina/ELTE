public class PingPon extends Thread
{
	private String word;
	private int delay;

	public PingPon(String name, String word, int delay)
	{
		super(name); //calling the constructer of the super class
		this.word = word;
		this.delay = delay;
	}


	//add a delay
	public void run()
	{
		try
		{
			//run this much time
			System.out.println(getName()); //printing the thread
			for(int i=0; i<20; i++)
			{
				System.out.println(word);
				Thread.sleep(delay); //static method of the class abstract class thread
			}
		}
		catch(InterruptedException ex)
		{
			return;
		}
	}
	

	public static void main(String [] args)
	{
		
		Thread t1 = new PingPon("Thread1","Ping", 30);
		t1.start();

		Thread t2 = new PingPon("Thread2","Pong", 30);
		t2.start();

	}
}
/*public interface Runnable{

		public void run();
}*/



public class PingPong implements Runnable
{
	

	private String word;
	private int delay;

	public PingPong(String word, int delay)
	{
		this.word = word;
		this.delay = delay;
	}


	//add a delay
	public void run()
	{
		try
		{
			//run this much time
			System.out.println(Thread.currentThread().getName());
			for(int i=0; i<20; i++)
			{
				System.out.println(word);
				Thread.sleep(delay); //static method 
			}
		}
		catch(InterruptedException ex)
		{
			return;
		}
	}
	

	public static void main(String [] args)
	{
		//polimorfizem n runable method

		PingPong ping = new PingPong("Ping", 30);
		Runnable pong = new PingPong("Pong", 30);


		//new PingPon ("Ping", 30). start();

		/*PingPong ping = new PingPong("Ping", 30);
		Runnable pong = new PingPong("Pong", 30);


		Thread t1 = new Thread(ping);
		t1.start();*/

		new Thread(ping).start();

		Thread t2 = new Thread(pong);
		t2.setName("Thread2");
		t2.start();
	}
}
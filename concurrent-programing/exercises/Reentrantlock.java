//import java.util.concurrent.locks;

public interface Lock
{
	public void lock();
	public void unlock();
	public boolean trylock();
}

public class Reentrantlock implements Lock
{
	
}
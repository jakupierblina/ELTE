import java.io.*;
import java.util.*;
import java.net.*;



class ServerThread extends Thread 
{
	private Socket socket = null;
	public ServerThread (Socket socket)
	{
		super("Super ServerThread called!");
		this.socket=socket;
	}

	public void check()
	{
		try 
		{
			System.out.println("Server started to run!");

			DataInputStream input = new DataInputStream(socket.getInputStream());
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());

			String message= "HI!";
			output.writeUTF(message);
			String got = input.readUTF();
			String who = input.readUTF();


			System.out.println(got);
			System.out.println("Connected: " + who);

			String file = "out.data";
			User user = (User) Serialization.deserialize(file);
			ArrayList<User> users = new ArrayList<>();

			int index = (int) (Math.random()* users.size());

			for (User i: users)
			{
				System.out.println(i.getUserName());
			}

		}
 		catch(IOException e)
 		{
 			System.err.println("Catched an IOException!");
 		}catch(ClassNotFoundException e)
 		{
			System.err.println("Catched an ClassNotFoundException!");
		}
	}
}

public class Server 
{
	private int localHost=1234;
	private ServerSocket tmp = null;

	public void run() throws IOException
	{
		try
		{
			tmp = new ServerSocket(localHost);
		} catch(IOException e)
		{
			System.err.println("Exception with the port!");
			System.exit(1);
		}

		while(true)
		{
			Socket conn = tmp.accept();
			ServerThread serverthread = new ServerThread(conn);
			serverthread.start();
		}
	}


	public static void main(String [] args ) throws IOException 
	{

		try 
		{
			Server server = new Server();
			server.run();
			System.out.println("SERVER STARTED");
		} 
		catch(IOException e)
		{
			System.err.println("Catched exception with Server!");
		}
	}
}

import java.io.*;
import java.util.*;
import java.net.*;

public class Client
{
	private Socket socket = null;
	private InetAddress innetadress;
	private String name;
	private int localhost=1234;

	public Client(String name)
	{
		this.name=name;
	}

	public void run() throws IOException 
	{
		innetadress = InetAddress.getByName("local host");
		socket = new Socket(innetadress, localhost);

		try 
		{
			DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message= "HI!";
            output.writeUTF(message);
            output.flush();
            output.writeUTF(name);
            output.flush();

            String got = input.readUTF();
            System.out.println(got);
           	String file = "out.data";
			User user = new User("Erblina","jakupi@gmail.com","myname",new Date(1995-01-19), 25);
			Serialization.serialize(user,file);

			System.out.println("Connection with Server established");

		}
		catch(IOException e)
		{

			System.out.println("I/O Exception");

		}finally
		{
			socket.close();
		}

	}

	public static void main(String[] args) throws IOException, ClassNotFoundException 
	{	
		//Since we declared everything to be run in the head of Client class we need an instance of it and after that call the function 
		Client c = new Client("Erblina");
		
		c.run();	
	
	}
}

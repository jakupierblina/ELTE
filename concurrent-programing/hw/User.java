import java.io.*;
import java.util.*;
import java.net.*;


public class User implements Serializable 
{
	private String username;
	private String email;
	private String password;
	private Date reg_date;
	private int age;

	public User(String username,String email, String password, Date reg_date, int age)
	{
		this.username=username;
		this.email=email;
		this.password=password;
		this.reg_date=reg_date;
		this.age=age;
	}

	public void setUserName(String username)
	{
		this.username=username;
	}

	public void setEmail(String email)
	{
		this.email=email;
	}

	public void setPassword(String password)
	{
		this.password=password;
	}

	public void setRegDate(Date reg_date)
	{
		this.reg_date=reg_date;
	}
	public void setAge(int age){
		this.age=age;
	}

	public String getUserName()
	{
		return this.username;
	}

	public String getEmail()
	{
		return this.email;
	}

	public String getPassword()
	{
		return this.password;
	}

	public Date getRegDate()
	{
		return this.reg_date;
	}

	public int getAge(){
		return this.age;
	}

	public boolean equals(Object o)
	{
		if(this == o)
		{
			return true;
		}
		if( o == null || getClass() != o.getClass() )
		{
			return false;
		}

		User tmp = (User) o;
		return Objects.equals(username, tmp.username) && Objects.equals(email, tmp.email);
	}

	public String toString()
	{
		return "username: " + username + "email: " + email + "date: "+ reg_date + "age: " + age;
	}

}

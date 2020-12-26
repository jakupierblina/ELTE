
package Ticket;

/*
	The class GoldenTicket should have the following methods:
		- public class GoldenTicket
		- Constructors:
			- new GoldenTicket();
			- new GoldenTicket(String code, Date raffled)
		- Getters and Setters
		- If the current ticket has been already raffled: boolean isRaffled()
		
 */


import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;


public class GoldenTicket 
{
	//attributes
	private String code;
	private Date raffled;
	private SimpleDateFormat tmp;
	
	//Constructors
	public GoldenTicket() { }
	
	public GoldenTicket(String code,Date raffled)
	{
		this.code=code;
		this.raffled=raffled;
	}
	
	/*Getters & Setters */
	public void setCode(String code)
	{
		this.code=code;
	}
	public String getCode()
	{
		return code;
	}
	public void setRaffled(Date raffled)
	{
		this.raffled=raffled;
	}
	public Date getRaffled()
	{
		return raffled;
	}
	
	//If the current ticket has been already raffled
	public boolean isRaffled()
	{
		return 	getRaffled()!=null;
	}
	
	@Override
	public String toString()
	{
		return this.code +", date"+ (this.raffled).toString();
	}
}
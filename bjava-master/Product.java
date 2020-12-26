
package Registration;

import Ticket.GoldenTicket;


public class Product 
{
	private String description;
	private long barcode;
	private String serialNumber;
	private GoldenTicket prizeTicket;
	
	//Constructor
	public Product () { }
	
	public Product (String description,int barcode,String serialNumber)
	{
		this.description=description;
		this.barcode=barcode;
		this.serialNumber=serialNumber;
		this.prizeTicket= null;
	}
	/*
	public Product (String description,int barcode, String serialNumber GoldenTicket prizeTicket )
	{
		this.description=description;
		this.barcode=barcode;
		this.serialNumber=serialNumber;
		this.prizeTicket=prizeTicket;
	}
	*/
	
	/* Getters & Setters */
	
	public void setDescription(String description)
	{
		this.description=description;
	}
	public String getDescription()
	{
		return description;
	}
	
	public void setBarcode(long barcode)
	{
		this.barcode=barcode;
	}
	public long getBarcode()
	{
		return barcode;
	}
	
	public void setSerialNumber(String serialNumber)
	{
		this.serialNumber=serialNumber;
	}
	public String getSerialNumber()
	{
		return serialNumber;
	}
	
	public void setPrizeTicket(GoldenTicket prizeTicket)
	{
		this.prizeTicket=prizeTicket;
	}
	public GoldenTicket getPrizeTicket()
	{
		return prizeTicket;
	}
	
	public boolean isGolden()
	{
		if (prizeTicket != null){
			return true;
		}
		
		return false;
	}
	
	@Override
	
	public String toString(){
		
		return description +"," +barcode+ "," + ", prize ticket" + prizeTicket;
	}
	
}
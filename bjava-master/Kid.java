
package Registration;

//Kid (code, birthday, name, list of purchased products, place of birth)


import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;


public class Kid extends Beings
{

	private Date birthday;
	private ArrayList<Product> kidsProduct;
	private String birthPlace;
	
	//Constructor
	
	//public Kid(){ }
	
	public Kid(int code, String name, Date birthday, String birthPlace){
		super(code,name);
		
		this.birthPlace = birthPlace;
		kidsProduct = new ArrayList<>();
	}
	
    public Kid(int code, String name, String date, String birthPlace) throws Exception{
		super(code, name);
		
		SimpleDateFormat tmp = new SimpleDateFormat("YYYY-mm-dd");
		this.birthday=tmp.parse(date);
		
		this.birthPlace = birthPlace;
		kidsProduct = new ArrayList<>();
	}
	
	
	
	/* Getters & Setters */
	
	public void setBirthPlace(String birthPlace)
	{
		this.birthPlace=birthPlace;
	}
	public String getBirthPlace()
	{
		return birthPlace;	
	}
	
	public void setBirthday(String date) throws ParseException
	{	
		SimpleDateFormat tmp = 	new SimpleDateFormat("YYYY-mm-dd");
	    birthday=tmp.parse(date);
	}
	public Date getBirthday()
	{
		return birthday;
	}
	
	public void setKidsProduct(ArrayList<Product> kidsProduct)
	{	
		this.kidsProduct=kidsProduct;	
	}
	public ArrayList<Product> getKidsProduct()
	{
		return kidsProduct;
	}
	
	
	public void addProduct(Product p)
	{
		kidsProduct.add(p);
		System.out.println("The product is added in arraylist!");
	}
	
	//check wether a kid has a golden ticket
	public boolean GoldenTicket()
	{
		for(Product p : kidsProduct)
		{
			if(p.isGolden())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		return false;
		
		
	}
	
	
	@Override
	public String toString()
	{
		if (GoldenTicket() == true )
		{
			return 	super.toString()+ " \n " +
				" birthday; "	+birthday.toString()+
				" birth place; " + birthPlace +
				" (with golden ticket) products; " +
				this.getKidsProduct();
		}
		else 
		{
			return 	super.toString()+ " " +
				" birthday; "	+birthday.toString()+
				" birth place; " + birthPlace +
				" (without golden ticket) products; " +
				this.getKidsProduct();
		}
	}

	
}
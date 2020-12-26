
package Registration;

//Beings abstract class for the common atributes

public abstract class Beings
{
	
	private int code;
	private String name;
	
	//Constructor
	public Beings(int code,String name)
	{
		this.code=code;
		this.name=name;
	}
	
	
	/* Getters & Setters */
	
	public void setCode(int code)
	{
		this.name=name;
	}
	public int getCode()
	{
		return code;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	
	
	@Override
	public String toString()
	{
		return code + "," + name;
		
	}
	
	@Override
	public boolean equals(Object that){
		
		if(this==that)
		{
			return true;
		}
		
		if(that instanceof Beings)
		{
			return this.name.equals(((Beings)that).getName())&&this.code==((Beings)that).getCode();
		}
		
		return false;
	}
		
}